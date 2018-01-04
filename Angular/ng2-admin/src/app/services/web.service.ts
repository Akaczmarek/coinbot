import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';


@Injectable()
export class WebService {
  url = 'http://localhost:8080/api/';
  constructor(private http: Http) { }


  getAll(type: string) {
    return this.http.get(this.url + type).map(r => r.json());
  }

  get(type: string, id: number) {
    return this.http.get(this.url + type + '/' + id).map(r => r.json());
  }

  create(type: string, body: Object) {
    const bodyString = JSON.stringify(body);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    console.log(this.http.post(this.url + type, bodyString, options).map(r => r.json()));
    return this.http.post(this.url + type, bodyString, options).map(r => r.json());
  }

  delete(element:string, elementId:number) {
    return this.http.delete(this.url + element + '/' + elementId).map(r => r.json());
    //ohbbyuser/9
  }
  update(type: string, body: Object, id : number) {
    const bodyString = JSON.stringify(body);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this.http.put(this.url + type + '/' + id, bodyString, options).map(r => r.json());
  }

  getAllByElement( element:string, elementId:number,type: string){
    return this.http.get(this.url + element + '/' + elementId +'/' + type +'s').map(r => r.json());
    // url : api/room/1/messages  //le s est obligatoire pour le transmettre à spring
  }

  getBy(element:string, elementId:number){
    return this.http.get(this.url + element + '/' + elementId).map(r => r.json());
  }



}
