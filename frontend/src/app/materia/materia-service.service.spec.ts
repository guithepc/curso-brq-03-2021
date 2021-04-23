import { TestBed } from '@angular/core/testing';

import { MateriaServiceService } from './materia-service.service';

describe('MateriaServiceService', () => {
  let service: MateriaServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MateriaServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
