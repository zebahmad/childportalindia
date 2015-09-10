/**
 * 
 */
package com.nbi.childportal.pojos.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.nbi.childportal.pojos.Role;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="userRole")
@XmlAccessorType(XmlAccessType.FIELD)
public class RoleTo extends BaseTo implements Serializable {

	private static final long serialVersionUID = 1021909992680149362L;

	private Long roleId;
	private String role;

	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public Role getRole() throws Exception {
		Role user = new Role();
		setFieldValue(user, "roleId", roleId);
		setFieldValue(user, "role", role);
		
		return user;
	}
	public static RoleTo getRoleTo(Role userRole) throws Exception {
		RoleTo user = new RoleTo();
		setFieldValue(user, "roleId", userRole.getRoleId());
		setFieldValue(user, "role", userRole.getRole());
		return user;
	}
}
