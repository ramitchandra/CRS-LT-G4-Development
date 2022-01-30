import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Professor } from './professor';

@Injectable({
  providedIn: 'root'
})
export class ProfessorServiceService {
  
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private http:HttpClient) { }
  public save(addProfessor: Professor){
    return this.http.post<Professor>('http://localhost:7081/addProfessor',addProfessor, {headers: this.headers});
}
}