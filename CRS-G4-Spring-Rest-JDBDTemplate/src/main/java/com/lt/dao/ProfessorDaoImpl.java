package com.lt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lt.bean.Course;
import com.lt.bean.Grades;
import com.lt.bean.Student;
import com.lt.config.JDBCConfiguration;
import com.lt.crs.constants.SqlConstants;
import com.lt.mapper.CourseMapper;
import com.lt.mapper.StudentMapper;
import com.lt.crs.exception.AlreadyGradeAssignedException;

@Repository
public class ProfessorDaoImpl implements ProfessorDao {
	
	@Autowired
	JDBCConfiguration jdbcConfiguration;
	
	@Override
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		String SQL = SqlConstants.selectStudentDetails;
		List <Student> studentList = jdbcConfiguration.jdbcTemplate().query(SQL, 
				new StudentMapper());
		return studentList;
		
	}

	@Override
	public void assignGrade(Grades grade) {
		// TODO Auto-generated method stub
		String sql = SqlConstants.insertGrades;
		String SQL = SqlConstants.SelectStudentId;
		List<Integer> studentIds = jdbcConfiguration.jdbcTemplate().queryForList(SQL,Integer.class);
		if(studentIds.contains(grade.getStudentId())) {
			throw new AlreadyGradeAssignedException();
		}
		jdbcConfiguration.jdbcTemplate().update(sql,grade.getStudentId(),grade.getGrade());
		
		
	}

}
