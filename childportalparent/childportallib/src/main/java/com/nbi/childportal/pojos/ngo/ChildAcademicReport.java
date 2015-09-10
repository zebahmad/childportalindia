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
@Table( name = "CHILD_ACADEMIC_REPORT" )
public class ChildAcademicReport {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "ACADEMIC_REPORT_ID")
	private Long academicReportId;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity = Child.class)	
	@JoinColumn(name="CHILD_ID", referencedColumnName="USER_ID")
	private Child child;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DOT")
	private Date dateOfTest;
	
	@Column(name = "MATH")
	private String mathScore;
	
	@Column(name = "ENGLISH")
	private String englishScore;
	
	@Column(name = "SCIENCE")
	private String scienceScore;

	@Column(name = "SOCIAL")
	private String socialScore;
	
	@Column(name = "GK")
	private String gkScore;
	
	@Column(name = "KANNADA")
	private String kannadaScore;

	@Column(name = "TEACHER_COMMENTS")
	private String commentsByTeacher;

	
	
	public Long getAcademicReportId() {
		return academicReportId;
	}

	public void setAcademicReportId(Long academicReportId) {
		this.academicReportId = academicReportId;
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
