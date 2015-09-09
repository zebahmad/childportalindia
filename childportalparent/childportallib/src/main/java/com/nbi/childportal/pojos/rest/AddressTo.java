/**
 * 
 */
package com.nbi.childportal.pojos.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.nbi.childportal.pojos.Address;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressTo  extends BaseTo implements Serializable {
	
	private static final long serialVersionUID = -3318200096186748827L;
	private Long addressId;
	private String careOf;
	private String landmark;
	private String locality;
	private String villageTownCity;
	private String district;
	private String building;
	private String street;
	private String po;
	private String state;
	private String pinCode;
	
	
	
	public Long getId() {
		return addressId;
	}

	public void setId(Long id) {
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

	
	public Address getAddress() throws Exception {
		Address address = new Address();

		setFieldValue(address, "addressId", addressId);
		setFieldValue(address, "careOf", careOf);
		setFieldValue(address, "landmark", landmark);
		setFieldValue(address, "locality", locality);
		setFieldValue(address, "villageTownCity", villageTownCity);
		setFieldValue(address, "district", district);
		setFieldValue(address, "building", building);
		setFieldValue(address, "street", street);
		setFieldValue(address, "po", po);
		setFieldValue(address, "state", state);
		setFieldValue(address, "pinCode", pinCode);

		return address;
	}

	public static AddressTo getAddressTo(Address address) throws Exception {
		if(address==null){
			return null;
		}
		AddressTo addressTo = new AddressTo();

		setFieldValue(addressTo, "addressId", address.getId());
		setFieldValue(addressTo, "careOf", address.getCareOf());
		setFieldValue(addressTo, "landmark", address.getLandmark());
		setFieldValue(addressTo, "locality", address.getLocality());
		setFieldValue(addressTo, "villageTownCity", address.getVillageTownCity());
		setFieldValue(addressTo, "district", address.getDistrict());
		setFieldValue(addressTo, "building", address.getBuilding());
		setFieldValue(addressTo, "street", address.getStreet());
		setFieldValue(addressTo, "po", address.getPo());
		setFieldValue(addressTo, "state", address.getState());
		setFieldValue(addressTo, "pinCode", address.getPinCode());

		return addressTo;
	}
}
