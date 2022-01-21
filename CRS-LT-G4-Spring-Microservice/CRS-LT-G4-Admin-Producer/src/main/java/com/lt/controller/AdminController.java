/**
 * 
 */
package com.lt.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.constants.StringConstants;
import com.lt.crs.exception.NoUserLoggedInException;
import com.lt.crs.exception.UnauthorizedAccessException;
import com.lt.entity.Course;
import com.lt.entity.Professor;
import com.lt.entity.Student;
import com.lt.service.AdminService;

/**
 * @author user112
 *
 */
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/admin/getAllStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getAllStudent() {
		log.info("Inside getStudent method");
		if(adminService.getLoggedInUser().isEmpty())
			throw new NoUserLoggedInException();
		else if(adminService.getLoggedInUser().get(0).getRoleId() != 101)
			throw new UnauthorizedAccessException();
		return new ResponseEntity<List<Student>>(adminService.getAllStudentList(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/getStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Map<String,String>>> getStudent() {
		log.info("Inside getStudent method");
		if(adminService.getLoggedInUser().isEmpty())
			throw new NoUserLoggedInException();
		else if(adminService.getLoggedInUser().get(0).getRoleId() != 101)
			throw new UnauthorizedAccessException();
		return new ResponseEntity<List<Map<String,String>>>(adminService.getStudentList(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/validateStudent", produces = "plain/text", method = RequestMethod.PUT)
	public ResponseEntity<String> validateStudent(@RequestBody Map<String,Object> inputMap) {
		log.info("Inside validateStudent method");
		if(adminService.getLoggedInUser().isEmpty())
			throw new NoUserLoggedInException();
		else if(adminService.getLoggedInUser().get(0).getRoleId() != 101)
			throw new UnauthorizedAccessException();
		int id= (int) inputMap.get("Id");
		adminService.approveStudent(id);
		return new ResponseEntity<String>(StringConstants.STUDENT_VALIDATION + id,HttpStatus.OK);
	}

	@RequestMapping(value = "/admin/addCourse", produces = "plain/text", method = RequestMethod.POST)
	
	public ResponseEntity<String> addCourse(@RequestBody Course course) {	
		log.info("Inside addCourse method");
		if(adminService.getLoggedInUser().isEmpty())
			throw new NoUserLoggedInException();
		else if(adminService.getLoggedInUser().get(0).getRoleId() != 101)
			throw new UnauthorizedAccessException();
		
//		Course course = new Course();
//		try {
//			course = new ObjectMapper().readValue(courseJSON, Course.class);
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		adminService.addCourse(course);
		return new ResponseEntity<String>(StringConstants.ADD_COURSE,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/deleteCourse", produces = "plain/text", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCourse(@RequestBody Map<String,Object> inputMap) {		
		log.info("Inside deleteCourse method");
		if(adminService.getLoggedInUser().isEmpty())
			throw new NoUserLoggedInException();
		else if(adminService.getLoggedInUser().get(0).getRoleId() != 101)
			throw new UnauthorizedAccessException();
		for(Map.Entry<String, Object> pair : inputMap.entrySet())
			adminService.deleteCourse(Integer.valueOf(pair.getKey()),String.valueOf(pair.getValue()));
		return new ResponseEntity<String>(StringConstants.DELETE_COURSE,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/addProfesor", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addProfessor(@RequestBody Professor professor) {
		log.info("Inside addProfessor method");
		if(adminService.getLoggedInUser().isEmpty())
			throw new NoUserLoggedInException();
		else if(adminService.getLoggedInUser().get(0).getRoleId() != 101)
			throw new UnauthorizedAccessException();
		adminService.addProfessor(professor);
		return new ResponseEntity<String>(StringConstants.ADD_PROFESSOR,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/deleteProfessor", produces = "plain/text", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProfessor(@RequestBody Map<String, Object> inputMap) {	
		log.info("Inside deleteProfessor method");
		if(adminService.getLoggedInUser().isEmpty())
			throw new NoUserLoggedInException();
		else if(adminService.getLoggedInUser().get(0).getRoleId() != 101)
			throw new UnauthorizedAccessException();
		int professorId = (int) inputMap.get("Id");
		adminService.deleteProfessor(professorId);
		return new ResponseEntity<String>(StringConstants.DELETE_PROFESSOR + professorId,HttpStatus.OK);
	}
}

