import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminServiceService } from '../admin/admin-service.service';
import { GenerateReportCard } from './generatereportcard';


@Component({
  selector: 'app-generate-report-card',
  templateUrl: './generate-report-card.component.html',
  styleUrls: ['./generate-report-card.component.css']
})
export class GenerateReportCardComponent implements OnInit {
  display:boolean= false;
  studentGrade: GenerateReportCard[];
  constructor(private adminService:AdminServiceService,private router: Router) { 
    this.adminService.generateReportCard().subscribe(
      (response: GenerateReportCard[]) => {
        console.log(response); 
        this.studentGrade=response;      
      }
     );
  }

  ngOnInit(): void {
  }

  generateReportCard(id:number){
      this.adminService.approvedReportCard(id).subscribe(
      response => {
        console.log(response);
      }
     );
    this.studentGrade.forEach((value,index)=>{
      if(value.studentId==id) this.studentGrade.splice(index,1);
     });

     if (this.studentGrade.length==0){
      this.display=true;
    }
  }

}
