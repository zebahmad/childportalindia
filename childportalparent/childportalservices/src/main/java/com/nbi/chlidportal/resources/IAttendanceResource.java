/**
 * 
 */
package com.nbi.chlidportal.resources;

import com.nbi.childportal.pojos.ChildAttendance;

/**
 * @author zahmad
 *
 */
public interface IAttendanceResource {

	public ChildAttendance getSchoolAttendanceRecord(String studentName, String standard);
	public void createSchoolAttendanceRecord(ChildAttendance attendanceRecord);
	public void updateSchoolAttendanceRecord(ChildAttendance attendanceRecord);
	
}
