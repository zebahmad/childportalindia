/**
 * 
 */
package com.nbi.chlidportal.resources;

import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.UserRole;

/**
 * @author zahmad
 *
 */
public interface IUserRoleResource {
	
	public UserRole getUserRole(String userAadhar) throws Exception;
	public StatusResponse createUserRole(UserRole userRole) throws Exception;
	public StatusResponse updateUserRole(UserRole userRole) throws Exception;

}
