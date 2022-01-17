package com.lt.controller;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.service.GradeService;
import com.lt.entity.Grades;

@RestController
public class GradesController {
	
	@Autowired
	private GradeService gradeService;
	
	@RequestMapping(value="/viewGrade", method = RequestMethod.GET)
	public List<Grades> viewGrades() {
		return gradeService.viewGrades();
	}
	
	/*@RequestMapping(value="/viewGradeBasedOnId/{studentId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<Grades> viewGradeBasedOnId(@PathVariable int studentId) {
		List<Grades> listTheGrades = gradeService.viewGradesBasedOnId(studentId);
		System.out.println(listTheGrades);
		for (Grades grade : listTheGrades) {
			if (grade.getStudentId() == studentId) {
				grade.getGrade();
				return (List<Grades>) new ResponseEntity<>(listTheGrades, HttpStatus.OK);
			}

		}
		return (List<Grades>) new ResponseEntity<>(listTheGrades, HttpStatus.OK);
	} */
	

}
