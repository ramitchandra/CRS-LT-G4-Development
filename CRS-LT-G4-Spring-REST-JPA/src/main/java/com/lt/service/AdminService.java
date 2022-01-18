/**
 * 
 */
package com.lt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.lt.crs.constants.SqlConstants;
import com.lt.dao.AdminDao;
import com.lt.dao.ProfessorDao;
import com.lt.entity.Course;
import com.lt.entity.CourseId;
import com.lt.entity.Professor;

/**
 * @author user112
 *
 */
@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	ProfessorDao professorDao;
	
	
	
	@Transactional
	public List<Course> getAllCourse() {
		
		List <Course> courseList = (List<Course>)adminDao.findAll();
		return courseList;
	}

	@Transactional
	public void addCourse(Course course) {
		adminDao.save(course);
	}

	@Transactional
	public void deleteCourse(int id, String name) {
		CourseId courseId = new CourseId();
		courseId.setCourseId(id);
		courseId.setCourseName(name);
		adminDao.deleteById(courseId);		
	}
	

	@Transactional
	public List<Professor> getProfessorList() {
		List <Professor> professorList = (List<Professor>)professorDao.findAll();
		return professorList;
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
	public void approveStudent(int id) {
		adminDao.approveById(id);
		
	}
}
