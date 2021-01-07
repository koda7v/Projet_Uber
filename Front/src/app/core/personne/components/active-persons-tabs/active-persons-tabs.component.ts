import { Component, Output, EventEmitter } from '@angular/core';
import { MatTabChangeEvent } from '@angular/material/tabs';

@Component({
  selector: 'app-active-persons-tabs',
  templateUrl: './active-persons-tabs.component.html',
  styleUrls: ['./active-persons-tabs.component.scss']
})
export class ActivePersonsTabsComponent {
  @Output() active: EventEmitter<boolean> = new EventEmitter();

  tabChanged(event: MatTabChangeEvent): void {
    const result = event.index === 0 ? true : false;
    this.active.emit(result);
  }
}
