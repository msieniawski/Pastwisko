import { TestBed, inject } from '@angular/core/testing';

import { CopypastaService } from './copypasta.service';

describe('CopypastaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CopypastaService]
    });
  });

  it('should be created', inject([CopypastaService], (service: CopypastaService) => {
    expect(service).toBeTruthy();
  }));
});
