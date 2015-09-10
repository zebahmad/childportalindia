/**
 * 
 */
package com.nbi.childportal.pojos.rest.ngo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.nbi.childportal.pojos.Child;
import com.nbi.childportal.pojos.TimeDateAdapter;
import com.nbi.childportal.pojos.rest.BaseTo;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="childHealthReport")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChildHealthReportTo  extends BaseTo implements Serializable {

	private static final long serialVersionUID = -5823695634038994892L;

	private Long healthReportId;
	private Child child;
	@XmlJavaTypeAdapter(TimeDateAdapter.class)
	private Date dateOfTest;
	private String height;
	private String weight;
	private String doctorReviewComment;

	public Long getHealthReportId() {
		return healthReportId;
	}

	public void setHealthReportId(Long healthReportId) {
		this.healthReportId = healthReportId;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public Date getDateOfTest() {
		return dateOfTest;
	}

	public void setDateOfTest(Date dateOfTest) {
		this.dateOfTest = dateOfTest;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDoctorReviewComment() {
		return doctorReviewComment;
	}

	public void setDoctorReviewComment(String doctorReviewComment) {
		this.doctorReviewComment = doctorReviewComment;
	}
	
	
	
}
