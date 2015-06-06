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
	public Statistic getSchoolAdmissionStats(ChildAdmission childAdmissionRecord, StatType statType) throws Exception;
	
}
