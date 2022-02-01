package com.lt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lt.dao.CourseDao;
import com.lt.dao.GradesDao;
import com.lt.dao.LoginDao;
import com.lt.dao.ProfessorDao;
import com.lt.dao.StudentDao;
import com.lt.dao.UserDao;
import com.lt.entity.Course;
import com.lt.entity.CourseId;
import com.lt.entity.Grades;
import com.lt.entity.Login;
import com.lt.entity.Professor;
import com.lt.entity.Student;
import com.lt.entity.User;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 *
 */
@Service
public class AdminService {
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	ProfessorDao professorDao;
	
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	GradesDao gradesDao;

	/**
	 * @return
	 * To Fetch All the Students.
	 */
	@Transactional
	public List<Student> getAllStudentList() {
		return (List<Student>) studentDao.findAll();
	}
	
	/**
	 * @return
	 * To Fetch unapproved students.
	 */
	@Transactional
	public List<Map<String,Object>> getStudentList() {
		List<Map<String,Object>> unApprovedStudentList= new ArrayList<>();
		List<User> userList= (List<User>) userDao.findUnapproved();
		for(User u: userList){
			Map<String,Object> studentMap= new HashMap<>();
			studentMap.put("studentId",u.getUserId());
			studentMap.put("studentName",u.getUserName());
			unApprovedStudentList.add(studentMap);
		}
		return  unApprovedStudentList;
		
	}
	
	/**
	 * @param id
	 * @return
	 * To Approve the student by taking id as input.
	 */
	@Transactional
	public void approveStudent(int id) {
		userDao.approveById(id);		
	}
	
	/**
	 * @param course
	 * @return
	 * To Add new course to the course catalogue.
	 */
	@Transactional
	public void addCourse(Course course) {
		courseDao.save(course);
	}
	
	/**
	 * @param id
	 * @param name
	 * @return
	 * To delete the course from course catalogue by taking course id and course name.
	 */
	@Transactional
	public void deleteCourse(int id, String name) {
		CourseId courseId = new CourseId();
		courseId.setCourseId(id);
		courseId.setCourseName(name);
		courseDao.deleteById(courseId);		
	}
	
	/**
	 * @param professor
	 * @return
	 * To add new professor.
	 */
	@Transactional
	public void addProfessor(Professor professor) {
		professorDao.save(professor);
	}
	
	/**
	 * @param id
	 * @return
	 * This is used to delete professor by taking prof id as input.
	 */
	@Transactional
	public void deleteProfessor(int id) {
		professorDao.deleteById(id);	
	}
	
	/**
	 * @return
	 * To fetch details of currently logged in user.
	 */
	@Transactional
	public List<Login> getLoggedInUser() {
		return (List<Login>) loginDao.findAll();	
	}
	
	/**
	 * @return
	 * To generate reportcard of students.
	 */
	@Transactional
	public List<Grades> gererateReportCard() {
		return (List<Grades>) gradesDao.findUnapprooved();	
	}
	
	/**
	 * @param id
	 * This is used to make reportcard available for students.
	 */
	@Transactional
	public void validateReportCard(int id) {
		gradesDao.approveById(id);	
	}

}
