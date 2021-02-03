import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchClientFieldComponent } from './search-client-field.component';

describe('SearchClientFieldComponent', () => {
  let component: SearchClientFieldComponent;
  let fixture: ComponentFixture<SearchClientFieldComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SearchClientFieldComponent]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchClientFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
