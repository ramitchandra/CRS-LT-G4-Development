package com.lt.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.lt.bean.Course;

public interface AdminDao {

	public List<Course> getAllCourse();
	 public void setJdbcTemplate(JdbcTemplate jdbcTemplateObject);
}
