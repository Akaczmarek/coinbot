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
        description: 'Gain BTC',
        stats: '57,820 €'
      }, {
        color: pieColor,
        description: 'Gain Euros',
        stats: '89,745 €'
      }, 
    ];
  }
}
