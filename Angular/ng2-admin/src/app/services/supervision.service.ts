import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { WebService } from 'app/services/web.service';
import { User } from 'app/_models/user';

@Injectable()
export class SupervisionService {
  mockVolume : Array<number> = [];
  mockAchatVenteHisto : Array<any> = [];
  mockUserActions : Array<any> = [];


  constructor(private http : Http, private webService : WebService) { 
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
        commentaire: 'Suce moi',
        date: new Date(),
        etat	: 'En cours',
      },
      {
        typeAction: 'Vente',
        commentaire: 'Leche moi',
        date: new Date(),
        etat	: 'En cours',
      },
      {
        typeAction: 'Achat',
        commentaire: 'Sois goulue',
        date: new Date(),
        etat	: 'En cours',
      },
      {
        typeAction: 'Vente',
        commentaire: 'Qui êtes vous ?',
        date: new Date(),
        etat	: 'En cours',
      },

    ]
  }


  getOHBbyUser(id: number) {
    return this.webService.getBy('ohbbyuser', id);
  }

  getActiveOHBByUser(id :number){
    return this.webService.getAllByElement('ohbbyuser', id, 'activebid')
  }

}
