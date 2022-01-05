package com.lt.crs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.bean.Course;

@RestController
public class StudentController {
	List<String> courseList = new ArrayList<String>();	
	
	@RequestMapping(value = "student/registerCourse/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<String> registerCourse() {
		return courseList;
	
	}

	@RequestMapping(value = "student/addCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public void addCourse(@PathVariable String Course) {
	
	List<Course> courseCatalog = new ArrayList<Course>();	//AVAILABLE COURSES
	for(Course c : courseCatalog) {
		if(c.getCourseName().equalsIgnoreCase(Course)) {
			if(!courseList.contains(Course))
				courseList.add(Course);
			
		}
	}
	}

	@RequestMapping(value = "/student/dropCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public void dropCourse(@PathVariable String Course) {
		if(!courseList.contains(Course))
			courseList.remove(Course);
		
	}
}
