import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private httpClient:HttpClient) { }

  getStudent(): Observable<any>{
    let getStudentUrl:string = "http://localhost:7081/admin/getStudent";
    return this.httpClient.get(getStudentUrl,{headers: this.headers});
  }

  approvedStudent(id:number): Observable<any>{
    console.log(id);
    // let body:any={'Id':id};
    let validateStudentUrl:string = "http://localhost:7081/admin/validateStudent/"+id;
    console.log(validateStudentUrl);
    return this.httpClient.put(validateStudentUrl,{headers: this.headers});
  }

}
