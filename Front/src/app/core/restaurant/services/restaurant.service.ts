import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Restaurant } from 'src/app/core/restaurant/interfaces/restaurant.vo';

const baseUrl = 'http://localhost:8081/restaurant';

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {
  constructor(private http: HttpClient) {}

  /**
   * Récupération de toutes les Restaurants.
   */
  getAll(): Observable<Restaurant[]> {
    return this.http.get<Restaurant[]>(baseUrl);
  }

  /**
   * Récupération d'un Restaurant.
   * @param id ID d'un restaurant à récupérer.
   */
  get(id: number): Observable<Restaurant> {
    return this.http.get<Restaurant>(`${baseUrl}/${id}`);
  }
}
