import {Component, ViewChild} from '@angular/core';
import {ChartComponent} from "ng-apexcharts";
import {ChartOptions} from "../humidity-line-chart/humidity-line-chart.component";

@Component({
  selector: 'app-pressure-line-chart',
  templateUrl: './pressure-line-chart.component.html',
  styleUrls: ['./pressure-line-chart.component.css']
})
export class PressureLineChartComponent {

  @ViewChild("chart") chart: ChartComponent | undefined;
  public chartOptions!: Partial<ChartOptions> | any;

  constructor() {
    this.chartOptions = {
      series: [
        {
          name: "series1",
          data: [34, 40, 28, 51, 42, 109, 100]
        },
        {
          name: "series2",
          data: [11, 32, 45, 32, 34, 52, 41]
        }
      ],
      chart: {
        height: 250,
        type: "area"
      },
      dataLabels: {
        enabled: false
      },
      stroke: {
        curve: "smooth"
      },
      xaxis: {
        type: "datetime",
        categories: [
          "2018-09-19T00:00:00.000Z",
          "2018-09-19T01:30:00.000Z",
          "2018-09-19T02:30:00.000Z",
          "2018-09-19T03:30:00.000Z",
          "2018-09-19T04:30:00.000Z",
          "2018-09-19T05:30:00.000Z",
          "2018-09-19T06:30:00.000Z"
        ]
      },
      tooltip: {
        x: {
          format: "dd/MM/yy HH:mm"
        }
      }
    };
  }

}
