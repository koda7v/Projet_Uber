import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';

import { PlatService } from 'src/app/core/plat/services/plat.service';
import { ListPlatComponent } from './views/list-plat/list-plat.component';
import { ListePanierPlatsComponent } from '../panier/component/liste-panier-plats/liste-panier-plats.component';

export const platRouteList: Routes = [
  {
    path: '',
    component: ListPlatComponent,
    data: {
      breadcrumb: 'Plats'
    }
  }
];

@NgModule({
  declarations: [ListPlatComponent, ListePanierPlatsComponent],
  providers: [PlatService],
  imports: [
    RouterModule.forChild(platRouteList),
    CommonModule,
    MatCardModule,
    MatGridListModule
  ]
})
export class PlatModule { }
