package com.lt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.lt.crs.constants.EnumRole;

/**
 * @author Naman,Purnima,Radha,Ramit,Sai,Vignesh
 * Bean of user to store student details
 *
 */
@Entity 
@Table(name="user")
public class User {
	@Id
	@Column(name="userid")
	private int userId;
	@Column(name="username")
	private String userName;
	@Column(name="userpassword")
	private String userPassword;
	@Column(name="roleid")
	private EnumRole roleId;
	@Column(name="isapproved")
	private boolean isApproved;
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
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
	public EnumRole getRoleId() {
		return roleId;
	}
	/**
	 * @param role the roleId to set
	 */
	public void setRoleId(EnumRole role) {
		this.roleId = role;
	}
	/**
	 * @return the issApproved
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
