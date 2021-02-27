import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';

import { RestaurantService } from 'src/app/core/restaurant/services/restaurant.service';
import { ListRestaurantComponent } from 'src/app/core/restaurant/components/list-restaurant/list-restaurant.component';

export const restaurantRouteList: Routes = [
  {
    path: '',
    component: ListRestaurantComponent,
    data: {
      breadcrumb: 'Restaurants'
    }
  }
];


@NgModule({
  declarations: [ListRestaurantComponent],
  providers: [RestaurantService],
  imports: [
    RouterModule.forChild(restaurantRouteList),
    CommonModule,
    MatCardModule,
    MatGridListModule
  ]
})
export class RestaurantModule { }
