package com.lt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Naman, Radha, Ramit, Purnima, Sai, Vignesh
 *
 */
@Entity
@Table(name="grades")
public class Grades {
	@Id
	@Column(name="studentid")
	private int studentId;
	private String grade;
	@Column(name="isapproved")
	private boolean isApproved;
	
	public Grades() {
		
	}
	
	/**
	 * @return Student ID
	 */
	public int getStudentId() {
		return studentId;
	}
	
	/**
	 * @param Set studentId
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * @return Grade
	 */
	public String getGrade() {
		return grade;
	}
	
	/**
	 * @param Set grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the isApproved
	 */
	public boolean isApproved() {
		return isApproved;
	}

	/**
	 * @param isApproved the isApproved to set
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
}
