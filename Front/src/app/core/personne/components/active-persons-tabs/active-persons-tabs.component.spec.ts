import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActivePersonsTabsComponent } from './active-persons-tabs.component';

describe('ActivePersonsTabsComponent', () => {
  let component: ActivePersonsTabsComponent;
  let fixture: ComponentFixture<ActivePersonsTabsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ActivePersonsTabsComponent]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActivePersonsTabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
