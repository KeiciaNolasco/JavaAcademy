import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PipeOperatorComponent } from './pipe-operator.component';

describe('PipeOperatorComponent', () => {
  let component: PipeOperatorComponent;
  let fixture: ComponentFixture<PipeOperatorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PipeOperatorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PipeOperatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
