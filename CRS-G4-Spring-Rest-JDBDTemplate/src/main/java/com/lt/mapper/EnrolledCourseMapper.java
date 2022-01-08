package com.lt.mapper;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.EnrolledCourse;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */

public class EnrolledCourseMapper implements RowMapper<EnrolledCourse> {

	/**
	 * @param rs
	 * @param rowNum
	 * @return This is used to map EnrolledCourse to the output.
	 */
	@Override
	public EnrolledCourse mapRow(ResultSet rs, int rowNum) throws SQLException {
		EnrolledCourse enrolledCourse = new EnrolledCourse();
		enrolledCourse.setStudentId(rs.getInt(1));
		enrolledCourse.setStudentName(rs.getString(2));
		enrolledCourse.setCourseId(rs.getInt(3));
		enrolledCourse.setCourseName(rs.getString(4));
		return enrolledCourse;
	}

}
