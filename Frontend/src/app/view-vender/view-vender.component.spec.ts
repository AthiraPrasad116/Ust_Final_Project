import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewVenderComponent } from './view-vender.component';

describe('ViewVenderComponent', () => {
  let component: ViewVenderComponent;
  let fixture: ComponentFixture<ViewVenderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewVenderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewVenderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
