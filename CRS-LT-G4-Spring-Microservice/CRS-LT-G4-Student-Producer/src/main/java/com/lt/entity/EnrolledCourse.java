package com.lt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 * 
 *         Bean of EnrolledCourse
 */

@Entity
@Table(name = "enrolledcourses")
public class EnrolledCourse {
	
	@Id
	@Column(name = "studentid")
	private int studentId;
	@Column(name = "studentname")
	private String studentName;
	@Column(name = "courseid")
	private String courseId;
	@Column(name = "coursename")
	private String courseName;

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId The studentId to set
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
	 * @param studentName The studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId The courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName The courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
