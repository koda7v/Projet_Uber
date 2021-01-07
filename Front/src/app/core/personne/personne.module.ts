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

import { PersonneService } from 'src/app/core/personne/services/personne.service';
import { PersonneListComponent } from './views/personne-list/personne-list.component';
import { PersonneDetailsComponent } from './views/personne-details/personne-details.component';
import { ActivePersonsTabsComponent } from './components/active-persons-tabs/active-persons-tabs.component';
import { SearchPersonneFieldComponent } from './components/search-personne-field/search-personne-field.component';

export const personneRouteList: Routes = [
  {
    path: '',
    component: PersonneListComponent,
    data: {
      breadcrumb: 'Personnes'
    }
  },
  {
    path: ':id',
    component: PersonneDetailsComponent,
    data: {
      breadcrumb: {
        alias: 'personneName'
      }
    }
  }
];

@NgModule({
  declarations: [
    PersonneListComponent,
    PersonneDetailsComponent,
    ActivePersonsTabsComponent,
    SearchPersonneFieldComponent
  ],
  providers: [PersonneService],
  imports: [
    CommonModule,
    RouterModule.forChild(personneRouteList),
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
export class PersonneModule {}
