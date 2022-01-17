package com.lt.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.GradesDao;
import com.lt.dao.ProfessorDao;
import com.lt.dao.StudentDao;
import com.lt.entity.Grades;
import com.lt.entity.Student;

@Service
public class ProfessorService {
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	ProfessorDao professorDao;
	
	@Autowired
	GradesDao gradesDao;
	
	
	@Transactional
	public List<Student> listStudent() {
		List<Student> studentList = (List<Student>) studentDao.findAll();
		return studentList;		
	}
	
	@Transactional
	public void addGrades(Grades grades) {
		gradesDao.save(grades);
	}

}
