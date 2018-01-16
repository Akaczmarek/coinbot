import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { WebService } from 'app/services/web.service';
import { User } from 'app/_models/user';
import { Observable } from 'rxjs/Observable';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import { StripedTable } from 'app/pages/tables/components/basicTables/components/stripedTable';


@Injectable()
export class SupervisionService {
  mockVolume : Array<number> = [];
  mockAchatVenteHisto : Array<any> = [];
  mockUserActions : Array<any> = [];
  emitter : BehaviorSubject<any>;
  emitterCnx : BehaviorSubject<any>;

  connexion : boolean;


  constructor(private http : Http, private webService : WebService) {
    this.emitter = new BehaviorSubject<number>(1);
    this.emitterCnx = new BehaviorSubject<number>(2)

    this.mockVolume.push(100,200,300);
    this.mockAchatVenteHisto = [
        {
          id: 1,
          typeOrdre: 'Achat',
          cryptomonnaie: 'BTC',
          volume: '1.7',
          date: new Date(),
          etat	: 'En cours',
          valeurGain:'13',
        },
        {
          id: 2,
          typeOrdre: 'Achat2',
          cryptomonnaie: 'BTC2',
          volume: '1.72',
          date: new Date(),
          etat	: 'En cours2',
          valeurGain:'132',
        },
        {
          id: 3,
          typeOrdre: 'Achat3',
          cryptomonnaie: 'BTC3',
          volume: '1.73',
          date: new Date(),
          etat	: 'En cours2',
          valeurGain:'132',
        },
        {
          id: 4,
          typeOrdre: 'Achat4',
          cryptomonnaie: 'BTC4',
          volume: '1.74',
          date: new Date(),
          etat	: 'En cours4',
          valeurGain:'134',
        },
        {
          id: 5,
          typeOrdre: 'Achat5',
          cryptomonnaie: 'BTC5',
          volume: '1.75',
          date: new Date(),
          etat	: 'En cours5',
          valeurGain:'135',
        },
        {
          id: 6,
          typeOrdre: 'Achat6',
          cryptomonnaie: 'BTC6',
          volume: '1.76',
          date: new Date(),
          etat	: 'En cours6',
          valeurGain:'136',
        },
    ]

    this.mockUserActions = [
      {
        typeAction: 'Achat',
        commentaire: 'Test 1',
        date: new Date(),
        etat	: 'En cours',
      },
      {
        typeAction: 'Vente',
        commentaire: 'Test 2',
        date: new Date(),
        etat	: 'En cours',
      },
      {
        typeAction: 'Achat',
        commentaire: 'Test 3',
        date: new Date(),
        etat	: 'En cours',
      },
      {
        typeAction: 'Vente',
        commentaire: 'Test 4',
        date: new Date(),
        etat	: 'En cours',
      },

    ]
  }

  setCnx (bool : boolean){
    this.connexion = bool;
  }


  getOHBbyUser(id: number) {
    return this.webService.getBy('ohbbyuser', id);
  }

  getActiveOHBByUser(id :number){
    return this.webService.getAllByElement('ohbbyuser', id, 'activebid');
  }

  deleteOrder(idOrder :number){
    return this.webService.delete('ohbbyuser',idOrder);
  }

}
