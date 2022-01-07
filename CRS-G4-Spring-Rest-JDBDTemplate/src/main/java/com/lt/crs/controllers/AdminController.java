package com.lt.crs.controllers;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String checkAdmin() {
		return "Hello Admin";
	}
	
	@RequestMapping(value = "/admin/listStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<Student> adminListStudent() {
		if(studentHandlerImpl.getStudentList().isEmpty())
			studentHandlerImpl.createDummyStudent();
		return studentHandlerImpl.getStudentList();
	}
	
	@RequestMapping(value = "/admin/validateStudent/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public void validateStudent(@PathVariable int id) {
		adminDaoImpl.approveStudent(id);	
	}
	
	@RequestMapping(value = "/admin/addCourse", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course) {	
		 adminDaoImpl.addCourse(course);
	}
	
	@RequestMapping(value = "/admin/deleteCourse/{courseId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable int courseId) {		
		 adminDaoImpl.deleteCourse(courseId);
	}
	
	@RequestMapping(value = "/admin/getCourse", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<Course> getCourse() {
		return adminDaoImpl.getAllCourse();
	}
	
	@RequestMapping(value = "/admin/addProfesor", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public void addProfessor(@RequestBody Professor professor) {
		 adminDaoImpl.addProfessor(professor);
	}
	
	@RequestMapping(value = "/admin/getProfesor", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<Professor> getProfessor() {
		return adminDaoImpl.getProfessorList();
	}
	
	@RequestMapping(value = "/admin/deleteProfessor/{professorId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public void deleteProfessor(@PathVariable int professorId) {		
		 adminDaoImpl.deleteProfessor(professorId);
	}
	
	@RequestMapping(value = "/admin/generateReportCard", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public String generateReportCard() {
		return "Report Card Generated";
	}
}
