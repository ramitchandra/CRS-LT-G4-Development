package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.Student;

/**
 * @author  Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */

public class StudentMapper implements RowMapper<Student>{

	/**
	 *@param rs
	 *@param rowNum
	 *@return
	 * This is used to map student to the output
	 */
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setStudentId(rs.getInt(1));
		student.setStudentName(rs.getString(2));
		student.setStudentEmail(rs.getString(3));
		student.setStudentPassword(rs.getString(4));
		student.setStudentUsername(rs.getString(5));
		student.setApproved(true);
		return student;
	}

}
