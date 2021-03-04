import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Commentaire } from 'src/app/core/commentaire/interfaces/commentaire.vo';

const baseUrl = 'http://localhost:8081/commentaire';

@Injectable({
  providedIn: 'root'
})
export class CommentaireService {

  constructor(private http: HttpClient) { }

  /**
   * Récupération de toutes les commentaires.
   */
  getAll(): Observable<Commentaire[]> {
    return this.http.get<Commentaire[]>(baseUrl);
  }

  findRestaurantCommentaire(idRestaurant: number) : Observable<Commentaire[]> {
    return this.http.get<Commentaire[]>(`${baseUrl}/restaurant/${idRestaurant}`);
  }
}
