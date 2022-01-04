/**
 * 
 */
package com.lt.crs.business;

import java.util.List;

import com.lt.crs.bean.Student;

/**
 * @author user112
 *
 */
public interface StudentHandler {
	public List<Student> getStudentList();
	public void createDummyStudent();
}
