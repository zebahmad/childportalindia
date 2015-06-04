/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.Date;
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
import com.nbi.childportal.pojos.StatusResponse;
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

	
	@PUT
	@Path("/admission")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateSchoolAdmissionRecord(ChildAdmission childAdmissionRecord) throws Exception {
		ChildAdmission existingChildAdmissionRecord = null;
		try {
			existingChildAdmissionRecord = getSchoolAdmissionRecord(childAdmissionRecord.getAadharNo());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Could not retrieve given admission record for update");
		}
		
		childAdmissionRecord = updateFieldsFromOriginalAdmissionRecord(existingChildAdmissionRecord, childAdmissionRecord);
		return save(childAdmissionRecord);
	}

	@POST
	@Path("/admission")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createSchoolAdmissionRecord(ChildAdmission childAdmissionRecord) {
		childAdmissionRecord.setCreatedOn(new Date());
		return save(childAdmissionRecord);
	}
	
	private StatusResponse save(ChildAdmission childAdmissionRecord) {
		StatusResponse response = new StatusResponse();
		ChildAdmissionDao admissionDao =null;
		try {
			admissionDao =ChildAdmissionDao.getInstance();
			admissionDao.saveChildAdmission(childAdmissionRecord);
			
			response.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			response.setError(e.getMessage());
		}
		return response;
		
	}
	
	private ChildAdmission updateFieldsFromOriginalAdmissionRecord(ChildAdmission originalChildAdmissionRecord, ChildAdmission newChildAdmissionRecord) {
		originalChildAdmissionRecord.setAuditComments(newChildAdmissionRecord.getAuditComments());
		originalChildAdmissionRecord.setComments(newChildAdmissionRecord.getComments());
		originalChildAdmissionRecord.setCurrentStatus(newChildAdmissionRecord.getCurrentStatus());
		originalChildAdmissionRecord.setLastUpdatedBy(newChildAdmissionRecord.getLastUpdatedBy());
		originalChildAdmissionRecord.setUpdatedOn(new Date());
		
		return originalChildAdmissionRecord;
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
