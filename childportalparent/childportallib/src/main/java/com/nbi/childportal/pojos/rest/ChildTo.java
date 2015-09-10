/**
 * 
 */
package com.nbi.childportal.pojos.rest;

import java.util.HashSet;
import java.util.Set;

import com.nbi.childportal.pojos.rest.ngo.ChildAcademicReportTo;
import com.nbi.childportal.pojos.rest.ngo.ChildHealthReportTo;
import com.nbi.childportal.pojos.rest.ngo.ChildSponsorshipTo;


/**
 * @author zahmad
 *
 */

public class ChildTo extends UserTo{	
	
	private static final long serialVersionUID = 1292196417893169599L;
	private Set<ChildAdmissionTo> admission = new HashSet<ChildAdmissionTo>();
	private Set<ChildAcademicReportTo> academicReports = new HashSet<ChildAcademicReportTo>();
	private Set<ChildHealthReportTo> healthReports = new HashSet<ChildHealthReportTo>();
	private Set<ChildSponsorshipTo> sponsorships = new HashSet<ChildSponsorshipTo>();
	
	
	
	public Set<ChildAdmissionTo> getAdmission() {
		return admission;
	}
	public Set<ChildAcademicReportTo> getAcademicReports() {
		return academicReports;
	}
	public Set<ChildHealthReportTo> getHealthReports() {
		return healthReports;
	}
	public Set<ChildSponsorshipTo> getSponsorships() {
		return sponsorships;
	}
	
	
}
	
	