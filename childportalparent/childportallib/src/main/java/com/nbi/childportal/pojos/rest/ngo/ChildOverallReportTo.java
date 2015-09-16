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

import com.nbi.childportal.pojos.TimeDateAdapter;
import com.nbi.childportal.pojos.ngo.ChildOverallReport;
import com.nbi.childportal.pojos.rest.BaseTo;
import com.nbi.childportal.pojos.rest.ChildTo;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="childOverallReport")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChildOverallReportTo  extends BaseTo implements Serializable {
	
	private static final long serialVersionUID = -1040995214230681058L;

	private Long childOverallReportId;
	@XmlJavaTypeAdapter(TimeDateAdapter.class)
	private Date preparedOn;
	private String preparedBy;
	private ChildTo child;
	private ChildAcademicReportTo childAcademics;
	private ChildHealthReportTo childHealth;
	private String ngoReportInWords;
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

	public ChildTo getChild() {
		return child;
	}

	public void setChild(ChildTo child) {
		this.child = child;
	}

	public ChildAcademicReportTo getChildAcademics() {
		return childAcademics;
	}

	public void setChildAcademics(ChildAcademicReportTo childAcademics) {
		this.childAcademics = childAcademics;
	}

	public ChildHealthReportTo getChildHealth() {
		return childHealth;
	}

	public void setChildHealth(ChildHealthReportTo childHealth) {
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

	public static ChildOverallReportTo getChildOverallReportTo(ChildOverallReport childOverallReport) throws Exception {
		ChildOverallReportTo reportTo = new ChildOverallReportTo();
		reportTo.setChild(ChildTo.getChildTo(childOverallReport.getChild()));
		reportTo.setChildAcademics(ChildAcademicReportTo.getChildAcademicReportTo(childOverallReport.getChildAcademics()));
		reportTo.setChildHealth(ChildHealthReportTo.getChildHealthReportTo(childOverallReport.getChildHealth()));
		reportTo.setNgoReportInWords(childOverallReport.getNgoReportInWords());
		reportTo.setPhoto(childOverallReport.getPhoto());
		reportTo.setPreparedBy(childOverallReport.getPreparedBy());
		reportTo.setPreparedOn(childOverallReport.getPreparedOn());
		
		return reportTo;
	}

	public ChildOverallReport getChildOverallReport() throws Exception {
		ChildOverallReport report = new ChildOverallReport();
		report.setChild(child.getChild());
		report.setChildAcademics(childAcademics.getChildAcademicReport());
		report.setChildHealth(childHealth.getChildHealthReport());
		report.setNgoReportInWords(ngoReportInWords);
		report.setPhoto(photo);
		report.setPreparedBy(preparedBy);
		report.setPreparedOn(preparedOn);
		
		return report;
	}
	
}
