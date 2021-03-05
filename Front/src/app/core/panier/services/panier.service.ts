import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Panier } from 'src/app/core/panier/interfaces/panier.vo';
import { Plat } from '../../plat/interfaces/plat.vo';
 
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
  findPlatFromPanier(idUser: number): Observable<Plat[]> {
    return this.http.get<Plat[]>(`${baseUrl}/plats/${idUser}`);
  }

  /**
   * 
   * @param id du panier
   */
  findUserPanier(id: number): Observable<Panier> {
    return this.http.get<Panier>(`${baseUrl}/user/${id}`);
  }

  /**
   * 
   * @param idUser id du user
   * @param idPlat id du plat
   */
  addPlatToUserPanier(idUser:number, idPlat:number) {

    let parametres = new HttpParams();
    parametres = parametres.append('idUser', idUser.toString())      
    parametres = parametres.append('idPlat', idPlat.toString())

    return this.http.post<Panier>(`${baseUrl}`, parametres);
  }

    /**
   * 
   * @param idUser id du user
   * @param idPlat id du plat
   */
  deletePlatFromActivePanier(idUser:number, idPlat:number) {

    let parametres = new HttpParams();
    parametres = parametres.append('idUser', idUser.toString())      
    parametres = parametres.append('idPlat', idPlat.toString())
    const option = {
      params: parametres
    };

    return this.http.delete<Plat>(`${baseUrl}/delete`, option);
  }

  updatePanierTotal(idUser:number, total:number) {
    let parametres = new HttpParams();
    parametres = parametres.append('idUser', idUser.toString())     
    parametres = parametres.append('total', total.toString())  

    return this.http.put<Panier>(`${baseUrl}/updateTotal`, parametres);
  }
}
