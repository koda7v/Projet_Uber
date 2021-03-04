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
    this.gestionNavigation();
  }

  ngOnInit(): void{
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
      this.username = user.username;
    }
  }

  gestionNavigation(): void{
    const user = this.tokenStorageService.getUser();
    if (user === null || user.roles.includes('ROLE_USER')){
      this.items = [
        { title: 'Voir les restaurants', route: '/restaurants', icon: 'restaurant'},
        { title: 'Historique de commande', route: '/paniers', icon: 'add_shopping_cart'}
      ];
    }else if (user.roles.includes('ROLE_ADMIN')){
      this.items = [
        { title: 'Gestion des Restaurants', route: '/gestionRestaurant', icon: 'dining' }
      ];
    }
  }

  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}



