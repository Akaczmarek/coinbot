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

  getSumValues(){
    for(let entry of this.superServ.mock){

      this.sum+=entry;
      console.log(this.sum);

    }
  }

  getPercentage(number : number){
    return  number = (number / this.sum) * 100

  }



  getData() {
    let dashboardColors = this._baConfig.get().colors.dashboard;

    

    return [
      {
        value: this.superServ.mock[0],
        color: dashboardColors.white,
        highlight: colorHelper.shade(dashboardColors.white, 15),
        label: 'Mise de départ',
        percentage: this.getPercentage(this.superServ.mock[0]),
        order: 1,
      }, {
        value: this.superServ.mock[1],
        color: dashboardColors.gossip,
        highlight: colorHelper.shade(dashboardColors.gossip, 15),
        label: 'Gain sécurisé',
        percentage:this.getPercentage(this.superServ.mock[1]),
        order: 2,
      }, {
        value: this.superServ.mock[2],
        color: dashboardColors.silverTree,
        highlight: colorHelper.shade(dashboardColors.silverTree, 15),
        label: 'Gain non securisé',
        percentage: this.getPercentage(this.superServ.mock[2]),
        order: 3,
      }
    ];
  }
}
