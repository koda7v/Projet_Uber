import { Component, OnInit } from '@angular/core';

import { RestaurantService } from 'src/app/core/restaurant/services/restaurant.service';
import { Restaurant } from '../../interfaces/restaurant.vo';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-list-restaurant',
  templateUrl: './list-restaurant.component.html',
  styleUrls: ['./list-restaurant.component.scss']
})
export class ListRestaurantComponent implements OnInit {

  breadcrumb = false;
  restaurants: Array<Restaurant>;

  constructor(
    private restaurantService: RestaurantService
  ) { }

  ngOnInit(): void {
    this.retrieveRestaurants();
  }

  /**
   * Récupération des Restaurant.
   */
  retrieveRestaurants(): void {
    this.restaurantService.getAll().subscribe(
      (data: Restaurant[]) => {
        this.restaurants = data;
        console.log(data);
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }

}
