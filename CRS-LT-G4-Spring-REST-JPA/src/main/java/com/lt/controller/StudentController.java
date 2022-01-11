package com.lt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.entity.Student;
import com.lt.service.StudentService;

@RestController
public class StudentController {
	
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/addStudent", method=RequestMethod.POST)  
	   public  void addStudent(@RequestBody Student student)
	   {  
		studentService.addStudent(student);
	   }  



}
