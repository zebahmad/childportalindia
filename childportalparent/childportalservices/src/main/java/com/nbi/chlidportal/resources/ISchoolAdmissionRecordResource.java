/**
 * 
 */
package com.nbi.chlidportal.resources;

import com.nbi.childportal.pojos.ChildAdmission;
import com.nbi.childportal.pojos.StatusResponse;

/**
 * @author zahmad
 *
 */
public interface ISchoolAdmissionRecordResource {

	public ChildAdmission getSchoolAdmissionRecord(String studentName) throws Exception;
	public StatusResponse createSchoolAdmissionRecord(ChildAdmission childAdmission) throws Exception;
	public StatusResponse updateSchoolAdmissionRecord(ChildAdmission childAdmission) throws Exception;
	
}
