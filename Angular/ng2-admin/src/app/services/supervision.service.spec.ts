import { TestBed, inject } from '@angular/core/testing';

import { SupervisionService } from './supervision.service';

describe('SupervisionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SupervisionService]
    });
  });

  it('should be created', inject([SupervisionService], (service: SupervisionService) => {
    expect(service).toBeTruthy();
  }));
});
