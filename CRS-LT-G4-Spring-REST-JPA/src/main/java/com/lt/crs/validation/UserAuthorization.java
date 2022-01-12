//package com.lt.crs.validation;
//
//import org.springframework.stereotype.Service;
//
//import com.lt.bean.LoginDetails;
//import com.lt.crs.exception.NoUserLoggedInException;
//import com.lt.crs.exception.UnauthorizedAccessException;
//
///**
// * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
// *
// */
//@Service
//public class UserAuthorization {
//	
//	/**
//	 * This is used to set authorization level of Admin
//	 */
//	public void adminAuthorization() {
//		if(!"Admin".equalsIgnoreCase(LoginDetails.userRole)) {
//			if(LoginDetails.userRole == null || LoginDetails.userRole.isEmpty())
//				throw new NoUserLoggedInException();
//			throw new UnauthorizedAccessException();
//		}
//	}
//	
//	/**
//	 * This is used to set authorization level of Professor
//	 */
//	public void professorAuthorization() {
//		if(!"Professor".equalsIgnoreCase(LoginDetails.userRole)) {
//			if(LoginDetails.userRole == null || LoginDetails.userRole.isEmpty())
//				throw new NoUserLoggedInException();
//			throw new UnauthorizedAccessException();
//		}
//	}
//	
//	/**
//	 * This is used to set authorization level of Student.
//	 */
//	public void studentAuthorization() {
//		if(!"Student".equalsIgnoreCase(LoginDetails.userRole)) {
//			if(LoginDetails.userRole == null || LoginDetails.userRole.isEmpty())
//				throw new NoUserLoggedInException();
//			throw new UnauthorizedAccessException();
//		}
//	}
//}
