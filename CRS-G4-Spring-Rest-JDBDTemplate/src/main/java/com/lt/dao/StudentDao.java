package com.lt.dao;

import java.util.List;
import java.util.Map;

import com.lt.bean.Student;

public interface StudentDao  {
	
	public void registerCourseImpl(int id, List<String> course);
	
	public void addStudent(Student student);
	
	public List<Map<String,String>> getStudents();
	
}
