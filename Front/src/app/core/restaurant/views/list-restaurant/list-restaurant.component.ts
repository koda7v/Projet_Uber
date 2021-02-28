import { Component, OnInit } from '@angular/core';
import { Restaurant } from '../../interfaces/restaurant.vo';
import { RestaurantService } from '../../services/restaurant.service';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-list-restaurant',
  templateUrl: './list-restaurant.component.html',
  styleUrls: ['./list-restaurant.component.scss']
})
export class ListRestaurantComponent implements OnInit {

  breadcrumb = false;
  restaurants: Array<Restaurant>;
  idRestaurant: String;

  constructor(private restaurantService: RestaurantService, 
    private router: Router,
    private route: ActivatedRoute,) { }

  ngOnInit(): void {
    this.retrieveRestaurants();
    this.idRestaurant = this.route.snapshot.paramMap.get('id');
  }

  /**
   * Récupération des Restaurants.
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

  findPlatsWithRestaurantId(id: number) {
    this.restaurantService.findPlatsWithRestaurantId(id).subscribe(
      (data: Restaurant[]) => {
        this.restaurants = data;
        console.log(data);
        //this.router.navigate(['plats'], { relativeTo: this.route });
      },
      (error: Observable<never>) => {
        console.log(error);
      }
    );
  }

}
