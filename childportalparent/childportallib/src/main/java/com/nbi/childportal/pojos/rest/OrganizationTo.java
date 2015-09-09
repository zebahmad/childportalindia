/**istrstrictist
 * 
 */
package com.nbi.childportal.pojos.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.nbi.childportal.pojos.OrgTypeEnum;
import com.nbi.childportal.pojos.Organization;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="org")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationTo  extends BaseTo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8680114011921208530L;
	private Long orgId;
	private String orgType;	
	private String orgCode;
	private String orgName;
	private String address;
	private String district;
	private String state;


	
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
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
	
	public Organization getOrg() throws Exception {
		Organization org = new Organization();

		setFieldValue(org, "orgId", orgId);
		setFieldValue(org, "orgType", orgType);
		setFieldValue(org, "orgCode", orgCode);
		setFieldValue(org, "orgName", orgName);
		setFieldValue(org, "address", address);
		setFieldValue(org, "district", district);
		setFieldValue(org, "state", state);

		return org;
	}
	public static OrganizationTo getOrgTo(Organization school) throws Exception {
		if(school==null){
			return null;
		}
		OrganizationTo org = new OrganizationTo();

		setFieldValue(org, "orgId", school.getOrgId());
		setFieldValue(org, "orgType", school.getOrgType());
		setFieldValue(org, "orgCode", school.getOrgCode());
		setFieldValue(org, "orgName", school.getOrgName());
		setFieldValue(org, "address", school.getAddress());
		setFieldValue(org, "district", school.getDistrict());
		setFieldValue(org, "state", school.getState());

		return org;
	}

}
