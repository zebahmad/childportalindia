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

import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.rest.ngo.ChildOverallReportTo;


/**
 * @author zahmad
 *
 */
@Path("/childreports")
public class ChildReportResource{

	@GET
	@Path("/{aadharNo}/all")
	@Produces("application/json")
	@Consumes("application/json")
	public List<ChildOverallReportTo> getChildReports(@PathParam("aadharNo") String aadharNo){
		return null;
	}
	
	@GET
	@Path("/{reportId}")
	@Produces("application/json")
	@Consumes("application/json")
	public ChildOverallReportTo getChildReportById(@PathParam("reportId") String reportId){
		return null;
	}
	
	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createChildReport(ChildOverallReportTo childOverallReport) {
		return null;
	}
	
	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateChildReport(ChildOverallReportTo childOverallReport) {
		return null;
	}

}
