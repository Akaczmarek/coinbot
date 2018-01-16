import { Component } from '@angular/core';

import { GlobalState } from '../../../global.state';
import { SupervisionService } from 'app/services/supervision.service';
import { OnInit } from '@angular/core/src/metadata/lifecycle_hooks';

@Component({
  selector: 'ba-page-top',
  templateUrl: './baPageTop.html',
  styleUrls: ['./baPageTop.scss']
})
export class BaPageTop implements OnInit {

  public isScrolled: boolean = false;
  public isMenuCollapsed: boolean = false;
  public isConnected: boolean;

  constructor(private _state: GlobalState, private supService: SupervisionService) {
    this._state.subscribe('menu.isCollapsed', (isCollapsed) => {
      this.isMenuCollapsed = isCollapsed;
    });


  }

  ngOnInit() {
    this.supService.emitterCnx.subscribe(t => {this.connected(); console.log("Conexion ?")});
    this.connected();
  }

  public toggleMenu() {
    this.isMenuCollapsed = !this.isMenuCollapsed;
    this._state.notifyDataChanged('menu.isCollapsed', this.isMenuCollapsed);
    return false;
  }

  public scrolledChanged(isScrolled) {
    this.isScrolled = isScrolled;
  }

  public connected() {
    if (this.supService.connexion) {
      this.isConnected = true;
      console.log("connexion ok ")
    }
    else {
      console.log("supservice pas co faut croire")
    }
  }


}
