package com.lt.dao;

import java.util.List;

import com.lt.bean.Student;

public interface StudentDao  {
	
	public void registerCourseImpl(int id, List course);
	
	public void addStudent(Student student);
	
}
