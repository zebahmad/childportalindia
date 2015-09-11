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
import com.nbi.childportal.pojos.rest.ngo.ChildSponsorshipTo;


/**
 * @author zahmad
 *
 */
@Path("/childsponsorships")
public class ChildSponsorshipsResource{
	
	@GET
	@Path("/sponsor/{aadharNo}/all")
	@Produces("application/json")
	@Consumes("application/json")
	public List<ChildSponsorshipTo> getChildSponsorshipsBySponsor(@PathParam("aadharNo") String aadharNoOfSponsor){
		return null;
	}
	
	@GET
	@Path("/child/{aadharNo}/all")
	@Produces("application/json")
	@Consumes("application/json")
	public List<ChildSponsorshipTo> getChildSponsorshipsByChild(@PathParam("aadharNo") String aadharNoOfChild){
		return null;
	}
	
	@GET
	@Path("/{sponsorshipId}")
	@Produces("application/json")
	@Consumes("application/json")
	public ChildSponsorshipTo getChildSponsorshipById(@PathParam("sponsorship") String sponsorshipId){
		return null;
	}
	
	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createChildReport(ChildSponsorshipTo childSponsorship) {
		return null;
	}
	
	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateChildReport(ChildSponsorshipTo childSponsorship) {
		return null;
	}

}
