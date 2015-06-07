/**
 * 
 */
package com.nbi.childportal.pojos;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author zahmad
 *
 */
@Entity
@Table( name = "PERSON" )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="user")
public class User {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "USER_ID")
	private String userId;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = {CascadeType.ALL}, targetEntity = Address.class)	
	@JoinColumn(name="ADDRESS_ID", referencedColumnName="ADDRESS_ID")
	private Address address;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy="USER_ID")	
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<ChildAdmission> admission;
	
	@Column(name = "AADHAR_NO")
	private String aadharNo;
	
	@Column(name = "NAME")	
	private String name;
	
	@Column(name = "LOCAL_NAME")	
	private String localName;
	
	@Column(name = "FATHER_NAME")
	private String fatherName;

	@Column(name = "MOTHER_NAME")
	private String motherName;

	@Column(name = "GENDER")
	private String gender;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	private Date dob;
	
	@Column(name = "DOB_TYPE")
	private String dob_type;

	@Column(name = "MOBILE")
	private String mobile;
	
	@Column(name = "EMAIL")
	private String email;

	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Set<ChildAdmission> getAdmission() {
		return admission;
	}

	public void setAdmission(Set<ChildAdmission> admission) {
		this.admission = admission;
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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

	
	
}
