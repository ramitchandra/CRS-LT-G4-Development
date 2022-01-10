/**
 * 
 */
package com.lt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.config.JDBCConfiguration;
import com.lt.crs.constants.SqlConstants;
import com.lt.mapper.UserMapper;


/**
 * @author Admin
 *
 */
@Component
public class StudentDaoImpl implements StudentDao {

	/**
	 * This is used to autowire  JDBCConfiguration bean
	 */
	@Autowired
	JDBCConfiguration jdbcConfiguration;
	  
	@Override
	public void registerCourseImpl(int studentId,List<String> Course) {
		// TODO Auto-generated method stub
		String sql = SqlConstants.selectStudentName+studentId;
		String studentName = jdbcConfiguration.jdbcTemplate().queryForObject(sql, String.class);
		for(String c: Course) {
			String sql2 = SqlConstants.selectCourseId+c+"'";
			int courseId = jdbcConfiguration.jdbcTemplate().queryForObject(sql2, Integer.class);
			String sql3 = SqlConstants.insertEnrolledcourses;
			jdbcConfiguration.jdbcTemplate().update(sql3,studentId,studentName,courseId,c);
		}
		 
		
	}
	
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		String roleSQL = SqlConstants.selectRoleId;				
		int roleid  = jdbcConfiguration.jdbcTemplate().queryForObject(roleSQL, Integer.class);
		String SQL= SqlConstants.insertStudent;
		jdbcConfiguration.jdbcTemplate().update( SQL, student.getStudentId(),student.getStudentName(),student.getStudentEmail(),student.getStudentPassword(),student.getStudentUsername());
		String userSQL= SqlConstants.insertUser;
		jdbcConfiguration.jdbcTemplate().update( userSQL, student.getStudentId(),student.getStudentName(),student.getStudentPassword(),roleid,false);
		
	}
	
	public List<Map<String,String>> getStudents() {
		String getStudentQuery = SqlConstants.selectStudent;
		return jdbcConfiguration.jdbcTemplate().query(getStudentQuery, new UserMapper());
	}

}