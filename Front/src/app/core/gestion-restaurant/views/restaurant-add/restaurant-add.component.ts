import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { BreadcrumbService } from 'xng-breadcrumb';
import { MatSnackBar } from '@angular/material/snack-bar';

import { RestaurantService } from 'src/app/core/restaurant/services/restaurant.service';

import { FileValidator } from 'ngx-material-file-input';

@Component({
  selector: 'app-restaurant-add',
  templateUrl: './restaurant-add.component.html',
  styleUrls: ['./restaurant-add.component.scss']
})
export class RestaurantAddComponent implements OnInit {
  addFormRestaurant: FormGroup;
  addFormPhoto: FormGroup;
  data: string;

  readonly maxSize = 52000;

  constructor(
    private formBuilder: FormBuilder,
    private breadcrumbService: BreadcrumbService,
    private restaurantService: RestaurantService,
    private router: Router,
    private snackBar: MatSnackBar,
  ) {  }

  ngOnInit(): void {
    this.initFormBuilder();
  }

  private initFormBuilder(): void {
    this.addFormRestaurant = this.formBuilder.group({
      nom: new FormControl('', Validators.required),
      description: new FormControl('', Validators.required),
    });
    this.addFormPhoto = this.formBuilder.group({
      name: new FormControl('', Validators.required),
      photo: new FormControl(undefined, [Validators.required, FileValidator.maxContentSize(this.maxSize)]),
      commentaire: new FormControl('', Validators.required),
    });
  }

  saveRestaurant(): void {
    if (this.addFormPhoto.valid && this.addFormRestaurant.valid) {
      let snackBarMessage = '';
      this.restaurantService.create(this.addFormRestaurant.value, this.addFormPhoto.value, this.data).subscribe(
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
