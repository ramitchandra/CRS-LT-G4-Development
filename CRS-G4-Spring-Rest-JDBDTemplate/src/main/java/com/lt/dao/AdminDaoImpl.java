package com.lt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.bean.Course;
import com.lt.config.JDBCConfiguration;
import com.lt.mapper.CourseMapper;

@Repository
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	JDBCConfiguration jdbcConfiguration;

	@Override
	@Transactional
	public List<Course> getAllCourse() {

		String SQL = "select * from course";
		List <Course> courseList = jdbcConfiguration.jdbcTemplate().query(SQL, 
				new CourseMapper());

		return courseList;
	}
}
