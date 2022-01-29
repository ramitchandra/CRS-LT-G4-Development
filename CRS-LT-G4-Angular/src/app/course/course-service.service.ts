import { Injectable } from '@angular/core';
import { Course } from './course';
import { HttpClient,HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CourseService{
  
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private http:HttpClient) { }
  public save(createCourse: Course){
    return this.http.post<Course>('http://localhost:7081/addCourse',createCourse, {headers: this.headers});
      
  

  
     
  
    
    
  }
  
}
