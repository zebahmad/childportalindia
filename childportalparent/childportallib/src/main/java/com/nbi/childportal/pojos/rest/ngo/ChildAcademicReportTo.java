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
import com.nbi.childportal.pojos.rest.BaseTo;
import com.nbi.childportal.pojos.rest.ChildTo;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="childAcademicReport")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChildAcademicReportTo  extends BaseTo implements Serializable {
	
	private static final long serialVersionUID = 8771271755670620212L;
	
	private Long academicReportId;
	private ChildTo child;
	@XmlJavaTypeAdapter(TimeDateAdapter.class)
	private Date dateOfTest;
	private String mathScore;
	private String englishScore;
	private String scienceScore;
	private String socialScore;
	private String gkScore;
	private String kannadaScore;
	private String commentsByTeacher;

	public Long getAcademicReportId() {
		return academicReportId;
	}

	public void setAcademicReportId(Long academicReportId) {
		this.academicReportId = academicReportId;
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

	public String getMathScore() {
		return mathScore;
	}

	public void setMathScore(String mathScore) {
		this.mathScore = mathScore;
	}

	public String getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(String englishScore) {
		this.englishScore = englishScore;
	}

	public String getScienceScore() {
		return scienceScore;
	}

	public void setScienceScore(String scienceScore) {
		this.scienceScore = scienceScore;
	}

	public String getSocialScore() {
		return socialScore;
	}

	public void setSocialScore(String socialScore) {
		this.socialScore = socialScore;
	}

	public String getGkScore() {
		return gkScore;
	}

	public void setGkScore(String gkScore) {
		this.gkScore = gkScore;
	}

	public String getKannadaScore() {
		return kannadaScore;
	}

	public void setKannadaScore(String kannadaScore) {
		this.kannadaScore = kannadaScore;
	}

	public String getCommentsByTeacher() {
		return commentsByTeacher;
	}

	public void setCommentsByTeacher(String commentsByTeacher) {
		this.commentsByTeacher = commentsByTeacher;
	}
	
}
