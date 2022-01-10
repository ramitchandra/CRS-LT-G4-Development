package com.lt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lt.bean.Course;
import com.lt.bean.EnrolledCourse;
import com.lt.config.JDBCConfiguration;
import com.lt.crs.constants.SqlConstants;
import com.lt.mapper.CourseMapper;
import com.lt.mapper.EnrolledCourseMapper;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 *         Implementation of PaymentDao Operations
 */

@Component
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Override
	public List<EnrolledCourse> getEnrolledCourses(int studentId) {
		return jdbcConfiguration.jdbcTemplate().query(SqlConstants.SELECT_STUDENT_COURSES + studentId,
				new EnrolledCourseMapper());
	}

	@SuppressWarnings("deprecation")
	@Override
	public List<Course> getCourses(List<Integer> courseIdList, String courseIds) {

		return jdbcConfiguration.jdbcTemplate().query(String.format(SqlConstants.SELECT_COURSE_AMT, courseIds),
				courseIdList.toArray(), new CourseMapper());
	}

	/*
	 * Method to make payment for the enrolled courses
	 * 
	 * @param studentId
	 */
	@Override
	@Transactional
	public int makePayment(int studentId, int finalCost, String studentName) {
		int paymentStatus = jdbcConfiguration.jdbcTemplate().update(SqlConstants.INSERT_INTO_PAYMENT, "cash", finalCost,
				studentName);
		return paymentStatus;
	}

}
