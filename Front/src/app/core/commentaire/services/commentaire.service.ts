import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Commentaire } from 'src/app/core/commentaire/interfaces/commentaire.vo';
import { UserC } from '../interfaces/userC.vo';

const baseUrl = 'http://localhost:8081/commentaire';
const baseUrl2 = 'http://localhost:8081/user';

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

  findRestaurantCommentaire(idRestaurant: number): Observable<Commentaire[]> {
    return this.http.get<Commentaire[]>(`${baseUrl}/restaurant/${idRestaurant}`);
  }

  findUser(idUser: number): Observable<UserC>{
    return this.http.get<UserC>(`${baseUrl2}/${idUser}`);
  }

  create(text: string, idUser: number, idResto: number ): Observable<void> {
    let parametres = new HttpParams();
    parametres = parametres.append('texte', text);
    parametres = parametres.append('idUser', idUser.toString());
    parametres = parametres.append('idResto', idResto.toString());
    return this.http.post<void>(`${baseUrl}`, parametres);
  }

}
