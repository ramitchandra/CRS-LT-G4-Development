import { Component, OnInit } from '@angular/core';
import { Login } from './login';
import { LoginService } from './login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName:string;
  password:string;
  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }

  submit(): void {
    console.log("inside onsubmit:")
    let userLogin= new Login(this.userName,this.password);
    console.log(userLogin.userName + " " + userLogin.password );
    this.loginService.userLogin(userLogin).subscribe(
      response => {
        console.log(response)
      }
     );
  }



}
