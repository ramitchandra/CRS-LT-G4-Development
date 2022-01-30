import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { LoginComponent } from './login/login.component';
import { CourseComponent } from './course/course.component';
import { ProfessorComponent } from './professor/professor.component';
import { ApproveStudentComponent } from './approve-student/approve-student.component';
import { GenerateReportCardComponent } from './generate-report-card/generate-report-card.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    LoginComponent,
    CourseComponent,
    ProfessorComponent,
    ApproveStudentComponent,
    GenerateReportCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent,CourseComponent]
  
})
export class AppModule { }
