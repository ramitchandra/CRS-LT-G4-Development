/**
 * 
 */
package com.lt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.config.JDBCConfiguration;

/**
 * @author Admin
 *
 */
@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	JDBCConfiguration jdbcConfiguration;
	  
	@Override
	public void registerCourseImpl(int id,List course) {
		// TODO Auto-generated method stub
		 String sql = "insert into courseAdded value (?,?)";
		 jdbcConfiguration.jdbcTemplate().update(sql,id,course);
		
	}

}