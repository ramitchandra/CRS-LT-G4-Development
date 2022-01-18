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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	private static final Logger log = LoggerFactory.getLogger(AdminService.class);
	
	
	
	@Transactional
	public List<Course> getAllCourse() {
		log.info("Inside getAllCourse method");
		List <Course> courseList = (List<Course>)adminDao.findAll();
		return courseList;
	}

	@Transactional
	public void addCourse(Course course) {
		log.info("Inside addCourse method");
		adminDao.save(course);
	}

	@Transactional
	public void deleteCourse(int id, String name) {
		log.info("Inside deleteCourse method");
		CourseId courseId = new CourseId();
		courseId.setCourseId(id);
		courseId.setCourseName(name);
		adminDao.deleteById(courseId);		
	}
	

	@Transactional
	public List<Professor> getProfessorList() {
		log.info("Inside getProfessorList method");
		List <Professor> professorList = (List<Professor>)professorDao.findAll();
		return professorList;
	}

	@Transactional
	public void addProfessor(Professor professor) {
		log.info("Inside addProfessor method");
		professorDao.save(professor);
	}

	@Transactional
	public void deleteProfessor(int id) {
		log.info("Inside deleteProfessor method");
		professorDao.deleteById(id);	
	}

	@Transactional
	public void approveStudent(int id) {
		log.info("Inside approveStudent method");
		adminDao.approveById(id);
		
	}
}
