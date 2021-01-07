import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchPersonneFieldComponent } from './search-personne-field.component';

describe('SearchPersonneFieldComponent', () => {
  let component: SearchPersonneFieldComponent;
  let fixture: ComponentFixture<SearchPersonneFieldComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SearchPersonneFieldComponent]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchPersonneFieldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
