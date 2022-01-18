package com.lt.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.service.ProfessorService;
import com.lt.crs.constants.StringConstants;
import com.lt.entity.Grades;
import com.lt.entity.Student;

@RestController
@CrossOrigin
public class ProfessorController {
	
	@Autowired
	ProfessorService professorService;
	
	@RequestMapping(value = "/professor/getStudentList", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Student>> listStudent() {
		List<Student> studentList = professorService.listStudent();
		return new ResponseEntity<List<Student>>(studentList,HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/professor/addGrades", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addGrades(@RequestBody Grades grades) {
		professorService.addGrades(grades);
		return new ResponseEntity<String>(StringConstants.ADD_GRADES,HttpStatus.OK); 
	}

}
