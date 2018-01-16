import { Component, OnInit } from '@angular/core';
import { SupervisionService } from 'app/services/supervision.service';

@Component({
  selector: 'supervision',
  styleUrls: ['./supervision.component.scss'],
  templateUrl: './supervision.component.html',
})
export class SupervisionComponent implements OnInit  {

  isConnected : boolean = false;

  constructor(private supService: SupervisionService) {

    console.log("supservice connexion dans le supcomp", this.supService.connexion)
  }

  ngOnInit() {
    this.isConnected = this.supService.connexion;
  }



}
