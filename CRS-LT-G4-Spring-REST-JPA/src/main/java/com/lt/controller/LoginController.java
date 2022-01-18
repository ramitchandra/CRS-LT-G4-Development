package com.lt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.constants.StringConstants;
import com.lt.crs.exception.ApprovalPendingException;
import com.lt.crs.exception.InvalidUserException;
import com.lt.crs.validation.LoginValidation;
import com.lt.entity.LoginDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	LoginValidation loginValidation;
	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 * This is used for login functionality.
	 */
	@RequestMapping(value = "/login/{userName}/{password}", produces = "text/plain", method = RequestMethod.GET)
	public ResponseEntity<String> login(@PathVariable String userName,@PathVariable String password) {
		log.info("Inside login method");
		if(loginValidation.loginDetails(userName, password)==-1)
			throw new InvalidUserException();
		if(loginValidation.loginDetails(userName, password)==-2)
			throw new ApprovalPendingException();
		return new ResponseEntity<String>(StringConstants.USER_LOGIN_SUCCESSFUL + LoginDetails.userRole,HttpStatus.OK);
	}
	
	/**
	 * @return
	 * This is used for logout functionality.
	 */
	@RequestMapping(value = "/logout", produces = "text/plain", method = RequestMethod.GET)
	public ResponseEntity<String> logout() {
		log.info("Inside logout method");
		LoginDetails.userName = "";
		LoginDetails.userRole = "";
		return new ResponseEntity<String>(StringConstants.USER_LOGOUT_SUCCESSFUL,HttpStatus.OK);
	}
}
