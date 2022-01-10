package com.lt.dao;

import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Professor;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
public interface AdminDao {

	/**
	 * @return
	 * This is used to fetch list of all courses.
	 */
	public List<Course> getAllCourse();
	/**
	 * @param course
	 * @return
	 * This is used to add course.
	 */
	public int addCourse(Course course);
	/**
	 * @param id
	 * @return
	 * This is used to delete course on basis of id.
	 */
	public int deleteCourse(int id);
	/**
	 * @return
	 * This is used to fetch list of all professors.
	 */
	public List<Professor> getProfessorList();
	/**
	 * @param professor
	 * This is used to add professor.
	 */
	public void addProfessor(Professor professor);
	/**
	 * @param id
	 * @return
	 * This is used to delete professor on basis of id.
	 */
	public int deleteProfessor(int id);
	/**
	 * @param id
	 * @return
	 * This is used to approve student on basis of id.
	 */
	public int approveStudent(int id);

}
