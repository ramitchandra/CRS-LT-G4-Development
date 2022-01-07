package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<Map<String,String>> {

	@Override
	public Map<String,String> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String,String> list = new HashMap<>();
		list.put("Student Id",String.valueOf(rs.getInt(1)));
		list.put("Student Name", rs.getString(2));
		list.put("Is Approved",String.valueOf(rs.getBoolean(5)));
		return list;

	}

}
