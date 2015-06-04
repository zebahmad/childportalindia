/**istrstrictist
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
@Table( name = "SCHOOL" )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="school")
public class School {
	
	@Id
	@Column(name = "SCHOOL_ID")
	private String schoolId;
	
	@Column(name = "SCHOOL_CODE")
	private String schoolCode;
	
	@Column(name = "SCHOOL_NAME")
	private String name;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "DISTRICT")
	private String district;
	
	@Column(name = "STATE")
	private String state;
	
	
	
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	public String getSchoolCode() {
		return schoolCode;
	}
	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
