import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Personne } from 'src/app/core/personne/interfaces/personne.vo';

const baseUrl = 'http://localhost:8081/personne';

@Injectable({
  providedIn: 'root'
})
export class PersonneService {
  constructor(private http: HttpClient) {}

  /**
   * Récupération de toutes les Personnes.
   */
  getAll(): Observable<Personne[]> {
    return this.http.get<Personne[]>(baseUrl);
  }

  /**
   * Récupération d'une Personne.
   * @param id ID de la personne à récupérer.
   */
  get(id: number): Observable<Personne> {
    return this.http.get<Personne>(`${baseUrl}/${id}`);
  }

  /**
   * Création d'une Personne.
   * @param personne Nouvelle personne à créer.
   */
  create(personne: Personne): Observable<Personne> {
    return this.http.post<Personne>(`${baseUrl}`, personne);
  }

  /**
   * Mise à jour d'un objet Personne.
   * @param data Personne mise à jour.
   */
  update(id: number, personne: Personne): Observable<Personne> {
    return this.http.put<Personne>(`${baseUrl}/${id}`, personne);
  }

  /**
   * Supression d'une Personne.
   * @param id ID de la personne à supprimer.
   */
  delete(id: number): Observable<Personne> {
    return this.http.delete<Personne>(`${baseUrl}/${id}`);
  }
}
