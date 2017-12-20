import { Component } from '@angular/core';
import {BasicTablesService} from '../../basicTables.service';
import {SupervisionService} from '../../../../../../services/supervision.service';

@Component({
  selector: 'app-stripped-user-actions',
  templateUrl: './stripped-user-actions.component.html',
})
export class StrippedUserActions {

  smartTableData:Array<any>;
  
    constructor(private supervisionService : SupervisionService ) {
      this.smartTableData = supervisionService.mockUserActions;
    }

}