import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Login } from './login';
import { HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private httpClient:HttpClient) { }

  userLogin(login:Login): Observable<any>{
    let loginUrl:string = "http://localhost:7081/login";
    return this.httpClient.post(loginUrl,login, {headers: this.headers});
  }

  userLoggedOut(): Observable<any>{
    let logoutUrl:string = "http://localhost:7081/logout";
    return this.httpClient.get(logoutUrl,{headers: this.headers});
  }

}
