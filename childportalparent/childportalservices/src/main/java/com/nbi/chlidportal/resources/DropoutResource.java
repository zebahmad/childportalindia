/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.reports.GroupingFilter;
import com.nbi.childportal.pojos.reports.StatType;
import com.nbi.childportal.pojos.reports.Statistic;
import com.nbi.chlidportal.dao.DropoutsDao;

/**
 * @author zahmad
 *
 */
@Path("/dropouts")
public class DropoutResource implements IDropoutsResource {

	
	@PUT
	@Path("/stats/{groupingFilter}/{statType}")
	@Produces("application/json")
	@Consumes("application/json")
	public Map<String, Statistic> getDropoutStats(@PathParam("groupingFilter") GroupingFilter groupingFilter,@PathParam("statType") StatType statType) 
				throws Exception {
		return DropoutsDao.getInstance().getDropoutStats(groupingFilter, statType);
	}

	
	@PUT
	@Path("/list/{schoolingYear}/state/{state}")
	@Produces("application/json")
	@Consumes("application/json")
	public List<User> getStateDropoutList(@PathParam("state")String state, @PathParam("schoolingYear")String schoolingYear) throws Exception {
		return DropoutsDao.getInstance().getDropoutList(null, state, schoolingYear);
	}
	
	@PUT
	@Path("/list/{schoolingYear}/district/{districtName}")
	@Produces("application/json")
	@Consumes("application/json")
	public List<User> getDistrictDropoutList(@PathParam("districtName")String districtName, @PathParam("schoolingYear")String schoolingYear) throws Exception {
		return DropoutsDao.getInstance().getDropoutList(districtName, null, schoolingYear);
	}

}
