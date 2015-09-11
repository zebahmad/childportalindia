/**
 * 
 */
package com.nbi.childportal.pojos;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.nbi.childportal.pojos.ngo.ChildAcademicReport;
import com.nbi.childportal.pojos.ngo.ChildHealthReport;
import com.nbi.childportal.pojos.ngo.ChildSponsorship;


/**
 * @author zahmad
 *
 */

public class Child extends User{	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="child")
	@NotFound(action=NotFoundAction.IGNORE)
	private List<ChildAdmission> admission;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="child")
	@NotFound(action=NotFoundAction.IGNORE)
	private List<ChildAcademicReport> academicReports;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="child")
	@NotFound(action=NotFoundAction.IGNORE)
	private List<ChildHealthReport> healthReports;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="child")
	@NotFound(action=NotFoundAction.IGNORE)
	private List<ChildSponsorship> sponsorships;

	public List<ChildAdmission> getAdmission() {
		return admission;
	}

	public List<ChildAcademicReport> getAcademicReports() {
		return academicReports;
	}

	public List<ChildHealthReport> getHealthReports() {
		return healthReports;
	}

	public List<ChildSponsorship> getSponsorships() {
		return sponsorships;
	}

	
	
}
	
	