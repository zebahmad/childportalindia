/**istrstrictist
 * 
 */
package com.nbi.childportal.pojos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author zahmad
 *
 */
@Entity
@Table( name = "childportal.ORGANIZATION" )
public class Organization {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "ORG_ID")
	private Long orgId;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="school")	
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<ChildAdmission> enrolledChildren;

	@Column(name = "ORG_TYPE")
	private String orgType;	
	
	@Column(name = "ORG_CODE")
	private String orgCode;
	
	@Column(name = "ORG_NAME")
	private String orgName;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "DISTRICT")
	private String district;
	
	@Column(name = "STATE")
	private String state;
	
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Set<ChildAdmission> getEnrolledChildren() {
		return enrolledChildren;
	}
	public void setEnrolledChildren(Set<ChildAdmission> enrolledChildren) {
		this.enrolledChildren = enrolledChildren;
	}
	public String getOrgType() {
		return orgType;
	}
	public OrgTypeEnum getOrgTypeEnum() {
		return OrgTypeEnum.valueOf(orgType);
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public void setOrgTypeEnum(OrgTypeEnum orgType) {
		this.orgType = orgType.toString();
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String location) {
		this.district = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
