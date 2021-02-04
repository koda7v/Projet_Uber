import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NotFoundComponent } from 'src/app/layout/not-found/not-found.component';

const routes: Routes = [
  {
    path: 'clients',
    loadChildren: () =>
      import('./core/client/client.module').then((m) => m.ClientModule)
  },
  {
    path: 'plats',
    loadChildren: () =>
      import('./core/plat/plat.module').then((m) => m.PlatModule)
  },
  { path: '404', component: NotFoundComponent },
  { path: '**', redirectTo: '/404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
