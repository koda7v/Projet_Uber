import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
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

    /**
   * Récupération des Habilitations liées à une Personne.
   * @param idPersonne ID de la Personne.
   */
  findPlatsWithRestaurantId(idRestaurant: number): Observable<Restaurant[]> {
    const params = new HttpParams().set('idRestaurant', idRestaurant.toString());

    return this.http.get<Restaurant[]>(`${baseUrl}/restaurant`, { params });
  }
}
