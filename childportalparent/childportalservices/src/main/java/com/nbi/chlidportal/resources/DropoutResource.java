/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.reports.StatType;
import com.nbi.childportal.pojos.reports.Statistic;
import com.nbi.chlidportal.dao.DropoutsDao;

/**
 * @author zahmad
 * THIS CODE IS NOT TESTED & MAY NOT WORK. THIS FEATURE IS ON HOLD FOR NOW
 *
 */
@Deprecated
@Path("/dropouts")
public class DropoutResource implements IDropoutsResource {

	@GET
	@Path("/stats")
	@Produces("application/json")
	@Consumes("application/json")
	public Statistic getNationWideDropoutStats(@QueryParam("statType") StatType statType) 
				throws Exception {
		return DropoutsDao.getInstance().getDropoutStats(null,null);
	}
	
	@GET
	@Path("/stats/{state}")
	@Produces("application/json")
	@Consumes("application/json")
	public Statistic getStateDropoutStats(@PathParam("state") String state,@QueryParam("statType") StatType statType) 
				throws Exception {
		return DropoutsDao.getInstance().getDropoutStats(null,state);
	}
	
	@GET
	@Path("/stats/{state}/{district}")
	@Produces("application/json")
	@Consumes("application/json")
	public Statistic getDistrictDropoutStats(@PathParam("state")String state, @PathParam("district") String district,
			@QueryParam("statType") StatType statType) 
				throws Exception {
		return DropoutsDao.getInstance().getDropoutStats(district,state);
	}

	
	@GET
	@Path("/list/{schoolingYear}/{state}")
	@Produces("application/json")
	@Consumes("application/json")
	public List<User> getStateDropoutList(@PathParam("state")String state, @PathParam("schoolingYear")String schoolingYear) throws Exception {
		return DropoutsDao.getInstance().getDropoutList(null, state, schoolingYear);
	}
	
	@GET
	@Path("/list/{schoolingYear}/{state}/{districtName}")
	@Produces("application/json")
	@Consumes("application/json")
	public List<User> getDistrictDropoutList(@PathParam("state")String state, @PathParam("districtName")String districtName, @PathParam("schoolingYear")String schoolingYear) throws Exception {
		return DropoutsDao.getInstance().getDropoutList(districtName, null, schoolingYear);
	}

}
