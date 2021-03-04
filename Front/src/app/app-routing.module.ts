import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { NotFoundComponent } from 'src/app/layout/not-found/not-found.component';
import { RegisterComponent } from './jwt/register/register.component';
import { LoginComponent } from './jwt/login/login.component';
import { HomeComponent } from './jwt/home/home.component';
import { ProfileComponent } from './jwt/profile/profile.component';
import { BoardUserComponent } from './jwt/board-user/board-user.component';
import { BoardModeratorComponent } from './jwt/board-moderator/board-moderator.component';
import { BoardAdminComponent } from './jwt/board-admin/board-admin.component';

const routes: Routes = [
  {
    path: 'gestionRestaurant',
    loadChildren: () =>
      import('./core/gestion-restaurant/gestion-restaurant.module').then((m) => m.GestionRestaurantModule)
  },
  {
    path: 'restaurants',
    loadChildren: () =>
      import('./core/restaurant/restaurant.module').then((m) => m.RestaurantModule)
  },
  {
    path:'paniers/:idUser/:idPlat',
    loadChildren: () =>
      import('./core/panier/panier.module').then((m) => m.PanierModule)
  },
  {
    path: 'plats/:id',
    loadChildren: () =>
      import('./core/plat/plat.module').then((m) => m.PlatModule)
  },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '404', component: NotFoundComponent },
  { path: '**', redirectTo: '/404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
