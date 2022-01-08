package com.lt.crs.controllers;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Course;
import com.lt.bean.Grades;
import com.lt.bean.Student;
import com.lt.crs.exception.EmptyStudentListException;
import com.lt.dao.ProfessorDao;
import com.lt.dao.ProfessorDaoImpl;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@RestController
public class ProfessorController {

	@Autowired
	ProfessorDao ProfessorDaoImpl;

	/**
	 * @return
	 * This method return list of students who are not assigned grades
	 */
	@RequestMapping(value = "/professor/listStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Student>> listStudent() {
		List<Student> studentList = ProfessorDaoImpl.listStudent();
		if(studentList.isEmpty()) 
			throw new EmptyStudentListException();
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}

	/**
	 * @param grade
	 * @return
	 * In this method professor assigns grades
	 */
	@RequestMapping(value = "/professor/assignGrades", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<String> assignGrades(@RequestBody Grades grade) {
		
		ProfessorDaoImpl.assignGrade(grade);
		return new ResponseEntity<String>("Grades Assigned", HttpStatus.OK);
	}
}