import {Injectable} from '@angular/core';
import {BaThemeConfigProvider, colorHelper} from '../../../theme';

@Injectable()
export class PieChartService {

  constructor(private _baConfig:BaThemeConfigProvider) {
  }

  getData() {
    let pieColor = this._baConfig.get().colors.custom.dashboardPieChart;
    return [
      {
        color: pieColor,
        description: 'Achats',
        stats: '57,820',
      }, {
        color: pieColor,
        description: 'Ventes',
        stats: '$ 89,745',
      }, {
        color: pieColor,
        description: 'dashboard.active_users',
        stats: '178,391',
      }, {
        color: pieColor,
        description: 'dashboard.returned',
        stats: '32,592',
      }
    ];
  }
}
