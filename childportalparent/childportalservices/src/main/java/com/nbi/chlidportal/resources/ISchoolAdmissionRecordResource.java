/**
 * 
 */
package com.nbi.chlidportal.resources;

import com.nbi.childportal.pojos.ChildAdmission;

/**
 * @author zahmad
 *
 */
public interface ISchoolAdmissionRecordResource {

	public ChildAdmission getSchoolAdmissionRecord(String studentName) throws Exception;
	public void createSchoolAdmissionRecord(ChildAdmission childAdmission) throws Exception;
	public void updateSchoolAdmissionRecord(ChildAdmission childAdmission) throws Exception;
	
}
