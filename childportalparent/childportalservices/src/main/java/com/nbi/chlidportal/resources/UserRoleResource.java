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

import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.UserRole;
import com.nbi.chlidportal.dao.UserRoleDao;
import com.nbi.chlidportal.dao.UsersDao;

/**
 * @author zahmad
 *
 */
@Path("/userRole")
public class UserRoleResource implements IUserRoleResource{

	@GET
	@Path("/{userAadhar}")
	@Produces("application/json")
	@Consumes("application/json")
	public UserRole getUserRole(@PathParam("userAadhar") String userAadhar) throws Exception {
		UserRoleDao userRoleDao = UserRoleDao.getInstance();
		UserRole user = new UserRole();
		user.setAadharNo(userAadhar);
		List<UserRole> userResult = userRoleDao.getUser(user);
		if(userResult!=null && userResult.size()>0){
			return userResult.get(0);
		}
		return null;
	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createUserRole(UserRole userRole) throws Exception {
		return saveUserRole(userRole);
	}

	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateUserRole(UserRole userRole) throws Exception {
		return saveUserRole(userRole);
	}
	
	private StatusResponse saveUserRole(UserRole userRole) throws HibernateException, Exception {
		StatusResponse response = new StatusResponse();
		UserRoleDao userRoleDao = UserRoleDao.getInstance();
		userRoleDao.saveUserRole(userRole);
		
		response.setSuccess(true);
		return response;
	}

}
