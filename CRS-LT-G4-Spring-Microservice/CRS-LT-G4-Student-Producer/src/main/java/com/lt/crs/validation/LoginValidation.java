//package com.lt.crs.validation;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.lt.crs.constants.EnumRole;
//import com.lt.dao.AdminDao;
//import com.lt.entity.LoginDetails;
//
///**
// * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
// *
// */
//@Repository
//public class LoginValidation {
//	
//	/**
//	 * This is used to autowire  AdminDao bean
//	 */
//	@Autowired
//	AdminDao adminDao;
//	
//	/**
//	 * @param userName
//	 * @param password
//	 * @return
//	 * This is used to authenticate user credentials.
//	 */
//	public int loginDetails(String userName, String password) {
//		
//		List<Map<String,String>> userDetails =  adminDao.loginValidation(userName, password);
//		if(userDetails.isEmpty())
//			return -1;
//		if(!userDetails.isEmpty() && userDetails.get(0).get(EnumRole.Role.toString()).equalsIgnoreCase(EnumRole.Student.toString()) && userDetails.get(0).get("IsApproved").equalsIgnoreCase("false"))
//			return -2;
//		LoginDetails.userName = userDetails.get(0).get("UserName");
//		LoginDetails.userRole = userDetails.get(0).get(EnumRole.Role.toString());
//		return 1;
//		
//	}
//	
//}
