import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';

import { Professor } from './professor';



@Injectable({

  providedIn: 'root'

})

export class ProfessorServiceService {

  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private http:HttpClient) { }
  public addProfessor(addProf: Professor){
    return this.http.post<Professor>('http://localhost:7081/admin/addProfessor',addProf, {headers: this.headers});
      
  }
  
  // public deleteProfessor(delProf: Professor,id:number,name:string){
  //   return this.http.delete<Professor>('http://localhost:7081/admin/deleteProfessor',delProf, {headers: this.headers});
  // }  


}