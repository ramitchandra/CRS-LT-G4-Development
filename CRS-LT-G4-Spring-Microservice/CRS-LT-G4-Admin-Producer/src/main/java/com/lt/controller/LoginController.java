package com.lt.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.constants.StringConstants;
import com.lt.crs.exception.ApprovalPendingException;
import com.lt.crs.exception.InvalidUserException;
import com.lt.crs.validation.LoginValidation;
import com.lt.entity.Login;
import com.lt.service.LoginService;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@RestController
@CrossOrigin
public class LoginController {
	
	/**
	 * This is used to autowire LoginValidation bean
	 */
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	LoginValidation loginValidation;
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 * This is used for login functionality.
	 */
	@RequestMapping(value = "/login", produces = "text/plain", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody Map<String, Object> inputMap) {
		log.info("Inside login method");
		int loginReturn = loginValidation.loginDetails(String.valueOf(inputMap.get("user")), String.valueOf(inputMap.get("pass")));
		if(loginReturn == -1)
			throw new InvalidUserException();
		if(loginReturn == -2)
			throw new ApprovalPendingException();
		return new ResponseEntity<String>(StringConstants.USER_LOGIN_SUCCESSFUL,HttpStatus.OK);
	}
	
	/**
	 * @return
	 * This is used for logout functionality.
	 */
	@RequestMapping(value = "/logout", produces = "text/plain", method = RequestMethod.GET)
	public ResponseEntity<String> logout() {
		log.info("Inside logout method");
		loginService.logout();
		return new ResponseEntity<String>(StringConstants.USER_LOGOUT_SUCCESSFUL,HttpStatus.OK);
	}
}
