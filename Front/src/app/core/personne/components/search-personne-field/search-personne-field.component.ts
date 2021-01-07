import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-personne-field',
  templateUrl: './search-personne-field.component.html',
  styleUrls: ['./search-personne-field.component.scss']
})
export class SearchPersonneFieldComponent {
  @Output() search: EventEmitter<string> = new EventEmitter();

  searchHandler(event: Event): void {
    const searchValue = (event.target as HTMLInputElement).value
      .trim()
      .toLowerCase();
    this.search.emit(searchValue);
  }
}
