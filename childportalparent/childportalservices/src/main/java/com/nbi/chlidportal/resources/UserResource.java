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
import com.nbi.chlidportal.dao.UsersDao;

/**
 * @author zahmad
 *
 */
@Path("/user")
public class UserResource implements IUserResource{

	@GET
	@Path("/{userAadhar}")
	@Produces("application/json")
	@Consumes("application/json")
	public User getUser(@PathParam("userAadhar") String userAadhar) throws Exception {
		UsersDao userDao = UsersDao.getInstance();
		User user = new User();
		user.setAadharNo(userAadhar);
		List<User> userResult = userDao.getUser(user);
		if(userResult!=null && userResult.size()>0){
			return userResult.get(0);
		}
		return null;
	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createUser(User user) throws Exception {
		return saveUser(user);
	}

	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateUser(User user) throws Exception {
		return saveUser(user);
	}
	
	private StatusResponse saveUser(User user) throws HibernateException, Exception {
		StatusResponse response = new StatusResponse();
		UsersDao userDao = UsersDao.getInstance();
		userDao.saveUser(user);
		
		response.setSuccess(true);
		return response;
	}

}
