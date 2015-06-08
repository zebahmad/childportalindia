/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.List;

import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.reports.StatType;
import com.nbi.childportal.pojos.reports.Statistic;
import com.nbi.childportal.pojos.rest.ChildAdmissionTo;

/**
 * @author zahmad
 *
 */
public interface IAdmissionResource {

	public ChildAdmissionTo getSchoolAdmissionRecord(Long admissionId) throws Exception;
	public List<ChildAdmissionTo> getAllSchoolAdmissionRecords(String aadharNo) throws Exception;
	public StatusResponse createSchoolAdmissionRecord(ChildAdmissionTo childAdmission) throws Exception;
	public StatusResponse updateSchoolAdmissionRecord(ChildAdmissionTo childAdmission) throws Exception;
	
	
	public Statistic getSchoolAdmissionStats(String enrolledBy, StatType statType) throws Exception;
	public Statistic getStateSchoolAdmissionStats(String state, String enrolledBy, StatType statType) throws Exception;
	public Statistic getDistrictSchoolAdmissionStats(String state, String district, String enrolledBy, StatType statType) throws Exception;
	
}
