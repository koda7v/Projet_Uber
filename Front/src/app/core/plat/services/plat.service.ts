import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Plat } from 'src/app/core/plat/interfaces/plat.vo';

const baseUrl = 'http://localhost:8081/plat';

@Injectable({
  providedIn: 'root'
})
export class PlatService {
  constructor(private http: HttpClient) {}

  /**
   * Récupération de toutes les Plats.
   */
  getAll(): Observable<Plat[]> {
    return this.http.get<Plat[]>(baseUrl);
  }

  /**
   * Récupération d'un plat.
   * @param id ID d'un plat à récupérer.
   */
  get(id: number): Observable<Plat> {
    return this.http.get<Plat>(`${baseUrl}/${id}`);
  }

}
