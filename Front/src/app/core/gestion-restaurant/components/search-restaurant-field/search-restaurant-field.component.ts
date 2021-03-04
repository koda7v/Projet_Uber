import { Component, Output, EventEmitter  } from '@angular/core';

@Component({
  selector: 'app-search-restaurant-field',
  templateUrl: './search-restaurant-field.component.html',
  styleUrls: ['./search-restaurant-field.component.scss']
})
export class SearchRestaurantFieldComponent  {

  @Output() search: EventEmitter<string> = new EventEmitter();

  searchHandler(event: Event): void {
    const searchValue = (event.target as HTMLInputElement).value
      .trim()
      .toLowerCase();
    this.search.emit(searchValue);
  }

}
