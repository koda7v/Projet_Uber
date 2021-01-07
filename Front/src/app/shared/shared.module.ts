import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BreadcrumbModule } from 'xng-breadcrumb';

import { PageTitleComponent } from './components/page-title/page-title.component';

@NgModule({
  declarations: [PageTitleComponent],
  imports: [CommonModule, BreadcrumbModule],
  exports: [PageTitleComponent]
})
export class SharedModule {}
