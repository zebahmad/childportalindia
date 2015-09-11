/**
 * 
 */
package com.nbi.childportal.pojos.rest;

import java.util.ArrayList;
import java.util.List;

import com.nbi.childportal.pojos.Child;
import com.nbi.childportal.pojos.rest.ngo.ChildAcademicReportTo;
import com.nbi.childportal.pojos.rest.ngo.ChildHealthReportTo;
import com.nbi.childportal.pojos.rest.ngo.ChildSponsorshipTo;


/**
 * @author zahmad
 *
 */

public class ChildTo extends UserTo{	
	
	private static final long serialVersionUID = 1292196417893169599L;
	private List<ChildAdmissionTo> admission = new ArrayList<ChildAdmissionTo>();
	private List<ChildAcademicReportTo> academicReports = new ArrayList<ChildAcademicReportTo>();
	private List<ChildHealthReportTo> healthReports = new ArrayList<ChildHealthReportTo>();
	private List<ChildSponsorshipTo> sponsorships = new ArrayList<ChildSponsorshipTo>();
	
	
	
	public List<ChildAdmissionTo> getAdmission() {
		return admission;
	}
	public List<ChildAcademicReportTo> getAcademicReports() {
		return academicReports;
	}
	public List<ChildHealthReportTo> getHealthReports() {
		return healthReports;
	}
	public List<ChildSponsorshipTo> getSponsorships() {
		return sponsorships;
	}
	
	
	public static ChildTo getChildTo(Child child) throws Exception {
		ChildTo childTo = new ChildTo();
		childTo.setAadharNo(child.getAadharNo());
		childTo.setAddress(AddressTo.getAddressTo(child.getAddress()));
		childTo.setDob(child.getDob());
		childTo.setDob_type(child.getDob_type());
		childTo.setEmail(child.getEmail());
		childTo.setFatherName(child.getFatherName());
		childTo.setGender(child.getGender());
		childTo.setLocalName(child.getLocalName());
		childTo.setMobile(child.getMobile());
		childTo.setMotherName(child.getMotherName());
		childTo.setName(child.getName());
		childTo.setPhoto(child.getPhoto());
		childTo.setRoles(RoleTo.getRoleToSet(child.getRoles()));
		childTo.setUserId(child.getUserId());
		
		childTo.getAdmission().addAll(ChildAdmissionTo.getChildAdmissionToList(child.getAdmission()));
		childTo.getAcademicReports().addAll(ChildAcademicReportTo.getChildAcademicReportToList(child.getAcademicReports()));
		childTo.getHealthReports().addAll(ChildHealthReportTo.getChildHealthReportToList(child.getHealthReports()));
		childTo.getSponsorships().addAll(ChildSponsorshipTo.getChildSponsorshipToList(child.getSponsorships()));
		
		return childTo;
	}
	
	
}
	
	