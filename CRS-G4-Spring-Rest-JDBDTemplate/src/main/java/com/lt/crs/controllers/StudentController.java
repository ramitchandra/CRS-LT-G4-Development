package com.lt.crs.controllers;

import java.util.ArrayList;
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

import com.lt.bean.Course;
import com.lt.bean.Grades;
import com.lt.bean.Student;
import com.lt.config.JDBCConfiguration;
import com.lt.crs.business.CourseHandler;
import com.lt.crs.business.PaymentHandler;
import com.lt.crs.business.ProfessorHandler;
import com.lt.crs.business.StudentHandler;
import com.lt.crs.exception.CourseAlreadySelectedException;
import com.lt.crs.exception.CourseNotAddedException;
import com.lt.crs.exception.NoCoursesAddedException;
import com.lt.crs.validation.UserAuthorization;
import com.lt.dao.AdminDao;
import com.lt.dao.GradesDAO;
import com.lt.dao.StudentDao;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@RestController
public class StudentController {

	@Autowired
	StudentHandler studentHandlerImpl;

	@Autowired
	CourseHandler courseHandlerImpl;

	@Autowired
	PaymentHandler paymentHandlerImpl;

	@Autowired
	ProfessorHandler professorHandlerImpl;

	@Autowired
	StudentDao StudentDaoImpl;

	@Autowired
	GradesDAO gradesDAOImpl;

	@Autowired
	AdminDao adminDaoImpl;

	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Autowired
	UserAuthorization userAuthorization;

	/**
	 * @param id This method is register for course
	 */
	@RequestMapping(value = "/student/registerCourse/{id}", produces = "plain/text", method = RequestMethod.GET)
	public ResponseEntity<String> registerCourse(@PathVariable int id) {
		userAuthorization.studentAuthorization();
		List<String> course = studentHandlerImpl.getAddedCourses().get(id);
		if (course == null)
			throw new NoCoursesAddedException();
		else
			StudentDaoImpl.registerCourseImpl(id, course);
		return new ResponseEntity<String>("Course Registration Successfully", HttpStatus.OK);
	}

	/**
	 * @param Course
	 * @param id
	 * @return Students select course implementation
	 */
	@RequestMapping(value = "/student/addCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<Map<Integer, List<String>>> addCourse(@PathVariable String Course, @PathVariable int id) {
		userAuthorization.studentAuthorization();
		List<String> courseList = new ArrayList<String>();
		if (studentHandlerImpl.getAddedCourses().get(id) != null) {
			courseList = studentHandlerImpl.getAddedCourses().get(id);
		}

		List<Course> courseCatalog = adminDaoImpl.getAllCourse();
		for (Course c : courseCatalog) {
			if (c.getCourseName().equalsIgnoreCase(Course)) {
				if (!courseList.contains(Course))
					courseList.add(Course);
				else
					throw new CourseAlreadySelectedException();
			}
		}
		studentHandlerImpl.getAddedCourses().put(id, courseList);
		return new ResponseEntity<Map<Integer, List<String>>>(studentHandlerImpl.getAddedCourses(), HttpStatus.OK);
	}

	/**
	 * @param Course
	 * @param id
	 * @return This method is used for deleting course from selected courses
	 */
	@RequestMapping(value = "/student/dropCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public ResponseEntity<Map<Integer, List<String>>> dropCourse(@PathVariable String Course, @PathVariable int id) {
		userAuthorization.studentAuthorization();
		List<String> courseList = studentHandlerImpl.getAddedCourses().get(id);
		if (courseList.contains(Course))
			courseList.remove(Course);
		else
			throw new CourseNotAddedException();
		studentHandlerImpl.getAddedCourses().put(id, courseList);
		return new ResponseEntity<Map<Integer, List<String>>>(studentHandlerImpl.getAddedCourses(), HttpStatus.OK);
	}

	/**
	 * @param student This method is for student self registration
	 */
	@RequestMapping(value = "/student/addStudent", produces = "plain/text", method = RequestMethod.POST)
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		StudentDaoImpl.addStudent(student);
		return new ResponseEntity<String>("Student Registered Successfully!!!", HttpStatus.OK);
	}

	/**
	 * @param studentId
	 * @return 
	 * This method is to return the Grade of the student based on his/her Id.
	 */
	@RequestMapping(value = "/student/viewGradeBasedOnId/{studentId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Grades>> listGradeBasedonId(@PathVariable int studentId) {
		userAuthorization.studentAuthorization();
		List<Grades> listTheGrades = gradesDAOImpl.viewGradeOnId(studentId);
		System.out.println(listTheGrades);
		for (Grades grade : listTheGrades) {
			if (grade.getStudentId() == studentId) {
				grade.getGrade();
				return new ResponseEntity<List<Grades>>(listTheGrades, HttpStatus.OK);
			}

		}
		return new ResponseEntity<List<Grades>>(listTheGrades, HttpStatus.OK);
	}

	/**
	 * @param studentId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/payment/{studentId}")
	public ResponseEntity<String> payment(@PathVariable int studentId) {
		userAuthorization.studentAuthorization();
		String paymentStatus = paymentHandlerImpl.makePayment(studentId);
		return new ResponseEntity<String>(paymentStatus, HttpStatus.OK);
	}
}
