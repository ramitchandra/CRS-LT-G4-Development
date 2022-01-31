import { Injectable } from '@angular/core';
import { Course } from './course';
import { HttpClient,HttpHeaders } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class CourseService{
  
  headers = new HttpHeaders().set('Content-Type', 'application/json').set('Access-Control-Allow-Origin','*');
  constructor(private http:HttpClient) { }
  public AddCourse(createCourse: Course){
    return this.http.post<Course>('http://localhost:7081/admin/addCourse',createCourse, {headers: this.headers});
      
  }
  public deleteCourse(createCourse: Course){
    return this.http.delete<Course>('http://localhost:7081/admin/deleteCourse/'+createCourse.courseId+'/'+createCourse.courseName, {headers: this.headers});
  }  
 
}

  
     
  
    
    
 