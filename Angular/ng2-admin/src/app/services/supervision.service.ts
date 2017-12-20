import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class SupervisionService {

  mock : Array<number> = [];

  constructor(private http : Http) { 
    this.mock.push(100,250,350);
  }


  getAllBuy(){
    return this.http.get(`url`)
    .map(response => response.json());
  }

  getAllSold(){
    return this.http.get(`url`)
    .map(response => response.json());
  }


}
