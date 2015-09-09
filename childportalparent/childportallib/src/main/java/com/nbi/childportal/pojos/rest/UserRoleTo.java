/**
 * 
 */
package com.nbi.childportal.pojos.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.nbi.childportal.pojos.RoleEnum;
import com.nbi.childportal.pojos.UserRole;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="userRole")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserRoleTo extends BaseTo implements Serializable {

	private static final long serialVersionUID = 1021909992680149362L;

	private Long userRoleId;
	private Long userId;
	private String role;
	
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public UserRole getUserRole() throws Exception {
		UserRole user = new UserRole();
		setFieldValue(user, "userId", userId);
		setFieldValue(user, "role", role);
		
		return user;
	}
	public static UserRoleTo getUserRoleTo(UserRole userRole) throws Exception {
		UserRoleTo user = new UserRoleTo();
		setFieldValue(user, "userId", userRole.getUser().getUserId());
		setFieldValue(user, "role", userRole.getRole());
		return user;
	}
	public static UserRole getUserRole(UserRoleTo userRoleTo) throws Exception {
		UserRole user = new UserRole();
		setFieldValue(user, "userId", userRoleTo.getUserId());
		setFieldValue(user, "role", userRoleTo.getRole());
		return user;
	}
}
