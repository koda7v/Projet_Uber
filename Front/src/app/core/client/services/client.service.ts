import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Client } from 'src/app/core/client/interfaces/client.vo';

const baseUrl = 'http://localhost:8081/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  constructor(private http: HttpClient) {}

  /**
   * Récupération de toutes les Clients.
   */
  getAll(): Observable<Client[]> {
    return this.http.get<Client[]>(baseUrl);
  }

  /**
   * Récupération d'un Client.
   * @param id ID d'un client à récupérer.
   */
  get(id: number): Observable<Client> {
    return this.http.get<Client>(`${baseUrl}/${id}`);
  }

  /**
   * Création d'un Client.
   * @param client Nouveau Client à créer.
   */
  create(client: Client): Observable<Client> {
    return this.http.post<Client>(`${baseUrl}`, client);
  }

  /**
   * Mise à jour d'un objet Client.
   * @param data Client mis à jour.
   */
  update(id: number, client: Client): Observable<Client> {
    return this.http.put<Client>(`${baseUrl}/${id}`, client);
  }

  /**
   * Supression d'un Client.
   * @param id ID di Client à supprimer.
   */
  delete(id: number): Observable<Client> {
    return this.http.delete<Client>(`${baseUrl}/${id}`);
  }
}
