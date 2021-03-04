import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Restaurant } from 'src/app/core/restaurant/interfaces/restaurant.vo';
import { Photo } from 'src/app/core/photo/interfaces/photo.vo';


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

  create(restaurant: Restaurant, photo: Photo, data: string ): Observable<Restaurant> {
    photo.photo = data;
    restaurant.photo = photo;
    return this.http.post<Restaurant>(baseUrl, restaurant);
  }

  /**
   * Mise à jour d'un objet Restaurant
   * @param data Restaurant mise à jour.
   */
  update(id: number, restaurant: Restaurant, photo: Photo, data: string): Observable<Restaurant> {
    photo.photo = data;
    restaurant.photo = photo;
    const params = new HttpParams().set('id', String(id));
    const options = {params};

    return this.http.put<Restaurant>(baseUrl, restaurant, options);
  }

}
