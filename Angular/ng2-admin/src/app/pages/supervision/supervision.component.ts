import { Component, OnInit } from '@angular/core';
import { SupervisionService } from 'app/services/supervision.service';

@Component({
  selector: 'supervision',
  styleUrls: ['./supervision.component.scss'],
  templateUrl: './supervision.component.html',
})
export class SupervisionComponent implements OnInit {

  isConnected : boolean;

  constructor(private supService: SupervisionService) {
    this.isConnected = this.supService.connexion;

  }

  ngOnInit() {
    console.log("supservice connexion dans le supcomp", this.supService.connexion)
  }

  ngAfterViewInit() {
    console.log("supservice connexion ngAfterViewInit dans le supcomp", this.supService.connexion)
    
  }

}
