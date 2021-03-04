import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { MatCardModule } from '@angular/material/card';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatButtonModule } from '@angular/material/button';

import { PanierService } from 'src/app/core/panier/services/panier.service';
import { ListePanierPlatsComponent } from 'src/app/core/panier/component/liste-panier-plats/liste-panier-plats.component';

export const panierRouteList: Routes = [
  {
    path: '',
    component: ListePanierPlatsComponent,
    data: {
      breadcrumb: 'Panier'
    }
  }
];

@NgModule({
  declarations: [ListePanierPlatsComponent],
  providers: [PanierService],
  imports: [
    RouterModule.forChild(panierRouteList),
    CommonModule,
    MatCardModule,
    MatGridListModule,
    MatButtonModule
  ]
})
export class PanierModule { }








