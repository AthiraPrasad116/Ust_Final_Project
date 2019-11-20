import { TestBed } from '@angular/core/testing';

import { VendorCrudsService } from './vendor-cruds.service';

describe('VendorCrudsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VendorCrudsService = TestBed.get(VendorCrudsService);
    expect(service).toBeTruthy();
  });
});
