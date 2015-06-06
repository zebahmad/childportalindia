/**
 * 
 */
package com.nbi.chlidportal.resources;

import com.nbi.childportal.pojos.ChildAdmission;
import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.reports.StatType;
import com.nbi.childportal.pojos.reports.Statistic;

/**
 * @author zahmad
 *
 */
public interface IAdmissionResource {

	public ChildAdmission getSchoolAdmissionRecord(String studentName) throws Exception;
	public StatusResponse createSchoolAdmissionRecord(ChildAdmission childAdmission) throws Exception;
	public StatusResponse updateSchoolAdmissionRecord(ChildAdmission childAdmission) throws Exception;
	
	
	public Statistic getSchoolAdmissionStats(String enrolledBy, StatType statType) throws Exception;
	public Statistic getStateSchoolAdmissionStats(String state, String enrolledBy, StatType statType) throws Exception;
	public Statistic getDistrictSchoolAdmissionStats(String state, String district, String enrolledBy, StatType statType) throws Exception;
	
}
