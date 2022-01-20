package com.lt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 *	Bean of student to store student details
 */
@Entity 
@Table(name="student")
public class Student {

	@Id
	@Column(name="studentid")
	private int studentId;
	@Column(name="studentname")
	private String studentName;
	@Column(name="studentemail")
	private String studentEmail;
	@Column(name="studentpassword")
	private String studentPassword;
	
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the studentEmail
	 */
	public String getStudentEmail() {
		return studentEmail;
	}
	/**
	 * @param studentEmail the studentEmail to set
	 */
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	/**
	 * @return the studentPassword
	 */
	public String getStudentPassword() {
		return studentPassword;
	}
	/**
	 * @param studentPassword the studentPassword to set
	 */
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	

	
}

