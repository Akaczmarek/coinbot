import {Component, Output, EventEmitter} from '@angular/core';
import {FormGroup, AbstractControl, FormBuilder, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { SupervisionService } from 'app/services/supervision.service';

@Component({
  selector: 'login',
  templateUrl: './login.html',
  styleUrls: ['./login.scss']
})
export class Login {

  public form:FormGroup;
  public email:AbstractControl;
  public password:AbstractControl;
  public submitted:boolean = false;
  connected : boolean;
  @Output() connectChange = new EventEmitter();

  mockLogs : Array<any> = [];

  constructor(fb:FormBuilder, private router : Router, private supService : SupervisionService) {
    this.form = fb.group({
      'email': ['', Validators.compose([Validators.required, Validators.minLength(4)])],
      'password': ['', Validators.compose([Validators.required, Validators.minLength(4)])]
    });

    this.email = this.form.controls['email'];
    this.password = this.form.controls['password'];

    this.mockLogs = [
      {
        id: 1,
        email : 'alain@gmail.com',
        password : 'test'
      },
      {
        id: 2,
        email : 'ghislain@gmail.com',
        password : 'test'
      },
    ];

  }

  onSubmit():void {
    this.submitted = true;
    if (this.form.valid) {
      console.log("form valid");
      for (const mocklog of this.mockLogs) {
        console.log('ok => ',mocklog.email, this.email.value,  mocklog.password, this.password.value)
        if (mocklog.email == this.email.value && mocklog.password == this.password.value){
          console.log('ok email verifié => ',mocklog.email)
          this.supService.setCnx(true);
          console.log(this.supService.connexion)
          this.supService.emitterCnx.next(3)
          this.router.navigate(['pages/supervision'])
          return;
        }
        else{
          console.log("mdp incorrect")
        }
        
      }
      // console.log(values);
    }
  }


}
