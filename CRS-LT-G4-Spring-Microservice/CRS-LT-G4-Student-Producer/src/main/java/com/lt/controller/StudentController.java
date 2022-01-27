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

//import com.lt.crs.validation.UserAuthorization;
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
	
//	@Autowired
//	UserAuthorization userAuthorization;

	public Map<Integer, List<String>> addedCourses = new HashMap<>();
	List<String> courseList = new ArrayList<String>();
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@RequestMapping(value = "/getMessage", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> getmessage() {
		return new ResponseEntity<String>("Student Added message", HttpStatus.OK);
	}

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
	@RequestMapping(value = "/student/registerCourse", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> registerCourse(@RequestBody Map<String,Object> coursesMap) {
		log.info("Inside registerCourse method");
		System.out.println(courseList);
		int id = Integer.parseInt((String) coursesMap.get("Id"));
		System.out.println(id);
		//userAuthorization.studentAuthorization();
		studentService.registerCourse(id, courseList);
		return new ResponseEntity<String>("courses Added", HttpStatus.OK);
	}

	/**
	 * @param Course
	 * @param id
	 * @return Students select course implementation
	 */
	@RequestMapping(value = "/student/addCourse", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<Map<Integer, List<String>>> addCourse(@RequestBody Map<String,Object> coursesMap) {
		log.info("Inside addCourse method");
		
		int id = Integer.parseInt((String) coursesMap.get("Id"));
		//userAuthorization.studentAuthorization();
		courseList.add((String) coursesMap.get("Course"));
		addedCourses.put(id, courseList);
		//studentService.registerCourse(id, courseList);
		//studentService.addCourse(student);
		return new ResponseEntity<Map<Integer, List<String>>>(addedCourses, HttpStatus.OK);
	}

	/**
	 * @param Course
	 * @param id
	 * @return This method is used for deleting course from selected courses
	 */
	@RequestMapping(value = "/student/dropCourse",  produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public ResponseEntity<Map<Integer, List<String>>> dropCourse(@RequestBody Map<String,Object> coursesMap) {
		log.info("Inside dropCourse method");
		int id = Integer.parseInt((String) coursesMap.get("Id"));
		courseList.remove((String) coursesMap.get("Course"));
		//studentService.dropCourse(id, (String) coursesMap.get("Course"));
		//userAuthorization.studentAuthorization();
		addedCourses.put(id, courseList);
		return new ResponseEntity<Map<Integer, List<String>>>(addedCourses, HttpStatus.OK);
	}

	/**
	 * @param studentId
	 * @return This method is used for making payment for the enrolled courses
	 */
	@RequestMapping(value = "/payment/{studentId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<String> payment(@PathVariable int studentId) {
		log.info("Inside payment method");
		//userAuthorization.studentAuthorization();
		String paymentStatus = studentService.makePayment(studentId);
		return new ResponseEntity<String>(paymentStatus, HttpStatus.OK);
	}

}
