/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.nbi.childportal.pojos.rest.ChildTo;
import com.nbi.childportal.pojos.rest.RoleTo;
import com.nbi.chlidportal.ngo.dao.ChildDao;

/**
 * @author zahmad
 *
 */
@Path("/child")
public class ChildResource{

	@GET
	@Path("/{userAadhar}")
	@Produces("application/json")
	@Consumes("application/json")
	public ChildTo getUser(@PathParam("userAadhar") String userAadhar) throws Exception {
		ChildDao childDao = ChildDao.getInstance();
		ChildTo child = new ChildTo();
		child.setAadharNo(userAadhar);
		RoleTo roleTo = new RoleTo();
		roleTo.setRole(RoleEnum.child.name());
		Set<RoleTo> userRoles = new HashSet<RoleTo>();
		userRoles.add(roleTo);
		child.setRoles(userRoles);
		
		List<ChildTo> childToList = childDao.getChild(child.getChild());
		if(childToList!=null && childToList.size()>0){
			return childToList.get(0);
		}else{
			return null;
		}
	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createChild(ChildTo child) throws Exception {
		return saveChild(child);
	}

	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateChild(ChildTo child) throws Exception {
		return saveChild(child);
	}
	
	private StatusResponse saveChild(ChildTo child) throws HibernateException, Exception {
		StatusResponse response = new StatusResponse();
		ChildDao childDao = ChildDao.getInstance();
		childDao.saveChild(child.getChild());
		
		response.setSuccess(true);
		return response;
	}
	
	@PUT
	@Path("/search")
	@Produces("application/json")
	@Consumes("application/json")
	public List<ChildTo> searchUser(ChildTo child) throws Exception {
		return ChildDao.getInstance().getChild(child.getChild());
	}

}
