import { TestBed } from '@angular/core/testing';

import { CategoryService } from './category.service';

describe('ProfessionService', () => {
  let service: ProfessionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProfessionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
