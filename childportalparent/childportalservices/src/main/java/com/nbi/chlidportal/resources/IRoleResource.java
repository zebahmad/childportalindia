/**
 * 
 */
package com.nbi.chlidportal.resources;

import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.rest.RoleTo;

/**
 * @author zahmad
 *
 */
public interface IRoleResource {
	
	public RoleTo getRole(String role) throws Exception;
	public StatusResponse createRole(RoleTo userRole) throws Exception;
	public StatusResponse updateRole(RoleTo userRole) throws Exception;

}
