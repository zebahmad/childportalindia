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

import com.nbi.childportal.pojos.School;
import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.chlidportal.dao.SchoolDao;

/**
 * @author zahmad
 *
 */
@Path("/school")
public class SchoolResource implements ISchoolResource {

	
	@GET
	@Path("/{schoolId}")
	@Produces("application/json")
	@Consumes("application/json")
	public School getSchool(@PathParam("schoolId") String schoolId) throws Exception {
		SchoolDao schoolDao = SchoolDao.getInstance();
		School school = new School();
		school.setSchoolId(schoolId);
		List<School> schoolResult = schoolDao.getSchool(school);
		if(schoolResult!=null && schoolResult.size()>0){
			return schoolResult.get(0);
		}
		return null;
	}

	@POST
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse createSchool(School school) throws Exception {
		return saveSchool(school);
	}

	@PUT
	@Path("/")
	@Produces("application/json")
	@Consumes("application/json")
	public StatusResponse updateSchool(School school) throws Exception {
		return saveSchool(school);
	}
	
	private StatusResponse saveSchool(School school) throws HibernateException, Exception {
		StatusResponse response = new StatusResponse();
		SchoolDao schoolDao = SchoolDao.getInstance();
		schoolDao.saveSchool(school);
		
		response.setSuccess(true);
		return response;
	}

	
}
