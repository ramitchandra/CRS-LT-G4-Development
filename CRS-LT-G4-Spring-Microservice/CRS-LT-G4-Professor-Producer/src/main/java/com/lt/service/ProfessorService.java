package com.lt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.GradesDao;
import com.lt.dao.StudentDao;
import com.lt.entity.Grades;
import com.lt.entity.Student;

@Service
public class ProfessorService {

	@Autowired
	StudentDao studentDao;
	
	@Autowired
	GradesDao gradesDao;

	/**
	 * @return This method is to call the DAO Layer to fetch the List of students from DB
	 */
	public List<Student> listStudent() {
		List<Student> studentList = (List<Student>) studentDao.findAll();
		return studentList;		
	}
	
	/**
	 * @param grades
	 * This method is to call the DAO Layer to add the Grades in the DB
	 */
	public void addGrades(Grades grades) {
		Grades assignGrades = gradesDao.save(grades);
	}

}
