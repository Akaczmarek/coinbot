import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-config-bot',
  templateUrl: './config-bot.component.html',
  styleUrls: ['./config-bot.component.scss']
})
export class ConfigBotComponent implements OnInit {

 betValue : number;
 secureValue : number;
 daysordersbloqued : number;

  constructor() { }

  ngOnInit() {
  }

}
