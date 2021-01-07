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
      { title: 'Accueil', route: '/accueil', icon: 'dashboard' },
      { title: 'Gestion des Personnes', route: '/personnes', icon: 'person' },
      {
        title: 'Gestion des Habilitations',
        route: '/habilitations',
        icon: 'assignment'
      },
      { title: 'Gestion des Formations', route: '/formations', icon: 'school' }
    ];
  }
}
