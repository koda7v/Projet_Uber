import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatButtonModule } from '@angular/material/button';
import { HistoriqueCommandeComponent } from './view/historique-commande/historique-commande.component';

export const historiqueCommandeRouteList: Routes = [
  {
    path: '',
    component: HistoriqueCommandeComponent,
    data: {
      breadcrumb: 'Historique'
    }
  }
];

@NgModule({
  declarations: [HistoriqueCommandeComponent],
  providers: [HistoriqueCommandeModule],
  imports: [
    RouterModule.forChild(historiqueCommandeRouteList),
    CommonModule,
    MatCardModule,
    MatGridListModule,
    MatButtonModule,
  ]
})
export class HistoriqueCommandeModule { }
