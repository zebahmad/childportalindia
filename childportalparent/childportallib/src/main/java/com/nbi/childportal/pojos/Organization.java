/**istrstrictist
 * 
 */
package com.nbi.childportal.pojos;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author zahmad
 *
 */
@Entity
@Table( name = "ORGANIZATION" )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="org")
public class Organization {
	
	@Id
	@Column(name = "ORG_ID")
	private String orgId;

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
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
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
