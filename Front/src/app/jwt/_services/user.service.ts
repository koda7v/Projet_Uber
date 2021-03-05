import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

const API_URL = 'http://localhost:8081/api/test/';

@Injectable({
  providedIn: 'root',
})
export class UserService {

  constructor(private http: HttpClient, private router: Router) { }

  getPublicContent(): void {
    this.router.navigate(['/restaurants']);
  }

  getUserBoard(): void {
    this.router.navigate(['/restaurants']);
  }

  getModeratorBoard(): void {
    this.router.navigate(['/gestionRestaurant']);
  }

  getAdminBoard(): void {
    this.router.navigate(['/gestionRestaurant']);
  }
}
