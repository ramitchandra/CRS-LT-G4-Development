/**
 * 
 */
package com.lt.controller;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.constants.StringConstants;
import com.lt.entity.Course;
import com.lt.entity.ExceptionObject;
import com.lt.entity.Grades;
import com.lt.entity.Professor;
import com.lt.entity.Student;
import com.lt.service.AdminService;

/**
 * @author user112
 *
 */
@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/admin/getAllStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<?> getAllStudent() {
		log.info("Inside getStudent method");
		ExceptionObject eo =  authorizationApi();
		if(eo.getMessage() != null && !eo.getMessage().isEmpty())
			return new ResponseEntity<ExceptionObject>(eo, HttpStatus.OK);
		return new ResponseEntity<List<Student>>(adminService.getAllStudentList(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/getStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<?> getStudent() {
		log.info("Inside getStudent method");
		ExceptionObject eo =  authorizationApi();
		if(eo.getMessage() != null && !eo.getMessage().isEmpty())
			return new ResponseEntity<ExceptionObject>(eo,HttpStatus.OK);
		return new ResponseEntity<List<Map<String,Object>>>(adminService.getStudentList(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/validateStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<?> validateStudent(@RequestBody Map<String,Object> inputMap) {
		log.info("Inside validateStudent method");
		ExceptionObject eo =  authorizationApi();
		if(eo.getMessage() != null && !eo.getMessage().isEmpty()) {
			return new ResponseEntity<>(eo, HttpStatus.OK);
		}
		int id= (int) inputMap.get("Id");
		adminService.approveStudent(id);
		return new ResponseEntity<Map<String, Object>>(Collections.singletonMap("message",StringConstants.STUDENT_VALIDATION+id),HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/addCourse", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<?> addCourse(@RequestBody Course course) {	
		log.info("Inside addCourse method");
		ExceptionObject eo =  authorizationApi();
		if(eo.getMessage() != null && !eo.getMessage().isEmpty())
			return new ResponseEntity<>(eo, HttpStatus.OK);
		adminService.addCourse(course);
		return new ResponseEntity<Map<String, Object>>(Collections.singletonMap("message",StringConstants.ADD_COURSE),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/deleteCourse", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCourse(@RequestBody Map<String,Object> inputMap) {		
		log.info("Inside deleteCourse method");
		ExceptionObject eo =  authorizationApi();
		if(eo.getMessage() != null && !eo.getMessage().isEmpty())
			return new ResponseEntity<ExceptionObject>(eo, HttpStatus.OK);
		for(Map.Entry<String, Object> pair : inputMap.entrySet())
			adminService.deleteCourse(Integer.valueOf(pair.getKey()),String.valueOf(pair.getValue()));
		return new ResponseEntity<Map<String, Object>>(Collections.singletonMap("message",StringConstants.DELETE_COURSE),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/addProfesor", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public ResponseEntity<?> addProfessor(@RequestBody Professor professor) {
		log.info("Inside addProfessor method");
		ExceptionObject eo =  authorizationApi();
		if(eo.getMessage() != null && !eo.getMessage().isEmpty())
			return new ResponseEntity<ExceptionObject>(eo, HttpStatus.OK);
		adminService.addProfessor(professor);
		return new ResponseEntity<Map<String, Object>>(Collections.singletonMap("message",StringConstants.ADD_PROFESSOR),HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/admin/deleteProfessor", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProfessor(@RequestBody Map<String, Object> inputMap) {	
		log.info("Inside deleteProfessor method");
		ExceptionObject eo =  authorizationApi();
		if(eo.getMessage() != null && !eo.getMessage().isEmpty())
			return new ResponseEntity<ExceptionObject>(eo, HttpStatus.OK);
		int professorId = (int) inputMap.get("Id");
		adminService.deleteProfessor(professorId);
		return new ResponseEntity<Map<String, Object>>(Collections.singletonMap("message",StringConstants.DELETE_PROFESSOR + professorId),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/gererateReportCard", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<?> gererateReportCard() {	
		log.info("Inside gererateReportCard method");
		ExceptionObject eo =  authorizationApi();
		if(eo.getMessage() != null && !eo.getMessage().isEmpty())
			return new ResponseEntity<ExceptionObject>(eo, HttpStatus.OK);
		return new ResponseEntity<List<Grades>>(adminService.gererateReportCard(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/validateReportCard", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<?> validateReportCard(@RequestBody Map<String,Object> inputMap) {
		log.info("Inside validateReportCard method");
		ExceptionObject eo =  authorizationApi();
		if(eo.getMessage() != null && !eo.getMessage().isEmpty()) {
			return new ResponseEntity<>(eo, HttpStatus.OK);
		}
		int id= (int) inputMap.get("Id");
		adminService.validateReportCard(id);
		return new ResponseEntity<Map<String, Object>>(Collections.singletonMap("message","Report card generated for student: "+id),HttpStatus.OK);
	}

	private ExceptionObject authorizationApi() {
		if(adminService.getLoggedInUser().isEmpty()) {
			return new ExceptionObject(LocalDateTime.now().toString(),"401","Unauthorized",StringConstants.USER_NOTLOGGED);
		}
		else if(adminService.getLoggedInUser().get(0).getRoleId() != 101) {
			return new ExceptionObject(LocalDateTime.now().toString(),"401","Unauthorized",StringConstants.ACCESS_NOTAUTHORISED);
		} else {
			return new ExceptionObject();
		}
	}
}

