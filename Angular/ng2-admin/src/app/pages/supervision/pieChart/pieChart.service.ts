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
        stats: '57,820 €',
        icon: 'money',
      }, {
        color: pieColor,
        description: 'Ventes',
        stats: '89,745 €',
        icon: 'money',
      }, 
    ];
  }
}
