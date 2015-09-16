/**
 * 
 */
package com.nbi.chlidportal.ngo.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.hibernate.HibernateException;

import com.nbi.childportal.pojos.Child;
import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.ngo.ChildOverallReport;
import com.nbi.childportal.pojos.rest.ngo.ChildOverallReportTo;
import com.nbi.chlidportal.ngo.dao.ChildOverallReportDao;


/**
 * @author zahmad
 *
 */
@Path("/childreports")
public class ChildOverallReportResource{

	@GET
	@Path("/{aadharNo}/all")
	@Produces("application/json")
	@Consumes("application/json")
	public List<ChildOverallReportTo> getChildReports(@PathParam("aadharNo") String aadharNo) throws HibernateException, Exception{
		ChildOverallReportDao overallReportDao = ChildOverallReportDao.getInstance();
		ChildOverallReport childOverallReport = new ChildOverallReport();
		Child child = new Child();
		child.setAadharNo(aadharNo);
		childOverallReport.setChild(child);
		return overallReportDao.getOverallReport(childOverallReport );
	}
	
	@GET
	@Path("/{reportId}")
	@Produces("application/json")
	@Consumes("application/json")
	public ChildOverallReportTo getChildReportById(@PathParam("reportId") Long reportId) throws Exception{
		ChildOverallReportDao overallReportDao = ChildOverallReportDao.getInstance();
		ChildOverallReportTo childOverallReport = new ChildOverallReportTo();
		childOverallReport.setChildOverallReportId(reportId);
		
		List<ChildOverallReportTo> reportsList = overallReportDao.getOverallReport(childOverallReport.getChildOverallReport());
		if(reportsList==null || reportsList.size()==0) return null;
		return reportsList.get(0);
	}
	
	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createChildReport(ChildOverallReportTo childOverallReport) throws Exception {
		return saveReport(childOverallReport);
	}
	
	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateChildReport(ChildOverallReportTo childOverallReport) throws Exception {
		return saveReport(childOverallReport);
	}
	
	private StatusResponse saveReport(ChildOverallReportTo childOverallReportTo) throws Exception {
		StatusResponse response = new StatusResponse();
		ChildOverallReportDao childReportDao = ChildOverallReportDao.getInstance();
		childReportDao.saveChildAcademicReport(childOverallReportTo.getChildOverallReport());
		
		response.setSuccess(true);
		return response;
	}

}
