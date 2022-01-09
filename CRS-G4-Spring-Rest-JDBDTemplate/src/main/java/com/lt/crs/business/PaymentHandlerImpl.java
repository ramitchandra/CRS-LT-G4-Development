package com.lt.crs.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.Course;
import com.lt.bean.EnrolledCourse;
import com.lt.crs.exception.EnrollCoursesNotFoundException;
import com.lt.crs.exception.PaymentDeclinedException;
import com.lt.dao.PaymentDao;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 * 
 *         Implementation of Payment Operations
 */

@Service
public class PaymentHandlerImpl implements PaymentHandler {

	@Autowired
	PaymentDao paymentDaoImpl;

	/*
	 * Method to make Payment
	 * 
	 * @param studendId
	 * 
	 * @return finalCost
	 */
	@Override
	public String makePayment(int studentId) {
		int finalCost = 0;

		// Get studentEnrolled courses
		List<EnrolledCourse> enrolledCourses = paymentDaoImpl.getEnrolledCourses(studentId);
		
		//if student not enrolled for any course
		//throw exception
		if(enrolledCourses.isEmpty()) {
			throw new EnrollCoursesNotFoundException();
		}

		// Get student Courses
		List<Integer> courseIdList = new ArrayList<>();
		StringBuilder courseIds = new StringBuilder();

		for (EnrolledCourse enrolledCourse : enrolledCourses) {
			courseIds.append("?,");
			courseIdList.add(enrolledCourse.getCourseId());
		}
		courseIds.replace(courseIds.length() - 1, courseIds.length(), "");

		// Call course to get paymentInfo
		List<Course> courses = paymentDaoImpl.getCourses(courseIdList, courseIds.toString());

		// Get final cost
		for (Course course : courses) {
			int courseFees = course.getOfflieFees();
			finalCost += courseFees;
		}
		
		// Making payment to the student enrolled courses
		try {
			int paymentStatus = paymentDaoImpl.makePayment(studentId, finalCost,
					enrolledCourses.get(0).getStudentName());
			if (paymentStatus >= 1) {
				return "Payment is successful for the studentId \"" + studentId + "\" :"+finalCost;
			} else {
				throw new PaymentDeclinedException();
			}
		} catch (Exception e) {
			throw new PaymentDeclinedException();
		}
	}

}