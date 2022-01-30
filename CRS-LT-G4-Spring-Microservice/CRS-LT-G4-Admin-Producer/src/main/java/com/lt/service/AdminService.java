package com.lt.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lt.dao.CourseDao;
import com.lt.dao.LoginDao;
import com.lt.dao.ProfessorDao;
import com.lt.dao.StudentDao;
import com.lt.dao.UserDao;
import com.lt.entity.Course;
import com.lt.entity.CourseId;
import com.lt.entity.Login;
import com.lt.entity.Professor;
import com.lt.entity.Student;
import com.lt.entity.User;

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

	@Transactional
	public List<Student> getAllStudentList() {
		return (List<Student>) studentDao.findAll();
	}
	
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
	
	@Transactional
	public List<Login> getLoggedInUser() {
		return (List<Login>) loginDao.findAll();	
	}

}
