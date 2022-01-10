/**
 * 
 */
package com.lt.dao;

import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.EnrolledCourse;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 *         Interface for PaymentDao Operations
 */
public interface PaymentDao {

	public List<EnrolledCourse> getEnrolledCourses(int studentId);

	/**
	 * Method to make Payment for enrolled courses
	 * 
	 * @param studentId
	 * @param studentName
	 * @param finalCost
	 */
	public int makePayment(int studentId, int finalCost, String studentName);

	public List<Course> getCourses(List<Integer> courseIdList, String courseIds);

}
