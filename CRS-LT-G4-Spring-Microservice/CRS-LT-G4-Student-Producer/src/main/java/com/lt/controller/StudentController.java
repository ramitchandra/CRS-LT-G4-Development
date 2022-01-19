package com.lt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Student;

@RestController
public class StudentController {
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public Student firstPage() {

		Student student = new Student();
		student.setStudentId(101);
		student.setStudentName("Ram");
		student.setStudentEmail("ram@gmail.com");
		student.setStudentUsername("ram");
		student.setStudentPassword("12345");

		return student;
	}


}
