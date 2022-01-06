/**
 * 
 */
package com.lt.crs.business;

import java.util.List;
import java.util.Map;

import com.lt.bean.Student;

/**
 * @author user112
 *
 */
public interface StudentHandler {
	public List<Student> getStudentList();
	public void createDummyStudent();
	public Student addStudent(Student student);
	public void viewGrade();
	public Map<Integer, List<String>> getAddedCourses();
	public void payment();
}
