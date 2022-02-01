import { Component, OnInit } from '@angular/core';
import { Course } from '../course/course';
import { CourseService } from '../course/course-service.service';


@Component({
  selector: 'app-delete-course',
  templateUrl: './delete-course.component.html',
  styleUrls: ['./delete-course.component.css']
})
export class DeleteCourseComponent implements OnInit {

  model = new Course(0, "", true, 0, 0);
  message: any;
  msg:boolean;
  constructor(
    private service: CourseService
  ) {
 }

  ngOnInit(): void {
  }

  public deleteCourse() {
    let addCourse = new Course(this.model.courseId, this.model.courseName, this.model.courseAvailable, this.model.onlineFees, this.model.offlineFees);

    let responce = this.service.deleteCourse(addCourse);
    responce.subscribe((data) => {this.message = data;
      console.log(this.message);
      this.msg=true;
    // this.router.navigate(['/admin']);
  })

  }
  closeAlert(){
    this.msg = false;
  }

}
