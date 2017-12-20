import {Injectable} from '@angular/core';
import {BaThemeConfigProvider, colorHelper} from '../../../theme';
import { forEach } from '@angular/router/src/utils/collection';
import { SupervisionService} from '../../../services/supervision.service'

@Injectable()
export class TrafficChartService {

  public sum : number = 0;

  constructor(private _baConfig:BaThemeConfigProvider, public superServ : SupervisionService) {
    this.getSumValues();
    
  }

  getSumValues() {
    for(let entry of this.superServ.mockVolume){
      this.sum+=entry;

    }
  }

  getPercentage(number : number){
    return  number = (number / this.sum) * 100

  }



  getData() {
    let dashboardColors = this._baConfig.get().colors.dashboard;

    

    return [
      {
        value: this.superServ.mockVolume[0],
        color: dashboardColors.white,
        highlight: colorHelper.shade(dashboardColors.white, 15),
        label: 'Mise de départ',
        percentage: this.getPercentage(this.superServ.mockVolume[0]),
        order: 1,
      }, {
        value: this.superServ.mockVolume[1],
        color: dashboardColors.green,
        highlight: colorHelper.shade(dashboardColors.green, 15),
        label: 'Gain sécurisé',
        percentage:this.getPercentage(this.superServ.mockVolume[1]),
        order: 2,
      }, {
        value: this.superServ.mockVolume[2],
        color: dashboardColors.red,
        highlight: colorHelper.shade(dashboardColors.red, 15),
        label: 'Gain non securisé',
        percentage: this.getPercentage(this.superServ.mockVolume[2]),
        order: 3,
      }
    ];
  }
}
