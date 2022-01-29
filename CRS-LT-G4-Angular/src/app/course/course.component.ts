import { Component, OnInit } from '@angular/core';
import { Course } from './course';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  courseArray: Array<Course> = new Array();

  model = new Course(1,'', true, 0, 0);
  updateFlag: boolean = false;
  updateData: any = {};
  constructor() { }

  ngOnInit(): void {
  }


  // Craete & List The Customer 

  createCourse() {

    //console.log("customer creation here-->");

    // Add customer in Customer Array using push event.



    this.courseArray.push(new Course(this.model.courseId,this.model.courseName, this.model.courseAvailable, this.model.onlineAmount, this.model.offlineAmount));

    console.log(JSON.stringify(this.courseArray));
    this.model.courseName = ""
    this.model.courseAvailable = true
    this.model.onlineAmount = 0
    this.model.offlineAmount = 0
  }


  deleteCustomer(data, index) {
    this.courseArray.splice(index, 1);
  }
}
