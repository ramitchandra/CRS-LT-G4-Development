package com.lt.dao;

import java.util.List;
import java.util.Map;

import com.lt.bean.Student;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
public interface StudentDao  {
	
	/**
	 * @param id
	 * @param course
	 * Register for course implementation
	 */
	public void registerCourseImpl(int id, List<String> course);
	
	/**
	 * @param student
	 * This method is for student self registration
	 */
	public void addStudent(Student student);
	
	/**
	 * @return
	 * Returns students details 
	 */
	public List<Map<String,String>> getStudents();
	
}
