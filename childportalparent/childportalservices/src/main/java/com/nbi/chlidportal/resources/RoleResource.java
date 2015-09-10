/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.hibernate.HibernateException;

import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.rest.RoleTo;
import com.nbi.chlidportal.dao.RoleDao;

/**
 * @author zahmad
 *
 */
@Path("/role")
public class RoleResource implements IRoleResource{

	@GET
	@Path("/{role}")
	@Produces("application/json")
	@Consumes("application/json")
	public RoleTo getRole(@PathParam("role") String role) throws Exception {
		RoleDao userRoleDao = RoleDao.getInstance();
		RoleTo userRole = new RoleTo();
		userRole.setRole(role);
		Set<RoleTo> userResult = userRoleDao.getUser(userRole.getRole());
		if(userResult!=null && userResult.size()>0){
			return userResult.iterator().next();
		}
		return null;
	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createRole(RoleTo userRole) throws Exception {
		return saveRole(userRole);
	}

	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateRole(RoleTo userRole) throws Exception {
		return saveRole(userRole);
	}
	
	private StatusResponse saveRole(RoleTo userRole) throws HibernateException, Exception {
		StatusResponse response = new StatusResponse();
		RoleDao userRoleDao = RoleDao.getInstance();
		userRoleDao.saveRole(userRole.getRole());
		
		response.setSuccess(true);
		return response;
	}

}
