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
import com.lt.crs.validation.UserAuthorization;
import com.lt.entity.Student;
import com.lt.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */

@RestController
public class StudentController {

	/**
	 * This is used to autowire StudentService
	 */
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserAuthorization userAuthorization;

	public Map<Integer, List<String>> addedCourses = new HashMap<>();
	List<String> courseList = new ArrayList<String>();
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	/**
	 * @param student
	 * @return this is used for student self register
	 */
	@RequestMapping(value = "/addStudent", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		log.info("Inside addStudent method");
		studentService.addStudent(student);
		return new ResponseEntity<String>("Student Added", HttpStatus.OK);
	}

	/**
	 * @param id
	 * @return This method is register for course
	 */
	@RequestMapping(value = "/student/registerCourse/{id}", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> registerCourse(@PathVariable int id) {
		userAuthorization.studentAuthorization();
		studentService.registerCourse(id, courseList);
		return new ResponseEntity<String>("courses Added", HttpStatus.OK);
	}

	/**
	 * @param Course
	 * @param id
	 * @return Students select course implementation
	 */
	@RequestMapping(value = "/student/addCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<Map<Integer, List<String>>> addCourse(@PathVariable String Course, @PathVariable int id) {
		userAuthorization.studentAuthorization();
		courseList.add(Course);
		addedCourses.put(id, courseList);
		// studentService.addCourse(student);
		return new ResponseEntity<Map<Integer, List<String>>>(addedCourses, HttpStatus.OK);
	}

	/**
	 * @param Course
	 * @param id
	 * @return This method is used for deleting course from selected courses
	 */
	@RequestMapping(value = "/student/dropCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public ResponseEntity<Map<Integer, List<String>>> dropCourse(@PathVariable String Course, @PathVariable int id) {
		userAuthorization.studentAuthorization();
		courseList.remove(Course);
		addedCourses.put(id, courseList);
		return new ResponseEntity<Map<Integer, List<String>>>(addedCourses, HttpStatus.OK);
	}

	/**
	 * @param studentId
	 * @return This method is used for making payment for the enrolled courses
	 */
	@RequestMapping(value = "/payment/{studentId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<String> payment(@PathVariable int studentId) {
		userAuthorization.studentAuthorization();
		String paymentStatus = studentService.makePayment(studentId);
		return new ResponseEntity<String>(paymentStatus, HttpStatus.OK);
	}

}
