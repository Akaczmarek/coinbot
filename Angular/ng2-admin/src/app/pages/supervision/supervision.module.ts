import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';


import { SupervisionComponent } from './supervision.component';
import { routing } from './supervision.routing';
import { PieChart } from './pieChart';
import { PieChartService } from './pieChart/pieChart.service';
import { TrafficChart } from 'app/pages/supervision/trafficChart';
import { TrafficChartService } from 'app/pages/supervision/trafficChart/trafficChart.service';
import { Tables } from 'app/pages/supervision/tables';
import { BasicTablesService } from 'app/pages/supervision/tables/components/basicTables/basicTables.service';
import { StripedTable } from 'app/pages/supervision/tables/components/basicTables/components/stripedTable';
import { ContextualTable } from 'app/pages/tables/components/basicTables/components/contextualTable';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    routing,
    NgaModule
  ],
  declarations: [
    PieChart,
    TrafficChart,
    Tables,
    StripedTable,
    ContextualTable,
    SupervisionComponent
  ],

  providers :[
    PieChartService, TrafficChartService, BasicTablesService
  ]
})
export class SupervisionModule {}