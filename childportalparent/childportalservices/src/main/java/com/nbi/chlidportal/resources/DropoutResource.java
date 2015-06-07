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

import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.reports.StatType;
import com.nbi.childportal.pojos.reports.Statistic;
import com.nbi.chlidportal.dao.DropoutsDao;

/**
 * @author zahmad
 *
 */
@Path("/dropouts")
public class DropoutResource implements IDropoutsResource {

	@GET
	@Path("/stats/{statType}")
	@Produces("application/json")
	@Consumes("application/json")
	public Statistic getNationWideDropoutStats(@PathParam("statType") StatType statType) 
				throws Exception {
		return DropoutsDao.getInstance().getDropoutStats(null,null);
	}
	
	@GET
	@Path("/stats/state/{state}/{statType}")
	@Produces("application/json")
	@Consumes("application/json")
	public Statistic getStateDropoutStats(@PathParam("state") String state,@PathParam("statType") StatType statType) 
				throws Exception {
		return DropoutsDao.getInstance().getDropoutStats(null,state);
	}
	
	@GET
	@Path("/stats/state/{state}/district/{district}/{statType}")
	@Produces("application/json")
	@Consumes("application/json")
	public Statistic getDistrictDropoutStats(@PathParam("state")String state, @PathParam("district") String district,@PathParam("statType") StatType statType) 
				throws Exception {
		return DropoutsDao.getInstance().getDropoutStats(district,state);
	}

	
	@GET
	@Path("/list/{schoolingYear}/state/{state}")
	@Produces("application/json")
	@Consumes("application/json")
	public List<User> getStateDropoutList(@PathParam("state")String state, @PathParam("schoolingYear")String schoolingYear) throws Exception {
		return DropoutsDao.getInstance().getDropoutList(null, state, schoolingYear);
	}
	
	@GET
	@Path("/list/{schoolingYear}/state/{state}/district/{districtName}")
	@Produces("application/json")
	@Consumes("application/json")
	public List<User> getDistrictDropoutList(@PathParam("state")String state, @PathParam("districtName")String districtName, @PathParam("schoolingYear")String schoolingYear) throws Exception {
		return DropoutsDao.getInstance().getDropoutList(districtName, null, schoolingYear);
	}

}
