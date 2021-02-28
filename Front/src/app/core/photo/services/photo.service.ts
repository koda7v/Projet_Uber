import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Photo } from 'src/app/core/photo/interfaces/photo.vo';

const baseUrl = 'http://localhost:8081/photo';

@Injectable({
  providedIn: 'root'
})
export class PhotoService {
  constructor(private http: HttpClient) {}

  /**
   * Récupération de toutes les photos.
   */
  getAll(): Observable<Photo[]> {
    return this.http.get<Photo[]>(baseUrl);
  }

  /**
   * Récupération d'une photo.
   * @param id ID d'une photo à récupérer.
   */
  get(id: number): Observable<Photo> {
    return this.http.get<Photo>(`${baseUrl}/${id}`);
  }
}