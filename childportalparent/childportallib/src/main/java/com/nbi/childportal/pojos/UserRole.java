/**
 * 
 */
package com.nbi.childportal.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

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
	@Column(name = "USER_ROLE_ID")
	private Long userRoleId;
	
	@Column(name = "AADHAR_NO")
	private String aadharNo;
	
	@Column(name = "ROLE")
	private String role;
	
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public RoleEnum getRoleEnum() {
		return RoleEnum.valueOf(role);
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
