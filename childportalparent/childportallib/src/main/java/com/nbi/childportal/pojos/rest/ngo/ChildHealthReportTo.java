/**
 * 
 */
package com.nbi.childportal.pojos.rest.ngo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.nbi.childportal.pojos.TimeDateAdapter;
import com.nbi.childportal.pojos.ngo.ChildHealthReport;
import com.nbi.childportal.pojos.rest.BaseTo;
import com.nbi.childportal.pojos.rest.ChildTo;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="childHealthReport")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChildHealthReportTo  extends BaseTo implements Serializable {

	private static final long serialVersionUID = -5823695634038994892L;

	private Long healthReportId;
	private ChildTo child;
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

	public ChildTo getChild() {
		return child;
	}

	public void setChild(ChildTo child) {
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

	public static List<ChildHealthReportTo> getChildHealthReportToList(List<ChildHealthReport> healthReports) throws Exception {
		if(healthReports==null || healthReports.size()==0) return null;
		
		List<ChildHealthReportTo> reportTo = new ArrayList<ChildHealthReportTo>();
		Iterator<ChildHealthReport> iter = healthReports.iterator();
		while(iter.hasNext()){
			reportTo.add(ChildHealthReportTo.getChildHealthReportTo(iter.next()));
		}
		return reportTo;
	}

	public static ChildHealthReportTo getChildHealthReportTo(ChildHealthReport healthReport) throws Exception {
		if(healthReport==null) return null;
		
		ChildHealthReportTo reportTo = new ChildHealthReportTo();
		reportTo.setChild(ChildTo.getChildTo(healthReport.getChild()));
		reportTo.setDateOfTest(healthReport.getDateOfTest());
		reportTo.setDoctorReviewComment(healthReport.getDoctorReviewComment());
		reportTo.setHealthReportId(healthReport.getHealthReportId());
		reportTo.setHeight(healthReport.getHeight());
		reportTo.setWeight(healthReport.getWeight());
		
		return reportTo;
	}
	
	
	
}
