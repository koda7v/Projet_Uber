import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

import { PlatService } from 'src/app/core/plat/services/plat.service';
import { ListPlatComponent } from './views/list-plat/list-plat.component';

import {CommentaireComponent } from 'src/app/core/commentaire/commentaire/commentaire.component';


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
  declarations: [ListPlatComponent, CommentaireComponent],
  providers: [PlatService],
  imports: [
    RouterModule.forChild(platRouteList),
    CommonModule,
    MatCardModule,
    MatGridListModule,
    MatInputModule,
    MatFormFieldModule
  ]
})
export class PlatModule { }
