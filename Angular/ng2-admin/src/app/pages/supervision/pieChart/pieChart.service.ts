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
        stats: '0.04252 btc'
      }, {
        color: pieColor,
        description: 'Equivalence en Euros',
        stats: '500.00 €'
      }, 
    ];
  }
}
