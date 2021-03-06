/**
 * 
 */
package com.nbi.chlidportal.resources;

import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.rest.UserTo;

/**
 * @author zahmad
 *
 */
public interface IUserResource {
	
	public UserTo getUser(String userAadhar, String role) throws Exception;
	public StatusResponse createUser(UserTo user) throws Exception;
	public StatusResponse updateUser(UserTo user) throws Exception;

}
