package com.lt.crs.constants;

public class SqlConstants {

	public static final String selectCourse = "select * from course";
	public static final String selectCourseParameterized = "select * from course where courseId = ? and  courseName = ?";
	public static final String insertCourse = "insert into course (courseId,courseName,courseAvailable,offlineAmount,onlineAmount) values (?,?,?,?,?)";
	public static final String deleteCourseParameterized = "delete from course where courseId = ?";
	public static final String selectProfessor = "select * from professor";
	public static final String insertProfessor = "insert into professor (professorId,professorName,professorPassword) values (?,?,?)";
	public static final String deleteProfessorParameterized = "delete from professor where professorId=?";
	public static final String studentApproval = "update user set isApproved = true where userId = ?";
	public static final String selectUserParameterized = "select * from user where userName = ? and userPassword = ?";
	
}
