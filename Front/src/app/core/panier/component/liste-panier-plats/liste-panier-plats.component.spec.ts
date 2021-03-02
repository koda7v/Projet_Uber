import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListePanierPlatsComponent } from './liste-panier-plats.component';

describe('ListePanierPlatsComponent', () => {
  let component: ListePanierPlatsComponent;
  let fixture: ComponentFixture<ListePanierPlatsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListePanierPlatsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListePanierPlatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
