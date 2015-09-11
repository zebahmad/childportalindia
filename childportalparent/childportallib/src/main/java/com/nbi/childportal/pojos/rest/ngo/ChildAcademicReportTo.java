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
import com.nbi.childportal.pojos.ngo.ChildAcademicReport;
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
	private Long mathScore;
	private Long englishScore;
	private Long scienceScore;
	private Long socialScore;
	private Long gkScore;
	private Long kannadaScore;
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

	public Long getMathScore() {
		return mathScore;
	}

	public void setMathScore(Long mathScore) {
		this.mathScore = mathScore;
	}

	public Long getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(Long englishScore) {
		this.englishScore = englishScore;
	}

	public Long getScienceScore() {
		return scienceScore;
	}

	public void setScienceScore(Long scienceScore) {
		this.scienceScore = scienceScore;
	}

	public Long getSocialScore() {
		return socialScore;
	}

	public void setSocialScore(Long socialScore) {
		this.socialScore = socialScore;
	}

	public Long getGkScore() {
		return gkScore;
	}

	public void setGkScore(Long gkScore) {
		this.gkScore = gkScore;
	}

	public Long getKannadaScore() {
		return kannadaScore;
	}

	public void setKannadaScore(Long kannadaScore) {
		this.kannadaScore = kannadaScore;
	}

	public String getCommentsByTeacher() {
		return commentsByTeacher;
	}

	public void setCommentsByTeacher(String commentsByTeacher) {
		this.commentsByTeacher = commentsByTeacher;
	}

	public static List<ChildAcademicReportTo> getChildAcademicReportToList(List<ChildAcademicReport> childAcademicReport) throws Exception {
		if(childAcademicReport==null || childAcademicReport.size()==0){
			return null;
		}
		
		List<ChildAcademicReportTo> childReportToList = new ArrayList<ChildAcademicReportTo>();
		Iterator<ChildAcademicReport> iter = childAcademicReport.iterator();
		while(iter.hasNext()){
			childReportToList.add(ChildAcademicReportTo.getChildAcademicReportTo(iter.next()));
		}
		return childReportToList;
	}
	
	public static ChildAcademicReportTo getChildAcademicReportTo(ChildAcademicReport childAcademicReport) throws Exception {
		if(childAcademicReport==null) return null;
		
		ChildAcademicReportTo reportTo = new ChildAcademicReportTo();
		reportTo.setAcademicReportId(childAcademicReport.getAcademicReportId());
		reportTo.setChild(ChildTo.getChildTo(childAcademicReport.getChild()));
		reportTo.setCommentsByTeacher(childAcademicReport.getCommentsByTeacher());
		reportTo.setDateOfTest(childAcademicReport.getDateOfTest());
		reportTo.setEnglishScore(childAcademicReport.getEnglishScore());
		reportTo.setGkScore(childAcademicReport.getGkScore());
		reportTo.setKannadaScore(childAcademicReport.getKannadaScore());
		reportTo.setMathScore(childAcademicReport.getMathScore());
		reportTo.setScienceScore(childAcademicReport.getScienceScore());
		reportTo.setSocialScore(childAcademicReport.getSocialScore());
		
		return reportTo;
	}
	
}
