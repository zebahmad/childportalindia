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

import com.nbi.childportal.pojos.RoleEnum;
import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.rest.UserRoleTo;
import com.nbi.chlidportal.dao.UserRoleDao;

/**
 * @author zahmad
 *
 */
@Path("/userRole")
public class UserRoleResource implements IUserRoleResource{

	@GET
	@Path("/{userRole}")
	@Produces("application/json")
	@Consumes("application/json")
	public UserRoleTo getUserRole(@PathParam("userRole") RoleEnum userRoleEnum) throws Exception {
		UserRoleDao userRoleDao = UserRoleDao.getInstance();
		UserRoleTo userRole = new UserRoleTo();
		userRole.setRole(userRoleEnum.name());
		List<UserRoleTo> userResult = userRoleDao.getUser(userRole.getUserRole());
		if(userResult!=null && userResult.size()>0){
			return userResult.get(0);
		}
		return null;
	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createUserRole(UserRoleTo userRole) throws Exception {
		return saveUserRole(userRole);
	}

	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateUserRole(UserRoleTo userRole) throws Exception {
		return saveUserRole(userRole);
	}
	
	private StatusResponse saveUserRole(UserRoleTo userRole) throws HibernateException, Exception {
		StatusResponse response = new StatusResponse();
		UserRoleDao userRoleDao = UserRoleDao.getInstance();
		userRoleDao.saveUserRole(userRole.getUserRole());
		
		response.setSuccess(true);
		return response;
	}

}
