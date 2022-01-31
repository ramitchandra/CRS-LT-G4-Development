import { Component, OnInit } from '@angular/core';
import { Login } from './login';
import { LoginService } from './login.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  msg:boolean = false;
  userName:string;
  password:string;
  constructor(private loginService:LoginService,private router: Router) { }

  ngOnInit(): void {
  }

  submit(): void {
    console.log("inside onsubmit:")
    let userLogin= new Login(this.userName,this.password);
    console.log(userLogin.userName + " " + userLogin.password );
    this.loginService.userLogin(userLogin).subscribe(
      response => {
        console.log(response);
        if(response && response.msg === 'User Logged In'){
          this.router.navigate(['/admin']);
        } else {
          this.msg = true;
          this.userName = "";
          this.password = "";
          this.router.navigate(['/login']);
        }
      }
     );
  }

  closeAlert(){
    this.msg = false;
  }

}
