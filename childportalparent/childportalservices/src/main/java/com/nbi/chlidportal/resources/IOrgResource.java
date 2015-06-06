/**
 * 
 */
package com.nbi.chlidportal.resources;

import java.util.List;

import com.nbi.childportal.pojos.Organization;
import com.nbi.childportal.pojos.StatusResponse;

/**
 * @author zahmad
 *
 */
public interface IOrgResource {
	
	public Organization getOrg(String orgId) throws Exception;
	public StatusResponse createOrg(Organization org) throws Exception;
	public StatusResponse updateOrg(Organization org) throws Exception;
	public List<Organization> searchOrg(Organization org) throws Exception;

}
