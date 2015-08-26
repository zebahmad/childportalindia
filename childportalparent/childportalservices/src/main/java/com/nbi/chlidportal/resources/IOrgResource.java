/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.List;

import com.nbi.childportal.pojos.StatusResponse;
import com.nbi.childportal.pojos.rest.OrganizationTo;

/**
 * @author zahmad
 *
 */
public interface IOrgResource {
	
	public OrganizationTo getOrg(String orgId) throws Exception;
	public StatusResponse createOrg(OrganizationTo org) throws Exception;
	public StatusResponse updateOrg(OrganizationTo org) throws Exception;
	public List<OrganizationTo> searchOrg(OrganizationTo org) throws Exception;

}
