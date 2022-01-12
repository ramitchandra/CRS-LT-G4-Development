package com.lt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 * Bean of course to store course details
 */
@Entity
@Table(name = "course")
@IdClass(CourseId.class)
public class Course implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "courseid")
	private int courseId;
	@Id
	@Column(name = "coursename")
	private String courseName;
	@Column(name = "onlineamount")
	private int onlineFees;
	@Column(name = "offlineamount")
	private int offlieFees;
	@Column(name = "courseavailable")
	private boolean courseAvailable = false;
	@Transient
	private int enrollmentCounter = 0;
	
	
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


	/**
	 * @return the onlineFees
	 */
	public int getOnlineFees() {
		return onlineFees;
	}


	/**
	 * @param onlineFees the onlineFees to set
	 */
	public void setOnlineFees(int onlineFees) {
		this.onlineFees = onlineFees;
	}


	/**
	 * @return the offlieFees
	 */
	public int getOfflieFees() {
		return offlieFees;
	}


	/**
	 * @param offlieFees the offlieFees to set
	 */
	public void setOfflieFees(int offlieFees) {
		this.offlieFees = offlieFees;
	}


	/**
	 * @return the courseAvailable
	 */
	public boolean isCourseAvailable() {
		return courseAvailable;
	}


	/**
	 * @param courseAvailable the courseAvailable to set
	 */
	public void setCourseAvailable(boolean courseAvailable) {
		this.courseAvailable = courseAvailable;
	}


	/**
	 * @return the enrollmentCounter
	 */
	public int getEnrollmentCounter() {
		return enrollmentCounter;
	}


	/**
	 * @param enrollmentCounter the enrollmentCounter to set
	 */
	public void setEnrollmentCounter(int enrollmentCounter) {
		this.enrollmentCounter = enrollmentCounter;
	}


	@Override
    public boolean equals(Object o) {
 
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof Course)) {
            return false;
        }

        Course c = (Course) o;

        return this.getCourseId() == c.getCourseId();
    }


	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", onlineFees=" + onlineFees
				+ ", offlieFees=" + offlieFees + ", courseAvailable=" + courseAvailable + "]";
	}
	
}

