import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { BreadcrumbService } from 'xng-breadcrumb';
import { MatSnackBar } from '@angular/material/snack-bar';

import { RestaurantService } from 'src/app/core/restaurant/services/restaurant.service';
import { Photo } from 'src/app/core/photo/interfaces/photo.vo';

import { FileValidator } from 'ngx-material-file-input';

@Component({
  selector: 'app-restaurant-add',
  templateUrl: './restaurant-add.component.html',
  styleUrls: ['./restaurant-add.component.scss']
})
export class RestaurantAddComponent implements OnInit {
  addForm: FormGroup;
  myFile: Photo;

  readonly maxSize = 40000;

  constructor(
    private formBuilder: FormBuilder,
    private breadcrumbService: BreadcrumbService,
    private restaurantService: RestaurantService,
    private router: Router,
    private snackBar: MatSnackBar,
  ) { }

  ngOnInit(): void {
    this.initFormBuilder();
  }

  private initFormBuilder(): void {
    this.addForm = this.formBuilder.group({
      nom: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
      photo: new FormControl(undefined, [Validators.required, FileValidator.maxContentSize(this.maxSize)]),
    });
  }

  saveRestaurant(): void {
    console.log(this.myFile);
    if (this.addForm.valid) {
      let snackBarMessage = '';
      this.restaurantService.create(this.addForm.value).subscribe(
        (response) => {
          console.log(response);
          snackBarMessage = 'Le restaurant a bien été ajouté';
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
          this.router.navigate(['/gestionRestaurant']);
        }
      );
    }
  }

  getBase64(files: any): void {
    const me = this;
    this.myFile.nom = files[0].name;
    this.myFile.commentaire = files[0].name;
    const file = files[0];
    const reader = new FileReader();
    reader.readAsDataURL(file);
    // tslint:disable-next-line:only-arrow-functions
    reader.onload = function(): void {
      me.myFile.photo = reader.result as string;
      console.log(reader.result);
    };
 }

 handleUpload(event): void {
  const file = event.target.files[0];
  console.log(file.name);
  const reader = new FileReader();
  reader.readAsDataURL(file);
  reader.onload = () => {
      console.log(reader.result);
  };
}

}
