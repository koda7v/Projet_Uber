import { Component } from '@angular/core';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent {
  items: unknown[];

  constructor() {
    this.items = [
      { title: 'Gestion des Clients', route: '/clients', icon: 'person' },
      { title: 'Voir les plats', route: '/plats', icon: 'dining' },
    ];
  }
}
