package com.lt.dao;

import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Professor;

public interface AdminDao {

	public List<Course> getAllCourse();
	public void addCourse(Course course);
	public void deleteCourse(int id);
	
	public List<Professor> getProfessorList();
	public void addProfessor(Professor professor);
	public void deleteProfessor(int id);

}
