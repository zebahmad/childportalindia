/**
 * 
 */
package com.nbi.childportal.pojos.ngo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.nbi.childportal.pojos.Child;

/**
 * @author zahmad
 *
 */
@Entity
@Table( name = "CHILD_HEALTH_REPORT" )
public class ChildHealthReport {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "HEALTH_REPORT_ID")
	private Long healthReportId;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity = Child.class)	
	@JoinColumn(name="CHILD_ID", referencedColumnName="USER_ID")
	private Child child;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DOT")
	private Date dateOfTest;
	
	@Column(name = "HEIGHT")
	private String height;
	
	@Column(name = "WEIGHT")
	private String weight;
	
	@Column(name = "DOC_COMMENT")
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
