import { Component, OnInit } from '@angular/core';

import { CommentaireService } from '../services/commentaire.service';
import { Commentaire } from 'src/app/core/commentaire/interfaces/commentaire.vo';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from '../../../jwt/_services/token-storage.service';


@Component({
  selector: 'app-commentaire',
  templateUrl: './commentaire.component.html',
  styleUrls: ['./commentaire.component.scss']
})
export class CommentaireComponent implements OnInit {

  commentaires : Array<Commentaire>;
  show: boolean;


  constructor(
    private commentaireService: CommentaireService,
    private route: ActivatedRoute,
    private tokenStorageService: TokenStorageService
  ) {
    this.show = false;
  }

  ngOnInit(): void {
    console.log("NgOnInit commentaire")
    this.retrieveCommentaires(Number(this.route.snapshot.paramMap.get('id')));
    this.getInformationConnexion();
  }


  /**
   * Récupération des Plats d'un restaurant
   */
  retrieveCommentaires(idRestaurant: number): void{
    console.log("retrieveCommentaires " + idRestaurant);
    this.commentaireService.findRestaurantCommentaire(idRestaurant).subscribe(
      (data: Commentaire[]) => {
        this.commentaires = data;
        console.log(data);
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
}
