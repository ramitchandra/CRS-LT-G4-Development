package com.lt.crs.controllers;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.bean.Student;
import com.lt.crs.business.StudentHandler;

@RestController
public class AdminController {
	
	@Autowired
	StudentHandler studentHandlerImpl;
	
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
	
	@RequestMapping(value = "/admin/validateStudent/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
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
}
