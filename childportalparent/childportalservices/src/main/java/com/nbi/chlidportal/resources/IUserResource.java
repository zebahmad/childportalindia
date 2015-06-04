/**
 * 
 */
package com.nbi.chlidportal.resources;

import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.User;

/**
 * @author zahmad
 *
 */
public interface IUserResource {
	
	public User getUser(String userAadhar) throws Exception;
	public StatusResponse createUser(User user) throws Exception;
	public StatusResponse updateUser(User user) throws Exception;

}
