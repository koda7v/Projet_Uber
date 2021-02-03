import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NotFoundComponent } from 'src/app/layout/not-found/not-found.component';

const routes: Routes = [
  {
    path: 'clients',
    loadChildren: () =>
      import('./core/client/client.module').then((m) => m.ClientModule)
  },
  { path: '404', component: NotFoundComponent },
  { path: '**', redirectTo: '/404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
