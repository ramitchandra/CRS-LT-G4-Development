import { Component, OnInit } from '@angular/core';
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
  constructor(private service: ProfessorServiceService) {
  }

  ngOnInit() {

  }

  public addprofessor() {
    let addProf = new Professor(this.model.professorId, this.model.professorName, this.model.professorPassword);

    let response = this.service.addProfessor(addProf);
    response.subscribe((data) => {this.message = data;
      console.log(this.message);
    })

    }

    public deleteProfessor() {
      let addProf = new Professor(this.model.professorId,this.model.professorName,this.model.professorPassword);
  
      let response = this.service.deleteProfessor(addProf);
      response.subscribe((data) => {this.message = data;
      console.log(this.message);
      })
  }

}