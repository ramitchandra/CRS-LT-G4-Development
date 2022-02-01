import { Component, OnInit } from '@angular/core';
import { Course } from './course';
import { CourseService } from './course-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
 
  model = new Course(0, "", true, 0, 0);
  message: any;
  msg:boolean;
  constructor(
    private service: CourseService,private router: Router
  ) {

  }
  ngOnInit() {

  }
  public createCourse() {
    let addCourse = new Course(this.model.courseId, this.model.courseName, this.model.courseAvailable, this.model.onlineFees, this.model.offlineFees);
    console.log(addCourse);
    let responce = this.service.AddCourse(addCourse);
    responce.subscribe((data) => {this.message = data;
      this.msg=true;
      console.log(this.message);
    // this.router.navigate(['/admin']);
  })

  }

  closeAlert(){
    this.msg = false;
  }
}