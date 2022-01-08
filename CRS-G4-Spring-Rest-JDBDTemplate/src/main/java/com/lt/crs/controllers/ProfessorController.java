package com.lt.crs.controllers;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Grades;
import com.lt.bean.Student;
import com.lt.crs.validation.UserAuthorization;
import com.lt.dao.ProfessorDao;

@RestController
public class ProfessorController {
	
	@Autowired
	ProfessorDao ProfessorDaoImpl;
	
	@Autowired
	UserAuthorization userAuthorization;
	
	@RequestMapping(value = "/professor/listStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Student>> listStudent() {
		userAuthorization.professorAuthorization();
		List<Student> studentList = ProfessorDaoImpl.listStudent();
		return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);		 		
	}
	
	@RequestMapping(value = "/professor/assignGrades", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<String> assignGrades(@RequestBody Grades grade) {
		userAuthorization.professorAuthorization();
		ProfessorDaoImpl.assignGrade(grade);
		return new ResponseEntity<String>("Grades Assigned",HttpStatus.OK);
	}
}
