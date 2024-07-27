import { TestBed } from '@angular/core/testing';

import { AnimalsServiceService } from './animals-service.service';

describe('AnimalsServiceService', () => {
  let service: AnimalsServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AnimalsServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
