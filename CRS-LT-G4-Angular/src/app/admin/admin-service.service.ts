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
    let validateStudentUrl:string = "http://localhost:7081/admin/validateStudent/"+id;
    return this.httpClient.put(validateStudentUrl,{headers: this.headers});
  }

  generateReportCard(): Observable<any>{
    let generateReportCardUrl:string = "http://localhost:7081/admin/generateReportCard";
    return this.httpClient.get(generateReportCardUrl,{headers: this.headers});
  }

  approvedReportCard(id:number): Observable<any>{
    let approvedReportCardUrl:string = "http://localhost:7081/admin/validateReportCard/"+id;
    return this.httpClient.put(approvedReportCardUrl,{headers: this.headers});
  }

}
