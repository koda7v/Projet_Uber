import { NgModule, LOCALE_ID } from '@angular/core';
import { registerLocaleData } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';
import localeFr from '@angular/common/locales/fr';

import { MatIconRegistry } from '@angular/material/icon';
import { MatPaginatorIntl } from '@angular/material/paginator';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AppLayoutModule } from './layout/app-layout.module';
import { paginatorFrench } from './material-intl/paginator-fr';
import { LoginComponent } from './jwt/login/login.component';
import { RegisterComponent } from './jwt/register/register.component';
import { HomeComponent } from './jwt/home/home.component';
import { ProfileComponent } from './jwt/profile/profile.component';
import { BoardAdminComponent } from './jwt/board-admin/board-admin.component';
import { BoardModeratorComponent } from './jwt/board-moderator/board-moderator.component';
import { BoardUserComponent } from './jwt/board-user/board-user.component';

import { authInterceptorProviders } from './jwt/_helpers/auth.interceptor';
import { ListePanierPlatsComponent } from './panier/component/liste-panier-plats/liste-panier-plats.component';

registerLocaleData(localeFr, 'fr');

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    ListePanierPlatsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppLayoutModule,
    FormsModule
  ],
  providers: [
    authInterceptorProviders,
    { provide: LOCALE_ID, useValue: 'fr' },
    { provide: MatPaginatorIntl, useClass: paginatorFrench }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(iconRegistry: MatIconRegistry, domSanitizer: DomSanitizer) {
    iconRegistry.addSvgIconSet(
      domSanitizer.bypassSecurityTrustResourceUrl('./assets/mdi.svg')
    );
  }
}
