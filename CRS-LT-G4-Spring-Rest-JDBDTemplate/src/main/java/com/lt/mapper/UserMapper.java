package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.lt.crs.constants.EnumRole;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
public class UserMapper implements RowMapper<Map<String,String>> {
	
	/**
	 * @param rs 
	 * @param rowNum
	 * @return
	 * This is used to map user to the output.
	 */
	@Override
	public Map<String,String> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String,String> list = new HashMap<>();
		list.put("UserId",String.valueOf(rs.getInt(1)));
		list.put("UserName", rs.getString(2));
		if(rs.getInt(4)==EnumRole.Admin.getRoleId())
			list.put(EnumRole.Role.toString(), EnumRole.Admin.toString());
		else if(rs.getInt(4)==EnumRole.Professor.getRoleId())
			list.put(EnumRole.Role.toString(), EnumRole.Professor.toString());
		else if(rs.getInt(4)==EnumRole.Student.getRoleId())
			list.put(EnumRole.Role.toString(), EnumRole.Student.toString());
		list.put("IsApproved",String.valueOf(rs.getBoolean(5)));
		return list;

	}

}
