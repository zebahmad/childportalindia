/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.ArrayList;
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
import com.nbi.childportal.pojos.EnrollmentReport;
import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.reports.StatType;
import com.nbi.childportal.pojos.reports.Statistic;
import com.nbi.chlidportal.dao.AdmissionDao;
import com.nbi.chlidportal.dao.ReportEnrollmentDao;

/**
 * @author zahmad
 *
 */
@Path("/admission")
public class AdmissionResource 
		implements IAdmissionResource
	{

	private AppLogger logger = new AppLogger(AdmissionResource.class.getCanonicalName());
	
	/**
	 * ADMISSION RECORDS
	 *
	 */
	
	@GET
	@Path("/{studentAadhar}")
	@Produces("application/json")
	@Consumes("application/json")
	public ChildAdmission getSchoolAdmissionRecord(@PathParam("studentAadhar") String studentAadhar) throws Exception {
		AdmissionDao admissionDao;
		List<ChildAdmission> childAdmission = null;
		try {
			admissionDao = AdmissionDao.getInstance();
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
	@Path("/")
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
		StatusResponse response = save(childAdmissionRecord);
		updateEnrollmentReport(childAdmissionRecord);
		
		return response;
	}


	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createSchoolAdmissionRecord(ChildAdmission childAdmissionRecord) throws Exception {
		childAdmissionRecord.setCreatedOn(new Date());
		StatusResponse response = save(childAdmissionRecord);
		updateEnrollmentReport(childAdmissionRecord);
		return response;
	}
	
	
	@GET
	@Path("/stats/enrolledBy/{enrolledBy}/{statType}")
	@Produces("application/json")
	@Consumes("application/json")
	public Statistic getSchoolAdmissionStats(@PathParam("enrolledBy") String enrolledBy, @PathParam("statType") StatType statType) throws Exception {
		AdmissionDao reportDao = AdmissionDao.getInstance();
		EnrollmentReport criteria = new EnrollmentReport();
		criteria.setDistrict(null);
		criteria.setState(null);
		if(enrolledBy!=null && !"".equalsIgnoreCase(enrolledBy) && !"any".equalsIgnoreCase(enrolledBy)){
			criteria.setEnrolledBy(enrolledBy);
		}
		return reportDao.getEnrollmentStats(criteria);
	}

	@GET
	@Path("/stats/state/{state}/enrolledBy/{enrolledBy}/{statType}")
	@Produces("application/json")
	@Consumes("application/json")
	public Statistic getStateSchoolAdmissionStats(@PathParam("state") String state,@PathParam("enrolledBy") String enrolledBy,  @PathParam("statType") StatType statType) throws Exception {
		AdmissionDao reportDao = AdmissionDao.getInstance();
		EnrollmentReport criteria = new EnrollmentReport();
		criteria.setDistrict(null);
		criteria.setState(state);
		if(enrolledBy!=null && !"".equalsIgnoreCase(enrolledBy) && !"any".equalsIgnoreCase(enrolledBy)){
			criteria.setEnrolledBy(enrolledBy);
		}
		return reportDao.getEnrollmentStats(criteria);
	}
	
	@GET
	@Path("/stats/state/{state}/district/{district}/enrolledBy/{enrolledBy}/{statType}")
	@Produces("application/json")
	@Consumes("application/json")
	public Statistic getDistrictSchoolAdmissionStats(@PathParam("state") String state, @PathParam("district") String district, @PathParam("enrolledBy") String enrolledBy, @PathParam("statType") StatType statType) throws Exception {
		AdmissionDao reportDao = AdmissionDao.getInstance();
		EnrollmentReport criteria = new EnrollmentReport();
		criteria.setDistrict(district);
		criteria.setState(state);
		if(enrolledBy!=null && !"".equalsIgnoreCase(enrolledBy) && !"any".equalsIgnoreCase(enrolledBy)){
			criteria.setEnrolledBy(enrolledBy);
		}
		return reportDao.getEnrollmentStats(criteria);
	}
	
	private StatusResponse save(ChildAdmission childAdmissionRecord) {
		StatusResponse response = new StatusResponse();
		AdmissionDao admissionDao =null;
		try {
			admissionDao =AdmissionDao.getInstance();
			admissionDao.saveChildAdmission(childAdmissionRecord);
			
			response.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			String error = e.getMessage();
			if(e.getCause()!=null){
				error = error+e.getCause().getMessage();
			}
			response.setError(error);
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
	
	private void updateEnrollmentReport(ChildAdmission childAdmissionRecord) throws Exception {
		
		int enrollmentMonth = childAdmissionRecord.getEnrolmentDate().getYear();
		
		List<EnrollmentReport> enrollmentReports = new ArrayList<EnrollmentReport>();
		while(enrollmentMonth < 12){
			EnrollmentReport enrollmentReport = new EnrollmentReport();
			enrollmentReport.setAadharNo(childAdmissionRecord.getAadharNo());
			enrollmentReport.setDistrict(childAdmissionRecord.getSchool().getDistrict());
			enrollmentReport.setState(childAdmissionRecord.getSchool().getState());
			enrollmentReport.setYear(String.valueOf(childAdmissionRecord.getEnrolmentDate().getYear()));
			enrollmentReport.setYear(String.valueOf(enrollmentMonth));
			
			enrollmentReports.add(enrollmentReport);
			enrollmentMonth++;
		}
		
		ReportEnrollmentDao.getInstance().saveEnrollmentReports(enrollmentReports);
	}
	
	
}
