package com.lt.crs.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Course;
import com.lt.bean.Grades;
import com.lt.bean.Student;
import com.lt.crs.business.CourseHandler;
import com.lt.crs.business.ProfessorHandler;
import com.lt.crs.business.StudentHandler;
import com.lt.dao.StudentDao;

@RestController
public class StudentController {
	
	@Autowired
	StudentHandler studentHandlerImpl;
	
	@Autowired
	CourseHandler courseHandlerImpl;
	
	@Autowired
	ProfessorHandler professorHandlerImpl;
	
	@Autowired
	StudentDao StudentDaoImpl;
	
	
	@RequestMapping(value = "/student/registerCourse/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public void registerCourse(@PathVariable int id) {
		List course = studentHandlerImpl.getAddedCourses().get(id) ;
		StudentDaoImpl.registerCourseImpl(id,course);
	
	}

	@RequestMapping(value = "/student/addCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public Map<Integer, List<String>> addCourse(@PathVariable String Course, @PathVariable int id) {
		List<String> courseList = new ArrayList<String>();
		if(studentHandlerImpl.getAddedCourses().get(id) != null) {
		courseList = studentHandlerImpl.getAddedCourses().get(id);
	}
	
	List<Course> courseCatalog = courseHandlerImpl.getCourseList();	
	for(Course c : courseCatalog) {
		if(c.getCourseName().equalsIgnoreCase(Course)) {
			if(!courseList.contains(Course))
				courseList.add(Course);
		}		
	}	
	studentHandlerImpl.getAddedCourses().put(id, courseList);
	return studentHandlerImpl.getAddedCourses();
	}
	

	@RequestMapping(value = "/student/dropCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public Map<Integer, List<String>> dropCourse(@PathVariable String Course, @PathVariable int id) {
		List<String> courseList = studentHandlerImpl.getAddedCourses().get(id);
		if(courseList.contains(Course))
			courseList.remove(Course);
		studentHandlerImpl.getAddedCourses().put(id, courseList);
		return studentHandlerImpl.getAddedCourses();
	}
	
	@RequestMapping(value = "/student/addStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public Student addStudent(@RequestBody Student student) {
		return studentHandlerImpl.addStudent(student);
		
	}
	
	@RequestMapping(value = "/student/getStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<Student> getStudent() {
		return studentHandlerImpl.getStudentList();

	}
	
	@RequestMapping(value = "/student/viewGrade", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<Grades> listGradeForStudent() {
			return professorHandlerImpl.insertGrade();
	}
	
	@RequestMapping(value = "/student/viewGradeBasedOnId/{Id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public Grades listGradeBasedonId(@PathVariable int Id) {
		List<Grades> listTheGrades = professorHandlerImpl.insertGrade();
		System.out.println(listTheGrades);
		for(Grades grade : listTheGrades) {
			if(grade.getStudentId() == Id) {
				grade.getGrade();
				return grade;
			}
			
		}
		
		return new Grades();
	}
}
