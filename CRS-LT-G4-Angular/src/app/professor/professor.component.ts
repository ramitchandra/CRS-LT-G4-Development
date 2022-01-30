import { Component, OnInit } from '@angular/core';
import { Professor } from './professor';
import { Router } from '@angular/router';
import { ProfessorServiceService } from './professor-service.service';

@Component({
  selector: 'app-professor',
  templateUrl: './professor.component.html',
  styleUrls: ['./professor.component.css']
})
export class ProfessorComponent implements OnInit {

  model = new Professor(1,'', '');

  constructor(private professorService: ProfessorServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  addProfessor(){

    let addProfessor= new Professor(this.model.professorId,this.model.professorName, this.model.professorPassword);

    this.professorService.save(addProfessor).subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/admin']);
      }
     );

  }

}
