package com.lt.dao;

import java.util.List;

import com.lt.bean.Grades;
import com.lt.bean.Student;

public interface ProfessorDao {
	
	public  List<Student> listStudent();
	public void assignGrade(Grades grade);
}
