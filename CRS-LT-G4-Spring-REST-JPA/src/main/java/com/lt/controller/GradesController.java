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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lt.service.GradeService;
import com.lt.entity.Grades;


/**
 * @author Naman, Radha, Ramit, Purnima, Sai, Vignesh
 *
 */
@RestController
public class GradesController {
	
	@Autowired
	private GradeService gradeService;
	
	private static final Logger log = LoggerFactory.getLogger(GradesController.class);
	/**
	 * @return This controller method is used to view all the Grades
	 */
	@RequestMapping(value="/viewGrade", method = RequestMethod.GET)
	public List<Grades> viewGrades() {
		log.info("Inside viewGrades method");
		return gradeService.viewGrades();
	}
	
	/**
	 * @param studentId
	 * @return This controller method is used to view the Grades of the student based on ID
	 */
	@RequestMapping(value="/viewGradeBasedOnId/{studentId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public List<Grades> viewGradeBasedOnId(@PathVariable int studentId) {
		log.info("Inside viewGradeBasedOnId method");
		List<Grades> listTheGrades = gradeService.viewGradesBasedOnId(studentId);
		return listTheGrades;
	} 
	

}
