/**
 * 
 */
package com.lt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


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
	
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
//		String roleSQL = "select id from role where role = 'Student'";				
//		int roleid  = jdbcConfiguration.jdbcTemplate().query(roleSQL, null);
		String SQL= "insert into student values(?,?,?,?,?)";
		jdbcConfiguration.jdbcTemplate().update( SQL, student.getStudentId(),student.getStudentName(),student.getStudentEmail(),student.getStudentPassword(),student.getStudentUsername());
		String userSQL= "insert into user values(?,?,?,?,?)";
		jdbcConfiguration.jdbcTemplate().update( userSQL, student.getStudentId(),student.getStudentName(),student.getStudentPassword(),103,false);
		
	}

}