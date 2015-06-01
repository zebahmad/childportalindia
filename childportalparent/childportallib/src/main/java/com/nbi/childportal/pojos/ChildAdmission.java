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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author zahmad
 *
 */
@Entity
@Table( name = "CHILD_SCHOOL_ADMISSION" )
public class ChildAdmission implements Serializable {

	private static final long serialVersionUID = 8791034597240638012L;
	private Long id;
	private String aadharNo;
	private String schoolId;
	private String admissionNo;
	private String standard;
	private EnrollmentStatus currentStatus;
	private String schoolingYear;
	private Date createdOn;
	private Date updatedOn;
	private String createdBy;
	private String lastUpdatedBy;
	private String comments;
	private String[] auditComments;
	
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
	    return id;
	}
	
	@Column(name = "AADHAR_NO")
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	
	@Column(name = "SCHOOL_ID")
	public String getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}
	
	@Column(name = "ADMISSION_NO")
	public String getAdmissionNo() {
		return admissionNo;
	}
	public void setAdmissionNo(String admissionNo) {
		this.admissionNo = admissionNo;
	}
	
	@Column(name = "STANDARD")
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	@Column(name = "CURRENT_STATUS")
	public EnrollmentStatus getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = EnrollmentStatus.valueOf(currentStatus);
	}
	public void setCurrentStatus(EnrollmentStatus currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	@Column(name = "SCHOOLING_YEAR")
	public String getSchoolingYear() {
		return schoolingYear;
	}
	public void setSchoolingYear(String schoolingYear) {
		this.schoolingYear = schoolingYear;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_ON")
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Column(name = "LAST_UPDATED_ON")
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	@Column(name = "CREATED_BY")
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "LAST_UPDATED_BY")
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	@Column(name = "COMMENTS")
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	@Column(name = "AUDIT_COMMENTS")
	public String[] getAuditComments() {
		return auditComments;
	}
	public void setAuditComments(String[] auditComments) {
		this.auditComments = auditComments;
	}
	public void setAuditComments(String auditComments) {
		if(auditComments!=null && auditComments.length()>0){
			this.auditComments = auditComments.split(";");
		}
	}
}
