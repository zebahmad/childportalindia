/**
 * 
 */
package com.nbi.childportal.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table( name = "ADDRESS" )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="address")
public class Address {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "ADDRESS_ID")
	private String addressId;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy="ADDRESS_ID")
	private User user;
	
	@Column(name = "CARE_OF")
	private String careOf;

	@Column(name = "LANDMARK")
	private String landmark;

	@Column(name = "LOCALITY")
	private String locality;

	@Column(name = "VILLAGE_TOWN_CITY")
	private String villageTownCity;

	@Column(name = "DISTRICT")
	private String district;

	@Column(name = "BUILDING")
	private String building;

	@Column(name = "STREET")
	private String street;

	@Column(name = "POSTOFFICE")
	private String po;

	@Column(name = "STATE")
	private String state;

	@Column(name = "PIN_CODE")
	private String pinCode;
	
	public String getId() {
		return addressId;
	}

	public void setId(String id) {
		this.addressId = id;
	}

	public String getCareOf() {
		return careOf;
	}

	public void setCareOf(String careOf) {
		this.careOf = careOf;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getVillageTownCity() {
		return villageTownCity;
	}

	public void setVillageTownCity(String villageTownCity) {
		this.villageTownCity = villageTownCity;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPo() {
		return po;
	}

	public void setPo(String po) {
		this.po = po;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
