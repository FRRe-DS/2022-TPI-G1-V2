import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthReadComponent } from './health-read.component';

describe('HealthReadComponent', () => {
  let component: HealthReadComponent;
  let fixture: ComponentFixture<HealthReadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthReadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HealthReadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
