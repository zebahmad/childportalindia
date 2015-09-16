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
import com.nbi.childportal.pojos.ngo.Sponsor;
import com.nbi.childportal.pojos.rest.ngo.ChildSponsorshipTo;
import com.nbi.childportal.pojos.rest.ngo.SponsorTo;
import com.nbi.chlidportal.ngo.dao.SponsorDao;


/**
 * @author zahmad
 *
 */
@Path("/sponsor")
public class SponsorResource{
	
	@GET
	@Path("/aadharNo}")
	@Produces("application/json")
	@Consumes("application/json")
	public List<ChildSponsorshipTo> getSponsor(@PathParam("aadharNo") String aadharNoOfSponsor){
		SponsorDao sponsorDao = SponsorDao.getInstance();
		SponsorTo sponsor = new SponsorTo();
		sponsor.setAadharNo(aadharNoOfSponsor);
		sponsorDao.getSponsor(sponsor.getSponsor());
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
