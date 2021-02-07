import { Component } from '@angular/core';
import { TokenStorageService } from '../../jwt/_services/token-storage.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent {
  private roles: string[];
  title = 'UberProjet';
  isLoggedIn = false;
  showAdminBoard = false;
  showModeratorBoard = false;
  username: string;
  items: unknown[];

  constructor(private tokenStorageService: TokenStorageService) {
    this.items = [
      { title: 'Gestion des Clients', route: '/clients', icon: 'person' },
      { title: 'Voir les plats', route: '/plats', icon: 'dining' },
    ];
  }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
  
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
  
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
  
      this.username = user.username;
    }
  }
  
  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}



