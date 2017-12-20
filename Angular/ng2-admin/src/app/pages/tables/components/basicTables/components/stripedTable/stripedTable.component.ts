import {Component} from '@angular/core';

import {BasicTablesService} from '../../basicTables.service';
import {SupervisionService} from '../../../../../../services/supervision.service';

@Component({
  selector: 'striped-table',
  templateUrl: './stripedTable.html'
})
export class StripedTable {

  smartTableData:Array<any>;

  constructor(private supervisionService : SupervisionService ) {
    this.smartTableData = supervisionService.mockAchatVenteHisto;
  }
}
