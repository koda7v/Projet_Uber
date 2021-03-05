import { Component, OnInit, ViewChild } from '@angular/core';

import { CommentaireService } from '../services/commentaire.service';
import { Commentaire } from 'src/app/core/commentaire/interfaces/commentaire.vo';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../../../jwt/_services/token-storage.service';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';



@Component({
  selector: 'app-commentaire',
  templateUrl: './commentaire.component.html',
  styleUrls: ['./commentaire.component.scss']
})
export class CommentaireComponent implements OnInit {

  commentaires: Array<Commentaire>;
  show: boolean;
  panelOpenState = false;
  addFormCommentaire: FormGroup;
  idResto: number;
  numberOfCharacters = 0;
  maxNumberOfCharacters = 500;

  constructor(
    private commentaireService: CommentaireService,
    private route: ActivatedRoute,
    private tokenStorageService: TokenStorageService,
    private formBuilder: FormBuilder,
    private token: TokenStorageService,
    private snackBar: MatSnackBar,
    private router: Router,
  ) {
    this.show = false;
  }

  ngOnInit(): void {
    this.retrieveCommentaires(Number(this.route.snapshot.paramMap.get('id')));
    this.getInformationConnexion();
    this.initFormBuilder();
  }

  private initFormBuilder(): void {
    this.addFormCommentaire = this.formBuilder.group({
      commentaire: new FormControl('', Validators.required),
    });
  }


  /**
   * Récupération des Plats d'un restaurant
   */
  retrieveCommentaires(idRestaurant: number): void{
    this.idResto = idRestaurant;
    this.commentaireService.findRestaurantCommentaire(idRestaurant).subscribe(
      (data: Commentaire[]) => {
        this.commentaires = data;
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }


  getInformationConnexion(): void{
    if (sessionStorage.getItem('auth-token') === null){
      this.show = false;
    }else{
      const user = this.tokenStorageService.getUser();
      if (user.roles.includes('ROLE_USER')){
        this.show = true;
      }
    }
  }

  onModelChange(textValue: string): void {
    this.numberOfCharacters = textValue.length;
  }

  add(): void{
    if (this.addFormCommentaire.valid) {
      let snackBarMessage = '';
      this.commentaireService.create(this.addFormCommentaire.value.commentaire, this.token.getUser().id, this.idResto).subscribe(
        (response) => {
          console.log(response);
          snackBarMessage = 'Le commentaire a bien été ajouté';
        },
        (error) => {
          console.log(error);
          // tslint:disable-next-line:quotemark
          snackBarMessage = "Erreur lors de l'ajout du restaurant";
        },
        () => {
          this.snackBar.open(snackBarMessage, 'OK', {
            duration: 5000
          });
          this.router.navigate(['/plats', this.idResto]);
          this.retrieveCommentaires(Number(this.route.snapshot.paramMap.get('id')));
          this.initFormBuilder();
        }
      );
    }
  }


}
