import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { FormationComponent } from './formation.component';

export const formationRouteList: Routes = [
  {
    path: '',
    component: FormationComponent
  }
];

@NgModule({
  declarations: [FormationComponent],
  imports: [CommonModule, RouterModule.forChild(formationRouteList)]
})
export class FormationModule {}
