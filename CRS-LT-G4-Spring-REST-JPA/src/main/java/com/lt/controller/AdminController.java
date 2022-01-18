package com.lt.controller;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.constants.StringConstants;
import com.lt.crs.validation.UserAuthorization;
import com.lt.entity.Course;
import com.lt.entity.Professor;
import com.lt.entity.Student;
import com.lt.service.AdminService;
import com.lt.service.StudentService;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@RestController
@CrossOrigin
public class AdminController {
	
	/**
	 * This is used to autowire userAuthorization bean
	 */
//	@Autowired
//	UserAuthorization userAuthorization;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserAuthorization userAuthorization;
	
	
	/**
	 * @return
	 * This is used to fetch all students.
	 */
	@RequestMapping(value = "/admin/getStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudent() {
		userAuthorization.adminAuthorization();
		return new ResponseEntity<List<Student>>(studentService.getStudentList(),HttpStatus.OK);
	}
	
	/**
	 * @return
	 * This is used to fetch students pending for approval.
	 */
	@RequestMapping(value = "/admin/listStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Map<String,String>>> adminListStudent() {
		userAuthorization.adminAuthorization();
		List<Map<String,String>> pendingApproval = studentService.getStudents();
//		if(pendingApproval.isEmpty())
//			throw new NoPendingApprovalException();
		return new ResponseEntity<List<Map<String,String>>>(pendingApproval,HttpStatus.OK);
	}
	
	/**
	 * @param id
	 * @return
	 * This is used to approve students on basis of id.
	 */
	@RequestMapping(value = "/admin/validateStudent/{id}", produces = "plain/text", method = RequestMethod.PUT)
	public ResponseEntity<String> validateStudent(@PathVariable int id) {
		userAuthorization.adminAuthorization();
		adminService.approveStudent(id);
//			throw new InvalidStudentIdException();
		return new ResponseEntity<String>(StringConstants.STUDENT_VALIDATION + id,HttpStatus.OK);
	}
	
	/**
	 * @param course
	 * @return
	 * This is used to add courses in course catalogue.
	 */
	@RequestMapping(value = "/admin/addCourse", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addCourse(@RequestBody Course course) {	
		userAuthorization.adminAuthorization();
		adminService.addCourse(course);
//			throw new CourseAlreadyExistException();
		return new ResponseEntity<String>(StringConstants.ADD_COURSE,HttpStatus.OK);
	}
	
	/**
	 * @param courseId
	 * @return
	 * This is used to delete course from course catalogue on basis of courseId.
	 */
	@RequestMapping(value = "/admin/deleteCourse/{courseId}/{courseName}", produces = "plain/text", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCourse(@PathVariable int courseId, @PathVariable String courseName) {		
		userAuthorization.adminAuthorization(); 
		adminService.deleteCourse(courseId,courseName);
//			 throw new CourseIdNotFoundException();
		 return new ResponseEntity<String>(StringConstants.DELETE_COURSE + courseId,HttpStatus.OK);
	}
	
	/**
	 * @return
	 * This is used to fetch list of all courses.
	 */
	@RequestMapping(value = "/admin/getCourse", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Course>> getCourse() {
		userAuthorization.adminAuthorization();
		List<Course> courseList=adminService.getAllCourse();
//		if(courseList.isEmpty())
//			throw new CourseNotFoundException();
		return new ResponseEntity<List<Course>>(courseList,HttpStatus.OK);
	}
	
	/**
	 * @param professor
	 * @return
	 * This is used to add professor.
	 */
	@RequestMapping(value = "/admin/addProfesor", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addProfessor(@RequestBody Professor professor) {
		userAuthorization.adminAuthorization(); 
		adminService.addProfessor(professor);
		return new ResponseEntity<String>(StringConstants.ADD_PROFESSOR,HttpStatus.OK);
	}
	
	/**
	 * @return
	 * This is used to fetch list of all professors.
	 */
	@RequestMapping(value = "/admin/getProfesor", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Professor>> getProfessor() {
		userAuthorization.adminAuthorization();
		List<Professor> profList= adminService.getProfessorList();
//		if(profList.isEmpty())
//			throw new ProfessorNotFoundException();
		return new ResponseEntity<List<Professor>>(profList,HttpStatus.OK);
	}
	
	/**
	 * @param professorId
	 * @return
	 * This is used to delete professor on basis of professorId.
	 */
	@RequestMapping(value = "/admin/deleteProfessor/{professorId}", produces = "plain/text", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteProfessor(@PathVariable int professorId) {		
		userAuthorization.adminAuthorization(); 
		adminService.deleteProfessor(professorId);
//			 throw new ProfessorIdNotFoundException(); 
		 return new ResponseEntity<String>(StringConstants.DELETE_PROFESSOR + professorId,HttpStatus.OK);
	}
	
	/**
	 * @return
	 * This is used to generate report card of all students.
	 */
//	@RequestMapping(value = "/admin/generateReportCard", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
//	public ResponseEntity<List<Grades>> generateReportCard() {
//		userAuthorization.adminAuthorization();
//		List<Grades> gradeLists = gradeDAOImpl.viewGrades();
//		if(gradeLists.isEmpty())
//			throw new GradeNotFoundException();
//		return new ResponseEntity<List<Grades>>(gradeLists,HttpStatus.OK);
//	}
}
