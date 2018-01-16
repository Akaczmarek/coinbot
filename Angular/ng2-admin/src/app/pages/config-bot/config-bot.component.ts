import { Component, OnInit } from '@angular/core';
import { SupervisionService } from 'app/services/supervision.service';

@Component({
  selector: 'app-config-bot',
  templateUrl: './config-bot.component.html',
  styleUrls: ['./config-bot.component.scss']
})
export class ConfigBotComponent implements OnInit {

 betValue : number;
 secureValue : number;
 daysordersbloqued : number;
 isConnected : boolean;

  constructor(private supService : SupervisionService) { 

  }

  ngOnInit() {
  }

}
