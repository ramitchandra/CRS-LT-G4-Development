import { Injectable } from '@angular/core';
import { Course } from './course';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CourseServiceService {
  

  constructor(private http:HttpClient) { }
  public save(createCourse: Course){
    this.http.post<Course>('http://localhost:7081/addCourse',createCourse, {observe: 'response'}).subscribe(result => {
      console.log("The request was a success!")
      },
      () => {console.log("There was an Error")});
  }
}
