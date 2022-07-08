import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthRead2Component } from './health-read2.component';

describe('HealthRead2Component', () => {
  let component: HealthRead2Component;
  let fixture: ComponentFixture<HealthRead2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthRead2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HealthRead2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
