
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Panier } from '../../panier/interfaces/panier.vo';
import { HistoriqueCommande } from '../interface/historique.vo';

const baseUrl = 'http://localhost:8081/historique';

@Injectable({
  providedIn: 'root'
})
export class HistoriqueCommandeService {

  constructor(private http: HttpClient) { }

    /**
   * Récupération d'un Historique de commande.
   * @param id ID d'un panier à récupérer.
   */
  get(id: number): Observable<HistoriqueCommande> {
    return this.http.get<HistoriqueCommande>(`${baseUrl}/${id}`);
  }

    /**
   * Récupération de toutes les historiques des commandes.
   */
  getAll(): Observable<HistoriqueCommande[]> {
    return this.http.get<HistoriqueCommande[]>(baseUrl);
  }

  /**
   * Ajout d'un panier à l'historique de commande
   */
  addPanierToHistorique(idUser:number) {
    let parametres = new HttpParams();
    parametres = parametres.append('idUser', idUser.toString())      

    return this.http.post<Panier>(`${baseUrl}`, parametres);
  }

  retrievePaniersFromUsers(idUser:number) {
      return this.http.get<Panier[]>(`${baseUrl}/paniers/${idUser}`);
  }
}




