package com.lt.crs.validation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lt.bean.LoginDetails;
import com.lt.config.JDBCConfiguration;
import com.lt.mapper.UserMapper;

@Repository
public class LoginValidation {
	
	@Autowired
	JDBCConfiguration jdbcConfiguration;
	
	public int loginDetails(String userName, String password) {
		String loginQuery = "select * from user where userName = ? and userPassword = ?";
		List<Map<String,String>> userDetails =  jdbcConfiguration.jdbcTemplate().query(loginQuery, new UserMapper(), userName, password);
		if(userDetails.isEmpty())
			return -1;
		if(!userDetails.isEmpty() && userDetails.get(0).get("Role").equalsIgnoreCase("Student") && userDetails.get(0).get("IsApproved").equalsIgnoreCase("false"))
			return -2;
		LoginDetails.userName = userDetails.get(0).get("UserName");
		LoginDetails.userRole = userDetails.get(0).get("Role");
		return 1;
		
	}
	
}
