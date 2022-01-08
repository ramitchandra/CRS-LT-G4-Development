package com.lt.crs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.LoginDetails;
import com.lt.crs.exception.ApprovalPendingException;
import com.lt.crs.exception.InvalidUserException;
import com.lt.crs.validation.LoginValidation;

@RestController
public class LoginController {
	
	@Autowired
	LoginValidation loginValidation;
	
	@RequestMapping(value = "/login/{userName}/{password}", produces = "text/plain", method = RequestMethod.GET)
	public ResponseEntity<String> login(@PathVariable String userName,@PathVariable String password) {
		if(loginValidation.loginDetails(userName, password)==-1)
			throw new InvalidUserException();
		if(loginValidation.loginDetails(userName, password)==-2)
			throw new ApprovalPendingException();
		return new ResponseEntity<String>("User successfully logged in as: " + LoginDetails.userRole,HttpStatus.OK);
	}
}
