import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-client-field',
  templateUrl: './search-client-field.component.html',
  styleUrls: ['./search-client-field.component.scss']
})
export class SearchClientFieldComponent {
  @Output() search: EventEmitter<string> = new EventEmitter();

  searchHandler(event: Event): void {
    const searchValue = (event.target as HTMLInputElement).value
      .trim()
      .toLowerCase();
    this.search.emit(searchValue);
  }
}
