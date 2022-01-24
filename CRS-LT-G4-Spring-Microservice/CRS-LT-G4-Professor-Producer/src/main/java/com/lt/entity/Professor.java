package com.lt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Naman, Purnima, Radha, Ramit, Sai, Vignesh Bean of professor to store
 *         professor details
 *
 */
@Entity
@Table(name = "professor")
public class Professor {

	@Id
	@Column(name = "professorid")
	private int professorId;
	@Column(name = "professorname")
	private String professorName;
	@Column(name = "professorpassword")
	private String professorPass;

	/**
	 * @return the professorId
	 */
	public int getProfessorId() {
		return professorId;
	}

	/**
	 * @param professorId the professorId to set
	 */
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	/**
	 * @return the professorName
	 */
	public String getProfessorName() {
		return professorName;
	}

	/**
	 * @param professorName the professorName to set
	 */
	public void setProfessorName(String professorName) {
		this.professorName = professorName;
	}

	/**
	 * @return the professorPass
	 */
	public String getProfessorPass() {
		return professorPass;
	}

	/**
	 * @param professorPass
	 */
	public void setProfessorPass(String professorPass) {
		this.professorPass = professorPass;
	}
}
