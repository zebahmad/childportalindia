/**
 * 
 */
package com.nbi.chlidportal.resources;

import com.nbi.childportal.pojos.RoleEnum;
import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.rest.UserRoleTo;

/**
 * @author zahmad
 *
 */
public interface IUserRoleResource {
	
	public UserRoleTo getUserRole(RoleEnum userRoleEnum) throws Exception;
	public StatusResponse createUserRole(UserRoleTo userRole) throws Exception;
	public StatusResponse updateUserRole(UserRoleTo userRole) throws Exception;

}
