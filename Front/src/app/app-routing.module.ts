import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NotFoundComponent } from 'src/app/layout/not-found/not-found.component';

const routes: Routes = [
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
  {
    path: 'accueil',
    loadChildren: () =>
      import('./core/dashboard/dashboard.module').then((m) => m.DashboardModule)
  },
  {
    path: 'personnes',
    loadChildren: () =>
      import('./core/personne/personne.module').then((m) => m.PersonneModule)
  },
  {
    path: 'habilitations',
    loadChildren: () =>
      import('./core/habilitation/habilitation.module').then(
        (m) => m.HabilitationModule
      )
  },
  {
    path: 'formations',
    loadChildren: () =>
      import('./core/formation/formation.module').then((m) => m.FormationModule)
  },
  { path: '404', component: NotFoundComponent },
  { path: '**', redirectTo: '/404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
