import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { MatTabsModule } from '@angular/material/tabs';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatDividerModule } from '@angular/material/divider';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { FormsModule } from '@angular/forms';

import { BreadcrumbModule } from 'xng-breadcrumb';
import { SharedModule } from 'src/app/shared/shared.module';

import { ClientService } from 'src/app/core/client/services/client.service';
import { ClientListComponent } from './views/client-list/client-list.component';
import { ClientDetailsComponent } from './views/client-details/client-details.component';
import { SearchClientFieldComponent } from './components/search-client-field/search-client-field.component';

export const clientRouteList: Routes = [
  {
    path: '',
    component: ClientListComponent,
    data: {
      breadcrumb: 'Clients'
    }
  },
  {
    path: ':id',
    component: ClientDetailsComponent,
    data: {
      breadcrumb: {
        alias: 'clientName'
      }
    }
  }
];

@NgModule({
  declarations: [
    ClientListComponent,
    ClientDetailsComponent,
    SearchClientFieldComponent
  ],
  providers: [ClientService],
  imports: [
    CommonModule,
    RouterModule.forChild(clientRouteList),
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatTooltipModule,
    MatTabsModule,
    MatDividerModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    MatCheckboxModule,
    BreadcrumbModule,
    SharedModule,
    FormsModule
  ]
})
export class ClientModule {}
