package com.lt.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.entity.Grades;
import com.lt.entity.Student;
import com.lt.service.ProfessorService;

/**
 * @author Naman, Radha, Ramit, Purnima, Sai, Vignesh
 *
 */
@RestController
public class ProfessorProducerController {

	/**
	 * This is used to autowire ProfessorService bean
	 */
	@Autowired
	ProfessorService professorService;

	/**
	 * @return This method return list of students who are not assigned grades
	 */
	@RequestMapping(value = "/professor/getStudentList", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Student>> listStudent() {
		List<Student> studentList = professorService.listStudent();
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}

	/**
	 * @param grade
	 * @return In this method professor assigns grades
	 */
	@RequestMapping(value = "/professor/addGrades", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addGrades(@RequestBody Grades grades) {
		professorService.addGrades(grades);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}