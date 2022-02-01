/**
 * 
 */
package com.lt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 *
 */
@Entity
public class Login {
	
	@Id
	@Column
	private String userName;
	@Column
	private String userPassword;
	@Column 
	private int roleId;
	
	/**
	 * @return the userId
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}
