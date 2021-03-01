import { TestBed } from '@angular/core/testing';

import { GestionRestaurantsService } from './gestion-restaurants.service';

describe('GestionRestaurantsService', () => {
  let service: GestionRestaurantsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GestionRestaurantsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
