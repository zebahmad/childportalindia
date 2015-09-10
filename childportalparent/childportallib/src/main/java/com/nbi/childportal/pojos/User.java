/**
 * 
 */
package com.nbi.childportal.pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * @author zahmad
 *
 */
@Entity
@Table( name = "PERSON" )
public class User {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "USER_ID")
	private Long userId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.ALL}, targetEntity = Address.class)	
	@JoinColumn(name="ADDRESS_ID", referencedColumnName="ADDRESS_ID", insertable=true, updatable=true)
	private Address address;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="child")
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<ChildAdmission> admission;
	
	@ManyToMany(fetch=FetchType.EAGER, cascade={CascadeType.ALL})	
	@JoinTable(name = "USER_ROLE", 
		joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName="USER_ID")}, 
		inverseJoinColumns = {  
						@JoinColumn(name = "ROLE_ID", referencedColumnName="ROLE_ID")})
	private Set<Role> roles  = new HashSet<Role>();
	
	@Column(name = "AADHAR_NO")
	private String aadharNo;
	
	@Column(name = "NAME")	
	private String name;
	
	@Column(name = "PHOTO")	
	private byte[] photo;

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

	
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Set<ChildAdmission> getAdmission() {
		return admission;
	}

	public void setAdmission(Set<ChildAdmission> admission) {
		this.admission = admission;
	}

	public Set<Role> getRoles() {
		return roles;
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
