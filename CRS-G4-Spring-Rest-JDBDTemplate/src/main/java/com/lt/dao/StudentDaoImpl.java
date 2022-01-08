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
import com.lt.mapper.UserMapper;


/**
 * @author Admin
 *
 */
@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	JDBCConfiguration jdbcConfiguration;
	  
	@Override
	public void registerCourseImpl(int studentId,List<String> Course) {
		// TODO Auto-generated method stub
		String sql = "select studentName from student where studentId ="+studentId;
		String studentName = jdbcConfiguration.jdbcTemplate().queryForObject(sql, String.class);
		for(String c: Course) {
			String sql2 = "select courseId from Course where courseName ='"+c+"'";
			int courseId = jdbcConfiguration.jdbcTemplate().queryForObject(sql2, Integer.class);
			String sql3 = "insert into enrolledcourses value (?,?,?,?)";
			jdbcConfiguration.jdbcTemplate().update(sql3,studentId,studentName,courseId,c);
		}
		 
		
	}
	
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		String roleSQL = "select id from role where role = 'Student'";				
		int roleid  = jdbcConfiguration.jdbcTemplate().queryForObject(roleSQL, Integer.class);
		String SQL= "insert into student values(?,?,?,?,?)";
		jdbcConfiguration.jdbcTemplate().update( SQL, student.getStudentId(),student.getStudentName(),student.getStudentEmail(),student.getStudentPassword(),student.getStudentUsername());
		String userSQL= "insert into user values(?,?,?,?,?)";
		jdbcConfiguration.jdbcTemplate().update( userSQL, student.getStudentId(),student.getStudentName(),student.getStudentPassword(),roleSQL,false);
		
	}
	
	public List<Map<String,String>> getStudents() {
		String getStudentQuery = "select * from user where roleId = 103 and isApproved = 0";
		return jdbcConfiguration.jdbcTemplate().query(getStudentQuery, new UserMapper());
	}

}