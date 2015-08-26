/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.hibernate.HibernateException;

import com.nbi.childportal.pojos.Organization;
import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.rest.OrganizationTo;
import com.nbi.chlidportal.dao.OrgDao;

/**
 * @author zahmad
 *
 */
@Path("/org")
public class OrgResource implements IOrgResource {

	
	@GET
	@Path("/{orgId}")
	@Produces("application/json")
	@Consumes("application/json")
	public OrganizationTo getOrg(@PathParam("orgId") String orgId) throws Exception {
		OrganizationTo org = new OrganizationTo();
		org.setOrgId(Long.parseLong(orgId));
		List<OrganizationTo> orgResult = OrgDao.getInstance().getOrg(org.getOrg());
		if(orgResult!=null && orgResult.size()>0){
			return orgResult.get(0);
		}
		return null;
	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createOrg(OrganizationTo org) throws Exception {
		return saveOrg(org.getOrg());
	}

	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateOrg(OrganizationTo org) throws Exception {
		return saveOrg(org.getOrg());
	}
	
	@PUT
	@Path("/search")
	@Produces("application/json")
	@Consumes("application/json")
	public List<OrganizationTo> searchOrg(OrganizationTo org) throws Exception {
		return OrgDao.getInstance().getOrg(org.getOrg());
	}
	
	private StatusResponse saveOrg(Organization org) throws HibernateException, Exception {
		StatusResponse response = new StatusResponse();
		OrgDao orgDao = OrgDao.getInstance();
		orgDao.saveOrg(org);
		
		response.setSuccess(true);
		return response;
	}

	
}
