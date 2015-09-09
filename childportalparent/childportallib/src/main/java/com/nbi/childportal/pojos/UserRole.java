/**
 * 
 */
package com.nbi.childportal.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class UserRole {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "USER_ROLE_ID")
	private Long userRoleId;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, targetEntity = User.class)	
	@JoinColumn(name="USER_ID", referencedColumnName="USER_ID", insertable=true, updatable=true)
	private User user;
	
	@Column(name = "ROLE")
	private String role;
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User userId) {
		this.user = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
