package com.lt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.GradesDao;
import com.lt.entity.Grades;

@Service
public class GradeService {
	
	@Autowired(required=true)
	private GradesDao gradesDao;
	
	public List<Grades> viewGrades() {
		//List<Grades> listTheGrades = new ArrayList<>();
		return (List<Grades>) gradesDao.findAll();
		//return listTheGrades;
		
	}
	
	/*@Transactional
	public List<Grades> viewGradesBasedOnId(int studentId) {
	//	Grades gradesObject = new Grades();
	//	gradesObject.setStudentId(studentId);
		return (List<Grades>) gradesDao.findAllById(studentId);
	}	*/
	
	

}
