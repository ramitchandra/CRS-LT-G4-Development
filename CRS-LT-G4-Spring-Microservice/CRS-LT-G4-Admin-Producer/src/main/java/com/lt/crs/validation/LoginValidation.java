package com.lt.crs.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lt.crs.constants.EnumRole;
import com.lt.dao.UserDao;
import com.lt.entity.Login;
import com.lt.entity.User;
import com.lt.service.LoginService;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@Repository
public class LoginValidation {
	
	/**
	 * This is used to autowire  AdminDao bean
	 */
	@Autowired
	UserDao userDao;
	
	@Autowired
	LoginService loginService;
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 * This is used to authenticate user credentials.
	 */
	public int loginDetails(String userName, String password) {
		
		List<User> userDetails =  userDao.loginValidation(userName, password);
		
		if(userDetails.isEmpty())
			return -1;
		else if(!userDetails.isEmpty() && userDetails.get(0).getRoleId() == EnumRole.Student.getRoleId() && userDetails.get(0).isApproved() == false)
			return -2;
		else {
			Login login = new Login();
			login.setUserName(userName);
			login.setUserPassword(password);
			login.setRoleId(userDetails.get(0).getRoleId());
			loginService.login(login);
			return 1;
		}
		
	}
	
}
