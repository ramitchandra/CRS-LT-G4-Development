package com.lt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lt.bean.Course;
import com.lt.bean.Grades;
import com.lt.bean.Student;
import com.lt.config.JDBCConfiguration;
import com.lt.mapper.CourseMapper;
import com.lt.mapper.StudentMapper;

@Component
public class ProfessorDaoImpl implements ProfessorDao {
	
	@Autowired
	JDBCConfiguration jdbcConfiguration;
	
	@Override
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		String SQL = "Select * from student where studentId in (select distinct studentId from EnrolledCourses where studentId not in(select distinct studentId from grades))";
		List <Student> studentList = jdbcConfiguration.jdbcTemplate().query(SQL, 
				new StudentMapper());
		return studentList;
		
	}

	@Override
	public void assignGrade(Grades grade) {
		// TODO Auto-generated method stub
		String sql = "insert into grades value (?,?)";
		jdbcConfiguration.jdbcTemplate().update(sql,grade.getStudentId(),grade.getGrade());
		
		
	}

}
