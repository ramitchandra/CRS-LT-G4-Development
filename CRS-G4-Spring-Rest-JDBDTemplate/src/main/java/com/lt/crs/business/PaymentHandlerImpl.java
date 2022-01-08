package com.lt.crs.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.CardDetails;
import com.lt.bean.Course;
import com.lt.bean.EnrolledCourse;
import com.lt.bean.Payment;
import com.lt.bean.Student;
import com.lt.dao.PaymentDao;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 * 
 *         Implementation of Payment Operations
 */

@Service
public class PaymentHandlerImpl implements PaymentHandler {

	@Autowired
	StudentHandler studentHandlerImpl;

	@Autowired
	CourseHandler courseHandlerImpl;

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
		List<Integer> courseIdList = new ArrayList<>();

		// Get student Courses
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

		try {
			int paymentStatus = paymentDaoImpl.makePayment(studentId, finalCost,
					enrolledCourses.get(0).getStudentName());
			if (paymentStatus >= 1) {
				return "Payment is successful for the student:" + finalCost;
			} else {
				return "Payment is declined for the student:" + finalCost;
			}
		} catch (Exception e) {
			return "Payment is declined for the student:" + finalCost;
		}

//		List<String> courseList = studentHandlerImpl.getAddedCourses().get(studentId);
//		for (Course c : courseHandlerImpl.getCourseList()) {
//			if (courseList.contains(c.getOnlineFees())) {
//				finalCost += c.getOnlineFees();
//				System.out.println(finalCost);
//			}
//		}

	}

}