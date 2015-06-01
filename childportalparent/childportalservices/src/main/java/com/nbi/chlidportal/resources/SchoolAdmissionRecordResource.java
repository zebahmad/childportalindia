/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.nbi.childportal.common.AppLogger;
import com.nbi.childportal.pojos.ChildAdmission;
import com.nbi.childportal.pojos.ChildAttendance;
import com.nbi.chlidportal.dao.ChildAdmissionDao;

/**
 * @author zahmad
 *
 */
@Path("/school")
public class SchoolAdmissionRecordResource 
		implements ISchoolAdmissionRecordResource, ISchoolAttendanceRecordResource
	{

	private AppLogger logger = new AppLogger(SchoolAdmissionRecordResource.class.getCanonicalName());
	
	/**
	 * ADMISSION RECORDS
	 *
	 */
	
	@GET
	@Path("/admission/{studentAadhar}")
	@Produces("application/json")
	@Consumes("application/json")
	public ChildAdmission getSchoolAdmissionRecord(@PathParam("studentAadhar") String studentAadhar) throws Exception {
		ChildAdmissionDao admissionDao;
		List<ChildAdmission> childAdmission = null;
		try {
			admissionDao = ChildAdmissionDao.getInstance();
			ChildAdmission child = new ChildAdmission();
			child.setAadharNo(studentAadhar);
			childAdmission = admissionDao.getChildAdmission(child );
			if(childAdmission==null){
				return null;
			}
		} catch (Exception e) {
			logger.logException(e);
			throw e;
		}
		return childAdmission.get(0);
	}

	@POST
	@Path("/admission")
	@Produces("application/json")
	@Consumes("application/json")
	public void createSchoolAdmissionRecord(ChildAdmission childAdmissionRecord) {
		// TODO Auto-generated method stub
	}

	@PUT
	@Path("/admission")
	@Produces("application/json")
	@Consumes("application/json")
	public void updateSchoolAdmissionRecord(ChildAdmission childAdmissionRecord) {
		// TODO Auto-generated method stub
	}
	
	
	/**
	 * ATTENDANCE RECORDS
	 */

	@GET
	@Path("/attendance/{studentAadhar}/{standard}")
	@Produces("application/json")
	@Consumes("application/json")
	public ChildAttendance getSchoolAttendanceRecord(String studentAadhar, String standard) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Path("/attendance")
	@Produces("application/json")
	@Consumes("application/json")
	public void createSchoolAttendanceRecord(ChildAttendance attendanceRecord) {
		// TODO Auto-generated method stub
	}

	@PUT
	@Path("/attendance")
	@Produces("application/json")
	@Consumes("application/json")
	public void updateSchoolAttendanceRecord(ChildAttendance attendanceRecord) {
		// TODO Auto-generated method stub
	}

	
	
}
