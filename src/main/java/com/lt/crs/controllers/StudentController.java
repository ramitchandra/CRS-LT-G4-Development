package com.lt.crs.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Grades;
import com.lt.crs.business.CourseHandler;
import com.lt.crs.business.ProfessorHandler;
import com.lt.crs.bean.Student;
import com.lt.crs.business.StudentHandler;

@RestController
public class StudentController {
	
	Map<Integer,List> addedCourses = new HashMap<Integer,List>();
	
	@Autowired
	StudentHandler studentHandlerImpl;
	
	@Autowired
	CourseHandler courseHandlerImpl;
	
	@Autowired
	ProfessorHandler professorHandlerImpl;
	
	@RequestMapping(value = "student/registerCourse/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<String> registerCourse(@PathVariable int id) {
		return addedCourses.get(id) ;
	
	}

	@RequestMapping(value = "student/addCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public Map<Integer, List> addCourse(@PathVariable String Course, @PathVariable int id) {
		List<String> courseList = new ArrayList<String>();
		if(addedCourses.get(id) != null) {
		courseList = addedCourses.get(id);
	}
	
	List<Course> courseCatalog = courseHandlerImpl.getCourseList();	
	for(Course c : courseCatalog) {
		if(c.getCourseName().equalsIgnoreCase(Course)) {
			if(!courseList.contains(Course))
				courseList.add(Course);
		}		
	}	
	addedCourses.put(id, courseList);
	return addedCourses;
	}

	@RequestMapping(value = "/student/dropCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public Map<Integer, List> dropCourse(@PathVariable String Course, @PathVariable int id) {
		List<String> courseList = addedCourses.get(id);
		if(courseList.contains(Course))
			courseList.remove(Course);
		addedCourses.put(id, courseList);
		return addedCourses;
	}
	
	@RequestMapping(value = "/student/addStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public Student dropCourse(@RequestBody Student student) {
		return studentHandlerImpl.addStudent(student);
		
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
