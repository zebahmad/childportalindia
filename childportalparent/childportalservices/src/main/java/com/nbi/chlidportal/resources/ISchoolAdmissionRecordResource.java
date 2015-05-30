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

	public ChildAdmission getSchoolAdmissionRecord(String studentName);
	public void createSchoolAdmissionRecord(ChildAdmission childAdmission);
	public void updateSchoolAdmissionRecord(ChildAdmission childAdmission);
	
}
