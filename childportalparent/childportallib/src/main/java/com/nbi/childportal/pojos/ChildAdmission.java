/**
 * 
 */
package com.nbi.childportal.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@XmlRootElement(name="admission")
public class ChildAdmission implements Serializable {

	private static final long serialVersionUID = 8791034597240638012L;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	private Long id;

	@Column(name = "AADHAR_NO")
	private String aadharNo;
	
	@ManyToOne	
	@JoinColumn(name="ORG_ID")
	private Organization school;
	
	@Column(name = "ADMISSION_NO")
	private String admissionNo;
	
	@Column(name = "STANDARD")
	private String standard;
	
	@Column(name = "CURRENT_STATUS")
	private String currentStatus;
	
	@Column(name = "SCHOOLING_YEAR")
	private String schoolingYear;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON")
	private Date createdOn;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAST_UPDATED_ON")
	private Date updatedOn;
	
	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "LAST_UPDATED_BY")
	private String lastUpdatedBy;
	
	@Column(name = "COMMENTS")
	private String comments;
	
	@Column(name = "AUDIT_COMMENTS")
	private String auditComments;
	
	@Column(name = "ENROLLED_BY")
	private String enrolledBy;
	
	@Column(name = "ENROLLMENT_DATE")
	private Date enrolmentDate;
	
	
	
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
	
	public Organization getSchool() {
		return school;
	}
	public void setSchool(Organization school) {
		this.school = school;
	}
	
	public String getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}
	
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	public String getCurrentStatus() {
		return currentStatus;
	}
	public EnrollmentStatus getEnrollmentCurrentStatus() {
		return EnrollmentStatus.valueOf(currentStatus);
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public String getSchoolingYear() {
		return schoolingYear;
	}
	public void setSchoolingYear(String schoolingYear) {
		this.schoolingYear = schoolingYear;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String[] getAuditCommentsArray() {
		if(auditComments!=null){
			return auditComments.split(";");
		}
		return null;
	}
	public String getAuditComments() {
			return auditComments;
	}
	public void setAuditComments(String auditComments) {
		this.auditComments = auditComments;
	}
	public String getEnrolledBy() {
		return enrolledBy;
	}
	public void setEnrolledBy(String enrolledBy) {
		this.enrolledBy = enrolledBy;
	}
	public Date getEnrolmentDate() {
		return enrolmentDate;
	}
	public void setEnrolmentDate(Date enrolmentDate) {
		this.enrolmentDate = enrolmentDate;
	}
}
