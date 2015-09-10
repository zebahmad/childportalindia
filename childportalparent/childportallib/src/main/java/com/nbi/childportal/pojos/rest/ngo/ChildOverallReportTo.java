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
@XmlRootElement(name="childOverallReport")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChildOverallReportTo  extends BaseTo implements Serializable {
	
	private static final long serialVersionUID = -1040995214230681058L;

	@XmlJavaTypeAdapter(TimeDateAdapter.class)
	private Date preparedOn;
	private String preparedBy;
	private Child child;
	private ChildAcademicReportTo childAcademics;
	private ChildHealthReportTo childHealth;
	private String ngoReportInWords;
	private byte[] photo;

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
	
}
