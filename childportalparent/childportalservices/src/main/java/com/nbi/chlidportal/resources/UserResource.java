/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.ArrayList;
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
import com.nbi.childportal.pojos.rest.UserTo;
import com.nbi.chlidportal.dao.UsersDao;

/**
 * @author zahmad
 *
 */
@Path("/user")
public class UserResource implements IUserResource{

	@GET
	@Path("/{userRole}/{userAadhar}")
	@Produces("application/json")
	@Consumes("application/json")
	public UserTo getUser(@PathParam("userAadhar") String userAadhar, @PathParam("userRole") RoleEnum userRole) throws Exception {
		UsersDao userDao = UsersDao.getInstance();
		UserTo user = new UserTo();
		user.setAadharNo(userAadhar);
		List<RoleEnum> userRoles = new ArrayList<RoleEnum>();
		userRoles.add(userRole);
		user.setUserRoles(userRoles);
		
		List<UserTo> userResult = userDao.getUser(user.getUser());
		if(userResult!=null){
			return userResult.get(0);
		}else{
			return null;
		}
	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createUser(UserTo user) throws Exception {
		return saveUser(user);
	}

	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateUser(UserTo user) throws Exception {
		return saveUser(user);
	}
	
	private StatusResponse saveUser(UserTo user) throws HibernateException, Exception {
		StatusResponse response = new StatusResponse();
		UsersDao userDao = UsersDao.getInstance();
		userDao.saveUser(user.getUser());
		
		response.setSuccess(true);
		return response;
	}
	
	@PUT
	@Path("/search")
	@Produces("application/json")
	@Consumes("application/json")
	public List<UserTo> searchUser(UserTo user) throws Exception {
		return UsersDao.getInstance().getUser(user.getUser());
	}

}
