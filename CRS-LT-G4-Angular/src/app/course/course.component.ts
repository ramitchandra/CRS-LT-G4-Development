import { Component, OnInit } from '@angular/core';
import { Course } from './course';
import { CourseService } from './course-service.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {
  //   courseArray: Array<Course> = new Array();

  //   model = new Course(1,'', true, 0, 0);
  //   updateFlag: boolean = false;
  //   updateData: any = {};
  //   constructor(private CourseService: CourseService) { }

  //   ngOnInit(): void {
  //   }


  //   // Craete & List The Customer 

  //   createCourse() {

  //     //console.log("customer creation here-->");

  //     // Add customer in Customer Array using push event.
  //     let addCourse= new Course(this.model.courseId,this.model.courseName, this.model.courseAvailable, this.model.onlineAmount, this.model.offlineAmount);

  //     this.CourseService.save(addCourse).subscribe(
  //       response => {
  //         console.log(response)
  //       }
  //      );


  //     // this.courseArray.push(new Course(this.model.courseId,this.model.courseName, this.model.courseAvailable, this.model.onlineAmount, this.model.offlineAmount));

  //     // console.log(JSON.stringify(this.courseArray));
  //     // this.model.courseName = ""
  //     // this.model.courseAvailable = true
  //     // this.model.onlineAmount = 0
  //     // this.model.offlineAmount = 0
  //   }


  //   deleteCustomer(data, index) {
  //     this.courseArray.splice(index, 1);
  //   }


  // }
  model = new Course(0, "", true, 0, 0);
  message: any;
  constructor(
    private service: CourseService
  ) {

  }
  ngOnInit() {

  }
  public createCourse() {
    let addCourse = new Course(this.model.courseId, this.model.courseName, this.model.courseAvailable, this.model.onlineAmount, this.model.offlineAmount);

    let responce = this.service.AddCourse(addCourse);
    responce.subscribe((data) => this.message = data)

  }
}