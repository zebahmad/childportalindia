/**
 * 
 */
package com.nbi.childportal.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author zahmad
 *
 */
@Entity
@Table( name = "ROLE" )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="role")
public class Role {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "ROLE_ID")
	private Long roleId;

	@Column(name = "ROLE")
	private String role;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="roles", targetEntity = User.class)
    private Set<User> users = new HashSet<User>();
	
	
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<User> getUsers() {
		return users;
	}
	
}
