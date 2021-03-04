import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Panier } from 'src/app/core/panier/interfaces/panier.vo';
 
const baseUrl = 'http://localhost:8081/panier';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  constructor(private http: HttpClient) { }

    /**
   * Récupération de toutes les Paniers.
   */
  getAll(): Observable<Panier[]> {
    return this.http.get<Panier[]>(baseUrl);
  }

  /**
   * Récupération d'un Panier.
   * @param id ID d'un panier à récupérer.
   */
  get(id: number): Observable<Panier> {
    return this.http.get<Panier>(`${baseUrl}/${id}`);
  }

  /**
   * Récupère les plats d'un panier
   * @param idUser 
   */
  findPlatFromPanier(idUser: number): Observable<Panier[]> {
    return this.http.get<Panier[]>(`${baseUrl}/plats/${idUser}`);
  }

  findUserPanier(id: number): Observable<Panier> {
    return this.http.get<Panier>(`${baseUrl}/user/${id}`);
  }

  addPlatToUserPanier()
}
