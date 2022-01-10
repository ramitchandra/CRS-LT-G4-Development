package com.lt.crs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.LoginDetails;
import com.lt.crs.exception.ApprovalPendingException;
import com.lt.crs.exception.InvalidUserException;
import com.lt.crs.validation.LoginValidation;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	LoginValidation loginValidation;
	
	/**
	 * @param userName
	 * @param password
	 * @return
	 * This is used for login functionality.
	 */
	@RequestMapping(value = "/login/{userName}/{password}", produces = "text/plain", method = RequestMethod.GET)
	public ResponseEntity<String> login(@PathVariable String userName,@PathVariable String password) {
		if(loginValidation.loginDetails(userName, password)==-1)
			throw new InvalidUserException();
		if(loginValidation.loginDetails(userName, password)==-2)
			throw new ApprovalPendingException();
		return new ResponseEntity<String>("User successfully logged in as: " + LoginDetails.userRole,HttpStatus.OK);
	}
	
	/**
	 * @return
	 * This is used for logout functionality.
	 */
	@RequestMapping(value = "/logout", produces = "text/plain", method = RequestMethod.GET)
	public ResponseEntity<String> logout() {
		LoginDetails.userName = "";
		LoginDetails.userRole = "";
		return new ResponseEntity<String>("User logged out successfully!!",HttpStatus.OK);
	}
}
