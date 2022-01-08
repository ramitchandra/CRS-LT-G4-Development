package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.Course;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
public class CourseMapper implements RowMapper<Course> {

	/**
	 * @param rs 
	 * @param rowNum
	 * @return
	 * This is used to map course to the output.
	 */
	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setCourseId(rs.getInt(1));
		course.setCourseName(rs.getString(2));
		course.setOfflieFees(rs.getInt(4));
		course.setOnlineFees(rs.getInt(5));
		course.setCourseAvailable(rs.getBoolean(3));
		return course;

	}

}
