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
import javax.persistence.OneToOne;
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
@Table( name = "CHILD_OVERALL_REPORT" )
public class ChildOverallReport {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "CHILD_OVERALL_REPORT_ID")
	private Long childOverallReportId;

	@Temporal(TemporalType.DATE)
	@Column(name = "PREPARED_ON")
	private Date preparedOn;
	
	@Column(name = "PREPARED_BY")
	private String preparedBy;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity = Child.class)	
	@JoinColumn(name="CHILD_ID", referencedColumnName="USER_ID")
	private Child child;
	
	@OneToOne(fetch=FetchType.EAGER, targetEntity = ChildAcademicReport.class)	
	@JoinColumn(name="ACADEMIC_REPORT_ID", referencedColumnName="ACADEMIC_REPORT_ID")
	private ChildAcademicReport childAcademics;
	
	@OneToOne(fetch=FetchType.EAGER, targetEntity = ChildHealthReport.class)	
	@JoinColumn(name="HEALTH_REPORT_ID", referencedColumnName="HEALTH_REPORT_ID")
	private ChildHealthReport childHealth;
	
	@Column(name = "REPORT")
	private String ngoReportInWords;
	
	@Column(name = "PHOTOS")
	private byte[] photo;

	
	public Long getChildOverallReportId() {
		return childOverallReportId;
	}

	public void setChildOverallReportId(Long childOverallReportId) {
		this.childOverallReportId = childOverallReportId;
	}
	public Date getPreparedOn() {
		return preparedOn;
	}

	public void setPreparedOn(Date preparedOn) {
		this.preparedOn = preparedOn;
	}

	public String getPreparedBy() {
		return preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public ChildAcademicReport getChildAcademics() {
		return childAcademics;
	}

	public void setChildAcademics(ChildAcademicReport childAcademics) {
		this.childAcademics = childAcademics;
	}

	public ChildHealthReport getChildHealth() {
		return childHealth;
	}

	public void setChildHealth(ChildHealthReport childHealth) {
		this.childHealth = childHealth;
	}

	public String getNgoReportInWords() {
		return ngoReportInWords;
	}

	public void setNgoReportInWords(String ngoReportInWords) {
		this.ngoReportInWords = ngoReportInWords;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
}
