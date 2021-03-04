import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadcrumbService } from 'xng-breadcrumb';
import { MatSnackBar } from '@angular/material/snack-bar';

import { RestaurantService } from 'src/app/core/restaurant/services/restaurant.service';

import { FileValidator } from 'ngx-material-file-input';


@Component({
  selector: 'app-restaurant-edit',
  templateUrl: './restaurant-edit.component.html',
  styleUrls: ['./restaurant-edit.component.scss']
})
export class RestaurantEditComponent implements OnInit {

  pageTitle = 'Editer un restaurant';

  idRestaurant: number;
  editFormRestaurant: FormGroup;
  editFormPhoto: FormGroup;
  data: string;

  readonly maxSize = 52000;

  constructor(
    private formBuilder: FormBuilder,
    private breadcrumbService: BreadcrumbService,
    private restaurantService: RestaurantService,
    private route: ActivatedRoute,
    private router: Router,
    private snackBar: MatSnackBar
    ) { }

  ngOnInit(): void {
    this.initFormBuilder();
    this.retrieveRestaurant(+this.route.snapshot.paramMap.get('id'));
  }

  /**
   * Initialisation du formulaire permettant de modifier les informations d'une personne
   *
   */
  private initFormBuilder(): void {
    this.editFormRestaurant = this.formBuilder.group({
      nom: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
    });
    this.editFormPhoto = this.formBuilder.group({
      name: new FormControl('', Validators.required),
      photo: new FormControl(undefined, FileValidator.maxContentSize(this.maxSize)),
      commentaire: new FormControl('', Validators.required),
    });
  }

  /**
   * Récupérer une personne en fonction de son id
   * @param id d'une personne
   */
  private retrieveRestaurant(id: number): void {
    this.restaurantService.get(id).subscribe(
      (data) => {
        this.idRestaurant = data.id;
        console.log(data);
        this.editFormRestaurant.patchValue(data);
        this.editFormPhoto.patchValue({
          name: data.photo.name,
          commentaire: data.photo.commentaire,
        });
      },
      (error) => {
        console.log(error);
      }
    );
  }

  /**
   * Mise à jour d'un restaurant
   *
   */
  updateRestaurant(): void {
    console.log('la');
    if (this.editFormPhoto.valid && this.editFormRestaurant.valid) {
      let snackBarMessage = '';
      this.restaurantService.update(this.idRestaurant, this.editFormRestaurant.value, this.editFormPhoto.value, this.data).subscribe(
        (response) => {
          console.log(response);
          snackBarMessage = 'Le restaurant a bien été mis à jour';
        },
        (error) => {
          console.log(error);
          // tslint:disable-next-line:quotemark
          snackBarMessage = "Erreur lors de la mise à jour du restaurant";
        },
        () => {
          this.snackBar.open(snackBarMessage, 'OK', {
            duration: 5000
          });
          this.router.navigate(['/gestionRestaurant']);
        }
      );
    }
  }

  handleUpload(event): void {
    const me = this;
    const file = event.target.files[0];
    const reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
      const d = reader.result as string;
      me.data = d.replace(/^data:image\/[a-z]+;base64,/, '');
    };
  }

}
