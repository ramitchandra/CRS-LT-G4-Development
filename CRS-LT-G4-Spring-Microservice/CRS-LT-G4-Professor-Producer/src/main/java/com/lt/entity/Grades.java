package com.lt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Naman, Radha, Ramit, Purnima, Sai, Vignesh This bean is used to store
 *         the details of the grades.
 *
 */
@Entity
@Table(name = "grades")
public class Grades {

	@Id
	@Column(name = "studentid")
	private int studentId;
	@Column(name = "studentgrade")
	private String grade;

	public Grades() {

	}

	/**
	 * @return the studentId
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

}
