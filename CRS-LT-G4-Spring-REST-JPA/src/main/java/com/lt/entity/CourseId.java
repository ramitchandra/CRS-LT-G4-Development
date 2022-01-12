package com.lt.entity;

import java.io.Serializable;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 * Bean of course to store course details
 */
public class CourseId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int courseId;
	private String courseName;
	
	
	/**
	 * @return the courseId
	 */
	public int getCourseId() {
		return courseId;
	}


	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}


	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
}

