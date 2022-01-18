package com.lt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.GradesDao;
import com.lt.dao.ProfessorDao;
import com.lt.dao.StudentDao;
import com.lt.entity.Grades;
import com.lt.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class ProfessorService {
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	ProfessorDao professorDao;
	
	@Autowired
	GradesDao gradesDao;
	
	private static final Logger log = LoggerFactory.getLogger(AdminService.class);
	
	
	/**
	 * @return This method is to call the DAO Layer to fetch the List of students from DB
	 */
	@Transactional
	public List<Student> listStudent() {
		log.info("Inside listStudent method");
		List<Student> studentList = (List<Student>) studentDao.findAll();
		return studentList;		
	}
	
	/**
	 * @param grades
	 * This method is to call the DAO Layer to add the Grades in the DB
	 */
	@Transactional
	public void addGrades(Grades grades) {
		log.info("Inside addGrades method");
		gradesDao.save(grades);
	}

}
