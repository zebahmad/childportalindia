/**
 * 
 */
package com.nbi.childportal.pojos.rest;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
	private Set<RoleTo> roles = new HashSet<RoleTo>();
	private String name;
	private byte[] photo;
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
	
	public Set<RoleTo> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleTo> roles) {
		this.roles = roles;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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

	
	public User getUser() throws Exception {
		User user = new User();
		return populateUser(user);
	}
	
	
	public User populateUser(User user) throws Exception {
		setFieldValue(user, "userId", userId);
		if(address!=null){
			setFieldValue(user, "address", address.getAddress());
		}
		setFieldValue(user, "aadharNo", aadharNo);
		setFieldValue(user, "name", name);
		setFieldValue(user, "photo", photo);
		setFieldValue(user, "localName", localName);
		setFieldValue(user, "fatherName", fatherName);
		setFieldValue(user, "motherName", motherName);
		setFieldValue(user, "gender", gender);
		setFieldValue(user, "dob", dob);
		setFieldValue(user, "dob_type", dob_type);
		setFieldValue(user, "mobile", mobile);
		setFieldValue(user, "email", email);
		
		//Set user address
		if(address!=null){
			setFieldValue(user, "address", address.getAddress());
		}
		
		//Set user roles
		if(roles!=null){
			Iterator<RoleTo> iter = roles.iterator();
			while(iter.hasNext()){
				user.getRoles().add(iter.next().getRole());
			}
		}
		return user;
	}
	
	public static UserTo getUserTo(User user) throws Exception {
		UserTo childTo = new UserTo();
		return populateUserTo(childTo, user);
	}
	
	public static UserTo populateUserTo(UserTo userTo, User user) throws Exception {
		if(user==null){
			return null;
		}
		
		setFieldValue(userTo, "userId", user.getUserId());
		if(userTo.getAddress()!=null){
			setFieldValue(userTo, "address", AddressTo.getAddressTo(user.getAddress()));
		}
		setFieldValue(userTo, "aadharNo", user.getAadharNo());
		setFieldValue(userTo, "name", user.getName());
		setFieldValue(userTo, "photo", user.getPhoto());
		setFieldValue(userTo, "localName", user.getLocalName());
		setFieldValue(userTo, "fatherName", user.getFatherName());
		setFieldValue(userTo, "motherName", user.getMotherName());
		setFieldValue(userTo, "gender", user.getGender());
		setFieldValue(userTo, "dob", user.getDob());
		setFieldValue(userTo, "dob_type", user.getDob_type());
		setFieldValue(userTo, "mobile", user.getMobile());
		setFieldValue(userTo, "email", user.getEmail());
		setFieldValue(userTo, "address", AddressTo.getAddressTo(user.getAddress()));
		setFieldValue(userTo, "email", user.getEmail());
		
		userTo.getRoles().addAll(RoleTo.getRoleToSet(user.getRoles()));
		
		return userTo;
	}
	
	
}
