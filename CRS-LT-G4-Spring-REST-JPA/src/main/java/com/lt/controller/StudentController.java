package com.lt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.constants.StringConstants;
import com.lt.entity.Student;
import com.lt.service.StudentService;

@RestController
public class StudentController {
	
	
	@Autowired
	StudentService studentService;
	
	public Map<Integer,List<String>> addedCourses = new HashMap<>();
	List<String> courseList = new ArrayList<String>();
	
	@RequestMapping(value="/addStudent", produces = "plain/text", method = RequestMethod.POST)  
	   public  ResponseEntity<String> addStudent(@RequestBody Student student)
	   {  
		studentService.addStudent(student);
		return new ResponseEntity<String>("Student Added", HttpStatus.OK);
	   }  
	
	@RequestMapping(value="/student/registerCourse/{id}",produces = "plain/text", method=RequestMethod.GET)  
	   public  ResponseEntity<String> registerCourse(@PathVariable int id)
	   {  
		studentService.registerCourse(id,courseList);
		return new ResponseEntity<String>("courses Added", HttpStatus.OK);
	   }  
	
	@RequestMapping(value="/student/addCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method=RequestMethod.POST)  
	   public  ResponseEntity<Map<Integer, List<String>>> addCourse(@PathVariable String Course, @PathVariable int id)
	   {  
		courseList.add(Course);
		addedCourses.put(id, courseList);
		//studentService.addCourse(student);
		return new ResponseEntity<Map<Integer, List<String>>>(addedCourses, HttpStatus.OK);
	   }  
	
	@RequestMapping(value="/student/dropCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method=RequestMethod.DELETE)  
	   public  ResponseEntity<Map<Integer, List<String>>> dropCourse(@PathVariable String Course, @PathVariable int id)
	   {  
		//studentService.dropCourse(student);
		courseList.remove(Course);
		addedCourses.put(id, courseList);
		return new ResponseEntity<Map<Integer, List<String>>>(addedCourses, HttpStatus.OK);
	   }  
	
	



}
