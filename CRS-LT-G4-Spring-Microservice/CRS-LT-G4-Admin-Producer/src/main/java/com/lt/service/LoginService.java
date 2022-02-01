/**
 * 
 */
package com.lt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.LoginDao;
import com.lt.entity.Login;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 *
 */
@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	/**
	 * @param login
	 * @return
	 * To save details of logged in user in login.
	 */
	public void login(Login login) {
		loginDao.save(login);
	}
	
	/**
	 * @return
	 * To delete the looged in user details from login.
	 */
	public void logout() {
		loginDao.deleteAll();
	}
}
