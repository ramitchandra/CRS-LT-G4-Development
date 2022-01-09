package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.Grades;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 *
 */
public class GradeMapper implements RowMapper<Grades> {

	/**
	 *@param rs
	 *@param rowNum
	 *@return
	 *This is used to map grades to the output.
	 */
	@Override
	public Grades mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grades grades = new Grades();
		grades.setGrade(rs.getString(3));
		grades.setStudentId(rs.getInt(2));
		return grades;
	}

}
