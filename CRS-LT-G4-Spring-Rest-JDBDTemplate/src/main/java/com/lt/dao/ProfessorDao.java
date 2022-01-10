package com.lt.dao;

import java.util.List;

import com.lt.bean.Grades;
import com.lt.bean.Student;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
public interface ProfessorDao {
	
	/**
	 * @return
	 *  This method return list of students who are not assigned grades
	 */
	public  List<Student> listStudent();
	/**
	 * @param grade
	 * In this method professor assigns grades
	 */
	public void assignGrade(Grades grade);
}
