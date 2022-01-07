package com.lt.dao;

import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Professor;

public interface AdminDao {

	public List<Course> getAllCourse();
	public void addCourse(Course course);
	public int deleteCourse(int id);
	
	public List<Professor> getProfessorList();
	public void addProfessor(Professor professor);
	public int deleteProfessor(int id);
	public int approveStudent(int id);

}
