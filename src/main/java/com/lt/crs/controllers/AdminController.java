package com.lt.crs.controllers;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Professor;
import com.lt.crs.bean.Student;
import com.lt.crs.business.CourseHandler;
import com.lt.crs.business.ProfessorHandler;
import com.lt.crs.business.StudentHandler;

@RestController
public class AdminController {
	
	@Autowired
	StudentHandler studentHandlerImpl;
	
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
	public Student validateStudent(@PathVariable int id) {
		List<Student> studentList = studentHandlerImpl.getStudentList();
		for(Student student : studentList) {
			if(student.getStudentId() == id) {
				student.setApproved(true);
				return student;
			}
		}
		return new Student();
	}
	
	@RequestMapping(value = "/admin/addCourse", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public List<Course> addCourse(@RequestBody Course course) {
		
		courseHandlerImpl.addCourse(course);
		
		return courseHandlerImpl.getCourseList();
	}
	
	@RequestMapping(value = "/admin/deleteCourse/{courseId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public Course deleteCourse(@PathVariable int courseId) {
		
		Course deletedCourse = courseHandlerImpl.deleteCourse(courseId);
		
		return deletedCourse;
	}
	
	@RequestMapping(value = "/admin/addProfesor", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public Professor addProfessor(@RequestBody Professor professor) {
		return professorHandlerImpl.addProfessor(professor);
	}
	
	@RequestMapping(value = "/admin/getProfesor", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<Professor> getProfessor() {
		return professorHandlerImpl.getProfList();
	}
	
	@RequestMapping(value = "/admin/generateReportCard", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public String generateReportCard() {
		return "Report Card Generated";
	}
}
