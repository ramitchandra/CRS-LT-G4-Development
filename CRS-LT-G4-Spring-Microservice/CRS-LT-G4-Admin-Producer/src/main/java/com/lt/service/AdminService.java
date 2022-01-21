package com.lt.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lt.dao.AdminDao;
import com.lt.dao.CourseDao;
import com.lt.dao.ProfessorDao;
import com.lt.dao.StudentDao;
import com.lt.dao.UserDao;
import com.lt.entity.Course;
import com.lt.entity.CourseId;
import com.lt.entity.Professor;
import com.lt.entity.Student;
import com.lt.entity.User;

@Service
public class AdminService {
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	UserDao userDao;
	
//	@Autowired
//	AdminDao adminDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	ProfessorDao professorDao;

	@Transactional
	public List<Student> getAllStudentList() {
		return (List<Student>) studentDao.findAll();
	}
	
	@Transactional
	public List<Map<String,String>> getStudentList() {
		List<Map<String,String>> unApprovedStudentList= new ArrayList<>();
		List<User> userList= (List<User>) userDao.findUnapproved();
		for(User u: userList){
			unApprovedStudentList.add(Collections.singletonMap(("StudentId "+ u.getUserId()),("StudentUserName "+ u.getUserName())));
		}
		return  unApprovedStudentList;
		
	}
	
	@Transactional
	public void approveStudent(int id) {
		userDao.approveById(id);		
	}
	
	@Transactional
	public void addCourse(Course course) {
		courseDao.save(course);
	}
	
	@Transactional
	public void deleteCourse(int id, String name) {
		CourseId courseId = new CourseId();
		courseId.setCourseId(id);
		courseId.setCourseName(name);
		courseDao.deleteById(courseId);		
	}
	
	@Transactional
	public void addProfessor(Professor professor) {
		professorDao.save(professor);
	}
	
	@Transactional
	public void deleteProfessor(int id) {
		professorDao.deleteById(id);	
	}

}
