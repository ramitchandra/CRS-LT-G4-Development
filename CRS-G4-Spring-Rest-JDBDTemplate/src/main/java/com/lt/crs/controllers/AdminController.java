package com.lt.crs.controllers;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.crs.business.CourseHandler;
import com.lt.crs.business.ProfessorHandler;
import com.lt.crs.business.StudentHandler;
import com.lt.dao.AdminDao;

@RestController
public class AdminController {
	
	@Autowired
	StudentHandler studentHandlerImpl;
	
	@Autowired
	AdminDao adminDaoImpl;
	
	@Autowired
	CourseHandler courseHandlerImpl;
	
	@Autowired
	ProfessorHandler professorHandlerImpl;
	
	@RequestMapping(value = "/checkAdmin", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<String> checkAdmin() {
		return new ResponseEntity<String>("Hello Admin",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/listStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Student>> adminListStudent() {
		if(studentHandlerImpl.getStudentList().isEmpty())
			studentHandlerImpl.createDummyStudent();
		return new ResponseEntity<List<Student>>(studentHandlerImpl.getStudentList(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/validateStudent/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<String> validateStudent(@PathVariable int id) {
		adminDaoImpl.approveStudent(id);
		return new ResponseEntity<String>("Validated student: "+ id,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/addCourse", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<String> addCourse(@RequestBody Course course) {	
		 adminDaoImpl.addCourse(course);
		 return new ResponseEntity<String>("Course Added",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/deleteCourse/{courseId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCourse(@PathVariable int courseId) {		
		 adminDaoImpl.deleteCourse(courseId);
		 return new ResponseEntity<String>("Course Deleted: "+ courseId,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/getCourse", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getCourse() {
		return new ResponseEntity<List<Course>>(adminDaoImpl.getAllCourse(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/addProfesor", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<String> addProfessor(@RequestBody Professor professor) {
		 adminDaoImpl.addProfessor(professor);
		 return new ResponseEntity<String>("Professor Added",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/getProfesor", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Professor>> getProfessor() {
		return new ResponseEntity<List<Professor>>(adminDaoImpl.getProfessorList(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/deleteProfessor/{professorId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProfessor(@PathVariable int professorId) {		
		 adminDaoImpl.deleteProfessor(professorId);
		 return new ResponseEntity<String>("Professor Deleted: " + professorId,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/generateReportCard", produces = "text/plain", method = RequestMethod.GET)
	public ResponseEntity<String> generateReportCard() {
		return new ResponseEntity<String>("Report Card Generated",HttpStatus.OK);
	}
}
