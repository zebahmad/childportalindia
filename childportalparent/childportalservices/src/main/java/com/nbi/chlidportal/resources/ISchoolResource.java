/**
 * 
 */
package com.nbi.chlidportal.resources;

import com.nbi.childportal.pojos.School;
import com.nbi.childportal.pojos.StatusResponse;

/**
 * @author zahmad
 *
 */
public interface ISchoolResource {
	
	public School getSchool(String schoolId) throws Exception;
	public StatusResponse createSchool(School school) throws Exception;
	public StatusResponse updateSchool(School school) throws Exception;

}
