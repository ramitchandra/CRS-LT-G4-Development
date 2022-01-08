package com.lt.crs.validation;

import org.springframework.stereotype.Service;

import com.lt.bean.LoginDetails;
import com.lt.crs.exception.NoUserLoggedInException;
import com.lt.crs.exception.UnauthorizedAccessException;

@Service
public class UserAuthorization {
	
	public void adminAuthorization() {
		if(!"Admin".equalsIgnoreCase(LoginDetails.userRole)) {
			if(LoginDetails.userRole == null || LoginDetails.userRole.isEmpty())
				throw new NoUserLoggedInException();
			throw new UnauthorizedAccessException();
		}
	}
	
	public void professorAuthorization() {
		if(!"Professor".equalsIgnoreCase(LoginDetails.userRole)) {
			if(LoginDetails.userRole == null || LoginDetails.userRole.isEmpty())
				throw new NoUserLoggedInException();
			throw new UnauthorizedAccessException();
		}
	}
	
	public void studentAuthorization() {
		if(!"Student".equalsIgnoreCase(LoginDetails.userRole)) {
			if(LoginDetails.userRole == null || LoginDetails.userRole.isEmpty())
				throw new NoUserLoggedInException();
			throw new UnauthorizedAccessException();
		}
	}
}
