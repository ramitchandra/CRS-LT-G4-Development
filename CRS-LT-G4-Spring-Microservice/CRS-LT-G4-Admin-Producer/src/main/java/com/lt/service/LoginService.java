/**
 * 
 */
package com.lt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.LoginDao;
import com.lt.entity.Login;

/**
 * @author user113
 *
 */
@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	public void login(Login login) {
		loginDao.save(login);
	}
	
	public void logout() {
		loginDao.deleteAll();
	}
}
