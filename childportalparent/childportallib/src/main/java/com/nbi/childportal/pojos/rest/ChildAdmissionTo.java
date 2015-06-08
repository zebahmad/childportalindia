/**
 * 
 */
package com.nbi.childportal.pojos.rest;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.nbi.childportal.pojos.ChildAdmission;
import com.nbi.childportal.pojos.EnrollmentStatus;
import com.nbi.childportal.pojos.Organization;
import com.nbi.childportal.pojos.TimeDateAdapter;
import com.nbi.childportal.pojos.User;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="admission")
public class ChildAdmissionTo implements Serializable {

	private static final long serialVersionUID = 8791034597240638012L;
	
	private Long admissionId;
	private User child;
	private Organization school;
	private String admissionNo;
	private String standard;
	private String currentStatus;
	private String schoolingYear;
	private Date createdOn;
	private Date updatedOn;
	private String createdBy;
	private String lastUpdatedBy;
	private String comments;
	private String auditComments;
	private String enrolledBy;
	@XmlJavaTypeAdapter(TimeDateAdapter.class)
	@XmlAccessorType(XmlAccessType.FIELD)
	private Date enrolmentDate;
	
	
	public Long getId() {
		return admissionId;
	}
	public void setId(Long id) {
		this.admissionId = id;
	}
	public User getChild() {
		return child;
	}
	public void setChild(User child) {
		this.child = child;
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
	
	
	public ChildAdmission getChildAdmission() throws Exception{
		ChildAdmission childAdmission = new ChildAdmission();
		
		setFieldValue(childAdmission, "admissionId", admissionId);
		setFieldValue(childAdmission, "admissionNo", admissionNo);
		setFieldValue(childAdmission, "standard", standard);
		setFieldValue(childAdmission, "currentStatus", currentStatus);
		setFieldValue(childAdmission, "schoolingYear", schoolingYear);
		setFieldValue(childAdmission, "createdOn", createdOn);
		setFieldValue(childAdmission, "updatedOn", updatedOn);
		setFieldValue(childAdmission, "createdBy", createdBy);
		setFieldValue(childAdmission, "lastUpdatedBy", lastUpdatedBy);
		setFieldValue(childAdmission, "comments", comments);
		setFieldValue(childAdmission, "auditComments", auditComments);
		setFieldValue(childAdmission, "enrolledBy", enrolledBy);
		setFieldValue(childAdmission, "enrolmentDate", enrolmentDate);
		
		return childAdmission;
	}
	
	public static List<ChildAdmissionTo> getChildAdmissionTo(List<ChildAdmission> childAdmissionList) throws Exception{
		if(childAdmissionList==null || childAdmissionList.size()==0){
			return null;
		}
		List<ChildAdmissionTo> result = new ArrayList<ChildAdmissionTo>();
		
		Iterator<ChildAdmission> iter = childAdmissionList.iterator();
		while(iter.hasNext()){
			ChildAdmission childAdmission = iter.next();
			ChildAdmissionTo childAdmissionTo = new ChildAdmissionTo();
			
			setFieldValue(childAdmissionTo, "admissionId", childAdmission.getId());
			setFieldValue(childAdmissionTo, "admissionNo", childAdmission.getAdmissionNo());
			setFieldValue(childAdmissionTo, "standard", childAdmission.getStandard());
			setFieldValue(childAdmissionTo, "currentStatus", childAdmission.getCurrentStatus());
			setFieldValue(childAdmissionTo, "schoolingYear", childAdmission.getSchoolingYear());
			setFieldValue(childAdmissionTo, "createdOn", childAdmission.getCreatedOn());
			setFieldValue(childAdmissionTo, "updatedOn", childAdmission.getUpdatedOn());
			setFieldValue(childAdmissionTo, "createdBy", childAdmission.getCreatedBy());
			setFieldValue(childAdmissionTo, "lastUpdatedBy", childAdmission.getLastUpdatedBy());
			setFieldValue(childAdmissionTo, "comments", childAdmission.getComments());
			setFieldValue(childAdmissionTo, "auditComments", childAdmission.getAuditComments());
			setFieldValue(childAdmissionTo, "enrolledBy", childAdmission.getEnrolledBy());
			setFieldValue(childAdmissionTo, "enrolmentDate", childAdmission.getEnrolmentDate());
			
			result.add(childAdmissionTo);
		}
		
		return result;
	}
	
	
	private void setFieldValue(ChildAdmission childAdmission, String fieldName, Object value) throws Exception{
		Field admissionIdField = ChildAdmission.class.getDeclaredField(fieldName);
		admissionIdField.setAccessible(true);
		admissionIdField.set(childAdmission, value);
	}
	
	private static void setFieldValue(ChildAdmissionTo childAdmissionTo, String fieldName, Object value) throws Exception{
		Field admissionIdField = ChildAdmissionTo.class.getDeclaredField(fieldName);
		admissionIdField.setAccessible(true);
		admissionIdField.set(childAdmissionTo, value);
	}
}
