import { Component } from '@angular/core';
import { StripedTable } from '../stripedTable/stripedTable.component'

import { SupervisionService } from '../../../../../../services/supervision.service';

@Component({
  selector: 'contextual-table',
  templateUrl: './contextualTable.html',
})
export class ContextualTable {

  ActiveOrders: Array<any>;
  idOrder: number;


  constructor(private supervisionService: SupervisionService) {
    this.updateActiveOrders();
  }

  updateActiveOrders() {
    this.supervisionService.getActiveOHBByUser(1).subscribe(reponse => this.ActiveOrders = reponse.sort((a: any, b: any) => {
      let date1 = new Date(a.timestampfinished);
      let date2 = new Date(b.timestampfinished);

      if (date1 > date2) {
        return 1;
      } else if (date1 < date2) {
        return -1;
      } else {
        return 0;
      }
    }))

  }

  deleteOrder(idOrder: number) {
    this.supervisionService.deleteOrder(idOrder).subscribe(reponse => {this.updateActiveOrders(); this.supervisionService.emitter.next(2)});
  }
}
