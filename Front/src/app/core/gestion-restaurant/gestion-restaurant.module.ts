import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GestionRestaurantsComponent } from './views/gestion-restaurants/gestion-restaurants.component';

import { RouterModule, Routes } from '@angular/router';

import { MatTabsModule } from '@angular/material/tabs';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatDividerModule } from '@angular/material/divider';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatSnackBarModule } from '@angular/material/snack-bar';

import { BreadcrumbModule } from 'xng-breadcrumb';
import { SearchRestaurantFieldComponent } from './components/search-restaurant-field/search-restaurant-field.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { RestaurantAddComponent } from './views/restaurant-add/restaurant-add.component';
import { RestaurantEditComponent } from './views/restaurant-edit/restaurant-edit.component';
import { MaterialFileInputModule } from 'ngx-material-file-input';

export const restaurantRouteList: Routes = [
  {
    path: '',
    component: GestionRestaurantsComponent,
    data: {
      breadcrumb: 'Restaurants'
    }
  },
   {
    path: 'ajouterRestaurant',
     component: RestaurantAddComponent,
     data: {
       breadcrumb: 'Ajout'
     }
   },
  {
    path: 'editer/:id',
    component: RestaurantEditComponent,
    data: {
      breadcrumb: 'Editer'
    }
  },
  // {
  //   path: ':id',
  //   component: PersonneDetailsComponent,
  //   data: {
  //     breadcrumb: {
  //       alias: 'personneName'
  //     }
  //   }
  // }
];

@NgModule({
  declarations: [GestionRestaurantsComponent, SearchRestaurantFieldComponent, RestaurantAddComponent, RestaurantEditComponent],
  imports: [
    CommonModule,
    RouterModule.forChild(restaurantRouteList),
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatTooltipModule,
    MatTabsModule,
    MatDividerModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatCheckboxModule,
    BreadcrumbModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatSnackBarModule,
    MaterialFileInputModule
  ]
})
export class GestionRestaurantModule { }
