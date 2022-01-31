import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Professor } from './professor';
import { ProfessorServiceService } from './professor-service.service';

@Component({
  selector: 'app-add-professor',
  templateUrl: './professor.component.html',
  styleUrls: ['./professor.component.css']
})

export class ProfessorComponent implements OnInit {

  model = new Professor(0, "", "");
  message: any;
  msg:boolean = false;
  display: boolean;
  constructor(private service: ProfessorServiceService,private router: Router) {
    
  }
  ngOnInit(): void {
    
  }
  public addProfessor() {
    let addProf = new Professor(this.model.professorId, this.model.professorName, this.model.professorPassword);

    let response = this.service.addProfessor(addProf);
    response.subscribe((data) => {this.message = data;
      console.log(this.message);
    });
  
    }


}
