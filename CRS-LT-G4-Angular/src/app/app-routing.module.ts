import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { CourseComponent } from './course/course.component'
import { ProfessorComponent } from './add-professor/professor.component';
import {DeleteCourseComponent} from './delete-course/delete-course.component'
import {DeleteProfessorComponent} from './delete-professor/delete-professor.component'

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'course', component: CourseComponent },
  { path: 'deleteCourse', component: DeleteCourseComponent },
  { path: 'professor', component: ProfessorComponent },
  { path: 'deleteProfessor', component: DeleteProfessorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
