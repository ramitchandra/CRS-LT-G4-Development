import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from '../admin/admin-service.service';
import { StudentDetails } from './studentApproval';

@Component({
  selector: 'app-approve-student',
  templateUrl: './approve-student.component.html',
  styleUrls: ['./approve-student.component.css']
})
export class ApproveStudentComponent implements OnInit {
  display:boolean =false;
  studentData: StudentDetails[];
  constructor(private adminService:AdminServiceService,private router: Router) {
    this.adminService.getStudent().subscribe(
      (response: StudentDetails[]) => {
        console.log(response);
        this.studentData=response;        
      }
     );
   }

  ngOnInit(): void {
  }

    approveStudent(id:number){
      
      this.adminService.approvedStudent(id).subscribe(
        response => {
          console.log(response);
        }
       );
       this.studentData.forEach((value,index)=>{
        if(value.studentId==id) this.studentData.splice(index,1);
       });

       if (this.studentData.length==0){
         this.display=true;
       }
       
    }  
}
