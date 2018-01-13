import {Component} from '@angular/core';
import {FormGroup, AbstractControl, FormBuilder, Validators} from '@angular/forms';

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

  mockLogs : Array<any> = [];

  constructor(fb:FormBuilder) {
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
      for (const mocklog of this.mockLogs) {
        if (mocklog.email == this.email && mocklog.password == this.password){
          console.log('ok => ',this.mockLogs[1])
        }
        
      }
      // console.log(values);
    }
  }


}
