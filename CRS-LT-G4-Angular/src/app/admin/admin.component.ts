import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login/login.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  comp:boolean=false;
  generate:boolean=false;
  notificationCount:number=0;
  constructor(private loginService: LoginService,private router: Router) { }

 
  ngOnInit(): void {
  }
  
    logout(){
        this.loginService.userLoggedOut().subscribe(
          response => {
            console.log(response);
            this.router.navigate(['/login']);
          });
    }

    validate(){
      this.comp=!this.comp;
      this.generate=false;
    }

    generateReportCard(){
      this.comp=false;
      this.generate=!this.generate;

    }
}
