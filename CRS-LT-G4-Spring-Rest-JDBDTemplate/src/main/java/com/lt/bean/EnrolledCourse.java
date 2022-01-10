package com.lt.bean;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh
 * 
 *         Bean of EnrolledCourse
 */
public class EnrolledCourse {

	private int studentId;
	private String studentName;
	private int courseId;
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
	public int getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId The courseId to set
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
	 * @param courseName The courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
