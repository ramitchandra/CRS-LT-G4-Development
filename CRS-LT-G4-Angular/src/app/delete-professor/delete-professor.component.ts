import { Component, OnInit } from '@angular/core';
import { ProfessorServiceService } from '../add-professor/professor-service.service';
import { Professor } from './professor';

@Component({
  selector: 'app-delete-professor',
  templateUrl: './delete-professor.component.html',
  styleUrls: ['./delete-professor.component.css']
})
export class DeleteProfessorComponent implements OnInit {
  model = new Professor(0, "", "");
  message: any;
  msg: boolean;

  constructor(private service: ProfessorServiceService) { }

  ngOnInit(): void {
  }

  public deleteProfessor() {
    let addProf = new Professor(this.model.professorId,this.model.professorName,this.model.professorPassword);

    let response = this.service.deleteProfessor(addProf);
    response.subscribe((data) => {this.message = data;
      this.msg=true;
    console.log(this.message);
    })
}


closeAlert(){
  this.msg = false;
}

}
