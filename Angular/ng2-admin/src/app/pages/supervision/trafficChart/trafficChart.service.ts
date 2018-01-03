import {Injectable} from '@angular/core';
import {BaThemeConfigProvider, colorHelper} from '../../../theme';
import { forEach } from '@angular/router/src/utils/collection';
import { SupervisionService} from '../../../services/supervision.service'

@Injectable()
export class TrafficChartService {

  public startingBetValue : number = 0;

  constructor(private _baConfig:BaThemeConfigProvider, public superServ : SupervisionService) {
    this.getSumValues();
    
  }

  getSumValues() {
    this.startingBetValue = (this.superServ.mockVolume[0] + this.superServ.mockVolume[2]);
    }

  getPerc(a:number, b :number){
    return  (a / b) *100
    }



  getData() {
    let dashboardColors = this._baConfig.get().colors.dashboard;

    

    return [
      {
        value: this.superServ.mockVolume[0],
        color: dashboardColors.white,
        highlight: colorHelper.shade(dashboardColors.white, 15),
        label: 'Ce qu\'il reste de la mise de départ', // Somme des mises actives + mise actuelle restante
        percentage: this.getPerc(this.superServ.mockVolume[0], this.superServ.mockVolume[2]),
        order: 1,
      }, {
        value: this.superServ.mockVolume[1],
        color: dashboardColors.green,
        highlight: colorHelper.shade(dashboardColors.green, 15),
        label: 'Gains sécurisés envoyés sur Bittrex',
        percentage:this.getPerc(this.superServ.mockVolume[1],(this.superServ.mockVolume[0] + this.superServ.mockVolume[2])),
        order: 2,
      }, {
        value: this.superServ.mockVolume[2],
        color: dashboardColors.red,
        highlight: colorHelper.shade(dashboardColors.red, 15),
        label: 'Mises encore actives',
        percentage: this.getPerc(this.superServ.mockVolume[2],(this.superServ.mockVolume[0] + this.superServ.mockVolume[2])),
        order: 3,
      }
    ];
  }
}
