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
import com.lt.crs.exception.CourseAlreadyRegisterException;
import com.lt.crs.exception.CourseAlreadySelectedException;
import com.lt.crs.exception.CourseNotAddedException;
import com.lt.crs.exception.GradeNotFoundException;
import com.lt.crs.exception.NoCoursesAddedException;
import com.lt.crs.exception.WrongCourseSelectionException;
import com.lt.dao.AdminDao;
import com.lt.dao.GradesDAO;
import com.lt.dao.StudentDao;

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
	
	@RequestMapping(value = "/student/registerCourse/{id}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public void registerCourse(@PathVariable int id) {
	List<String> course = studentHandlerImpl.getAddedCourses().get(id) ;
	String sql = "Select courseName from enrolledcourses where studentId = "+id;
	List<String> CourseEnrolled = jdbcConfiguration.jdbcTemplate().queryForList(sql,String.class);
	//System.out.println(Courses);
	if(course == null)
		throw new NoCoursesAddedException();
	else
		/*for(String ce: CourseEnrolled) {
			if(course.contains(ce)) {
				throw new CourseAlreadyRegisterException();
			}
			else {
				StudentDaoImpl.registerCourseImpl(id,course);
			}
		}*/
		StudentDaoImpl.registerCourseImpl(id,course);

	}
	@RequestMapping(value = "/student/addCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.PUT)
	public ResponseEntity<Map<Integer, List<String>>> addCourse(@PathVariable String Course, @PathVariable int id) {
		List<String> courseList = new ArrayList<String>();
		if(studentHandlerImpl.getAddedCourses().get(id) != null) {
		courseList = studentHandlerImpl.getAddedCourses().get(id);
	}
	
	List<Course> courseCatalog = adminDaoImpl.getAllCourse();	
	for(Course c : courseCatalog) {
		if(c.getCourseName().equalsIgnoreCase(Course)) {
			if(!courseList.contains(Course))
				courseList.add(Course);
			else
				throw new CourseAlreadySelectedException();
		}
//		else 
//		{
//			throw new WrongCourseSelectionException();
//		}
			
	}	
	studentHandlerImpl.getAddedCourses().put(id, courseList);
	return new ResponseEntity<Map<Integer, List<String>>>(studentHandlerImpl.getAddedCourses(),HttpStatus.OK);
	
	}
	

	@RequestMapping(value = "/student/dropCourse/{id}/{Course}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.DELETE)
	public ResponseEntity<Map<Integer, List<String>>> dropCourse(@PathVariable String Course, @PathVariable int id) {
		List<String> courseList = studentHandlerImpl.getAddedCourses().get(id);
		if(courseList.contains(Course))
			courseList.remove(Course);
		else
			throw new CourseNotAddedException();
		studentHandlerImpl.getAddedCourses().put(id, courseList);
		//return studentHandlerImpl.getAddedCourses();
		return new ResponseEntity<Map<Integer, List<String>>>(studentHandlerImpl.getAddedCourses(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/student/addStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.POST)
	public void addStudent(@RequestBody Student student) {
		 StudentDaoImpl.addStudent(student);
		
	}
	
	@RequestMapping(value = "/student/getStudent", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudent() {
		return new ResponseEntity<List<Student>>(studentHandlerImpl.getStudentList(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/student/viewGrade", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public ResponseEntity<List<Grades>> listGradeForStudent() {
			List<Grades> gradeLists = gradesDAOImpl.viewGrades();
			if(gradeLists.isEmpty())
				throw new GradeNotFoundException();
			return new ResponseEntity<List<Grades>>(gradeLists,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/student/viewGradeBasedOnId/{studentId}", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
	public Grades listGradeBasedonId(@PathVariable int studentId) {
		List<Grades> listTheGrades = gradesDAOImpl.viewGradeOnId(studentId);
		System.out.println(listTheGrades);
		for(Grades grade : listTheGrades) {
			if(grade.getStudentId() == studentId) {
				grade.getGrade();
				return grade;
			}
			
		}
		
		return new Grades();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/payment/{studentId}")
	public String payment(@PathVariable int studentId) {
		return paymentHandlerImpl.makePayment(studentId);
	}
}
