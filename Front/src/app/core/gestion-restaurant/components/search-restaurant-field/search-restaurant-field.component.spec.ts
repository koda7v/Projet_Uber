import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchRestaurantFieldComponent } from './search-restaurant-field.component';

describe('SearchRestaurantFieldComponent', () => {
  let component: SearchRestaurantFieldComponent;
  let fixture: ComponentFixture<SearchRestaurantFieldComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchRestaurantFieldComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchRestaurantFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
