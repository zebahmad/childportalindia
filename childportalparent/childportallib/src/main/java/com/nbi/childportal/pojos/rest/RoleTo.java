/**
 * 
 */
package com.nbi.childportal.pojos.rest;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	public static Set<RoleTo> getRoleToSet(Set<Role> roles) throws Exception {
		if(roles==null || roles.size()==0) return null;
		
		 Set<RoleTo> roleToSet = new HashSet<RoleTo>();
		Iterator<Role> iter = roles.iterator();
		while(iter.hasNext()){
			Role role = iter.next();
			roleToSet.add(RoleTo.getRoleTo(role));
		}
		return roleToSet;
	}
}
