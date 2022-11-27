import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NavComponent} from './nav/nav.component';
import {LayoutModule} from '@angular/cdk/layout';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {RouterLinkWithHref, RouterOutlet} from "@angular/router";
import {DashComponent} from './dash/dash.component';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatCardModule} from '@angular/material/card';
import {MatMenuModule} from '@angular/material/menu';
import {AppRoutingModule} from './app-routing.module';
import {CardComponent} from './card/card.component';
import {TemperatureLineChartComponent} from './charts/temperature-line-chart/temperature-line-chart.component';
import {NgApexchartsModule} from "ng-apexcharts";
import { PressureLineChartComponent } from './charts/pressure-line-chart/pressure-line-chart.component';
import { HumidityLineChartComponent } from './charts/humidity-line-chart/humidity-line-chart.component';
import { SummaryBoxPlotComponent } from './charts/summary-box-plot/summary-box-plot.component';
import { ValuesTableComponent } from './values-table/values-table.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MiniCardComponent } from './mini-card/mini-card.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    DashComponent,
    CardComponent,
    TemperatureLineChartComponent,
    PressureLineChartComponent,
    HumidityLineChartComponent,
    SummaryBoxPlotComponent,
    ValuesTableComponent,
    MiniCardComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    RouterLinkWithHref,
    RouterOutlet,
    MatGridListModule,
    MatCardModule,
    MatMenuModule,
    NgApexchartsModule,
    AppRoutingModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
