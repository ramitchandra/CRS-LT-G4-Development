/**
 * 
 */
package com.lt.crs.business;

import java.util.List;
import java.util.Map;

import com.lt.bean.Student;

/**
 * @author Sai
 */
public interface StudentHandler {

	/**
	 * list of students
	 * 
	 * @return
	 */
	public List<Student> getStudentList();

	/**
	 * create a new student
	 * 
	 * @return
	 */
	public void createDummyStudent();

	/**
	 * add student
	 * 
	 * @param student object
	 * @return
	 */
	public Student addStudent(Student student);

	/**
	 * list of added courses
	 * 
	 * @return
	 */
	public Map<Integer, List<String>> getAddedCourses();

	/**
	 * student can make payment for courses.
	 * 
	 * @return
	 */
	public void payment();
}
