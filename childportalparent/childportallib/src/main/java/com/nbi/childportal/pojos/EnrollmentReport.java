/**
 * 
 */
package com.nbi.childportal.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table( name = "ADMISSION" )
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="enrollmentReport")
public class EnrollmentReport {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;

	@Column(name = "AADHAR_NO")
	private String aadharNo;
	
	@Column(name = "YEAR")	
	private String year;
	
	@Column(name = "MONTH")
	private String month;
	
	@Column(name = "DISTRICT")
	private String district;
	
	@Column(name = "STATE")
	private String state;

	@Column(name = "ENROLLED_BY")
	private String enrolledBy;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getEnrolledBy() {
		return enrolledBy;
	}

	public void setEnrolledBy(String enrolledBy) {
		this.enrolledBy = enrolledBy;
	}
	
	
}
