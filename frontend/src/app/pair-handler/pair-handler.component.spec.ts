import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PairHandlerComponent } from './pair-handler.component';

describe('PairHandlerComponent', () => {
  let component: PairHandlerComponent;
  let fixture: ComponentFixture<PairHandlerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PairHandlerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PairHandlerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
