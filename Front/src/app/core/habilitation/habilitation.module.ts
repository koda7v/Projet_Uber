import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { HabilitationComponent } from './habilitation.component';

export const habilitationRouteList: Routes = [
  {
    path: '',
    component: HabilitationComponent
  }
];

@NgModule({
  declarations: [HabilitationComponent],
  imports: [CommonModule, RouterModule.forChild(habilitationRouteList)]
})
export class HabilitationModule {}
