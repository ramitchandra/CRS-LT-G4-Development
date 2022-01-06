/**
 * 
 */
package com.lt.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lt.bean.Course;
import com.lt.bean.Student;

/**
 * @author Admin
 *
 */
@Component
public class StudentDaoImpl implements StudentDao {

	 private JdbcTemplate jdbcTemplate;
	  
	  public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
	    this.jdbcTemplate = jdbcTemplate;
	  }

	@Override
	public void registerCourseImpl(int id,List course) {
		// TODO Auto-generated method stub
		 String sql = "insert into courseAdded value (?,?)";
		 jdbcTemplate.queryForObject(sql,String.class,id,course);
		
	}

}