package com.lt.crs.constants;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 *
 */
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
	public static final String selectRoleId ="select id from role where role = 'Student'";
	public static final String insertStudent ="insert into student values(?,?,?,?,?)";
	public static final String insertUser = "insert into user values(?,?,?,?,?)";
	public static final String selectStudent="select * from user where roleId = 103 and isApproved = 0";
	public static final String selectStudentName="select studentName from student where studentId =";
	public static final String selectCourseId="select courseId from Course where courseName ='";
	public static final String insertEnrolledcourses="insert into enrolledcourses values (?,?,?,?)";
	public static final String selectStudentDetails="Select * from student where studentId in (select distinct studentId from EnrolledCourses where studentId not in(select distinct studentId from grades))";
	public static final String insertGrades="insert into grades (studentId,grade) values (?,?)";
	public static final String SelectStudentId="select studentId from grades";
	public static final String SELECT_STUDENT_COURSES = "select * from enrolledcourses where studentId=";
	public static final String SELECT_COURSE_AMT = "select * from course where courseId IN (%s)";
	public static final String INSERT_INTO_PAYMENT = "insert into payment (paymentMode,courseAmout,studentUsername) values (?,?,?);";
}
