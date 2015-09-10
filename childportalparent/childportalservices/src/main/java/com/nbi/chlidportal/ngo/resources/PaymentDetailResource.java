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
import com.nbi.childportal.pojos.rest.ngo.PaymentDetailTo;


/**
 * @author zahmad
 *
 */
@Path("/payments")
public class PaymentDetailResource{
	
	@GET
	@Path("/{sponsorshipId}/all")
	@Produces("application/json")
	@Consumes("application/json")
	public List<PaymentDetailTo> getChildSponsorships(@PathParam("sponsorshipId") String sponsorshipId){
		return null;
	}
	
	@GET
	@Path("/{paymentId}")
	@Produces("application/json")
	@Consumes("application/json")
	public PaymentDetailTo getChildSponsorshipById(@PathParam("paymentId") String paymentId){
		return null;
	}
	
	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createChildReport(PaymentDetailTo paymentDetail) {
		return null;
	}
	
	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateChildReport(PaymentDetailTo paymentDetail) {
		return null;
	}

}
