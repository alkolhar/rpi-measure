import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SummaryBoxPlotComponent } from './summary-box-plot.component';

describe('SummaryBoxPlotComponent', () => {
  let component: SummaryBoxPlotComponent;
  let fixture: ComponentFixture<SummaryBoxPlotComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SummaryBoxPlotComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SummaryBoxPlotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
