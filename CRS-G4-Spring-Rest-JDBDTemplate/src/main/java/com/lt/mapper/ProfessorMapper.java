package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.Professor;

public class ProfessorMapper implements RowMapper<Professor> {

	@Override
	public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Professor professor = new Professor();
		professor.setProfessorId(rs.getInt(1));
		professor.setProfessorName(rs.getString(2));
		professor.setProfessorPass(rs.getString(3));
		return professor;
	}

}
