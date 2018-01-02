import {Component} from '@angular/core';

import {BasicTablesService} from '../../basicTables.service';
import {SupervisionService} from '../../../../../../services/supervision.service';

@Component({
  selector: 'striped-table',
  templateUrl: './stripedTable.html'
})
export class StripedTable{

  OrderHistories:Array<any>;

  constructor(private supervisionService : SupervisionService ) {
    this.updateOHBUser();
    }

  
  updateOHBUser() {
    this.supervisionService.getOHBbyUser(1).subscribe(reponse => this.OrderHistories = reponse.sort((a: any, b: any) => {
      let date1 = new Date(a.timestampfinished);
      let date2 = new Date(b.timestampfinished);

      if (date1 > date2) {
          return -1;
      } else if (date1 < date2) {
          return 1;
      } else {
          return 0;
      }
  }))
   
  }

  
}
