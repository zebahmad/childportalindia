/**
 * 
 */
package com.nbi.childportal.pojos.rest;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.nbi.childportal.pojos.TimeDateAdapter;
import com.nbi.childportal.pojos.User;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserTo extends BaseTo implements Serializable {
	
	private static final long serialVersionUID = 7172761134278607343L;
	private Long userId;
	private AddressTo address;
	private String aadharNo;
	private String name;
	private String localName;
	private String fatherName;
	private String motherName;
	private String gender;
	@XmlJavaTypeAdapter(TimeDateAdapter.class)
	private Date dob;
	private String dob_type;
	private String mobile;
	private String email;
	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDob_type() {
		return dob_type;
	}

	public void setDob_type(String dob_type) {
		this.dob_type = dob_type;
	}
	
	public AddressTo getAddress() {
		return address;
	}

	public void setAddress(AddressTo address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public User getChild() throws Exception {
		User child = new User();
		
		setFieldValue(child, "userId", userId);
		if(address!=null){
			setFieldValue(child, "address", address.getAddress());
		}
		setFieldValue(child, "aadharNo", aadharNo);
		setFieldValue(child, "name", name);
		setFieldValue(child, "localName", localName);
		setFieldValue(child, "fatherName", fatherName);
		setFieldValue(child, "motherName", motherName);
		setFieldValue(child, "gender", gender);
		setFieldValue(child, "dob", dob);
		setFieldValue(child, "dob_type", dob_type);
		setFieldValue(child, "mobile", mobile);
		setFieldValue(child, "email", email);
		
		return child;
	}
	
	
}
