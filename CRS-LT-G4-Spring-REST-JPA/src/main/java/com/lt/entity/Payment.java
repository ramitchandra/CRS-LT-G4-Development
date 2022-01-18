package com.lt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 * 
 *         Bean of payment to store payment details
 */

@Entity
@Table(name = "payment")
public class Payment {

	@Id
	@Column(name = "patmentid")
	private int patmentId;
	@Column(name = "paymentmode")
	private String paymentMode;
	@Column(name = "courseamout")
	private String courseAmout;
	@Column(name = "studentusername")
	private String studentUsername;

	/**
	 * @return the paymentId
	 */
	public int getPatmentId() {
		return patmentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPatmentId(int paymentId) {
		this.patmentId = paymentId;
	}

	/**
	 * @return the paymentMode
	 */
	public String getPaymentMode() {
		return paymentMode;
	}

	/**
	 * @param paymentMode the paymentMode to set
	 */
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getCourseAmout() {
		return courseAmout;
	}

	public void setCourseAmout(String courseAmout) {
		this.courseAmout = courseAmout;
	}

	/**
	 * @return the studentUsername
	 */
	public String getStudentUsername() {
		return studentUsername;
	}

	/**
	 * @param studentUsername the studentUsername to set
	 */
	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}

}
