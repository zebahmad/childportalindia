/**
 * 
 */
package com.nbi.childportal.pojos;

/**
 * @author zahmad
 *
 */
public enum RoleEnum {

	//Role ids are mapped based on the index number of the enum. 
	//So do not change the enum order. Add any new enums at the end
	child, //a child has no rights on the site
	school_admin,
	ngo,
	social_auditor,
	super_admin,
	registered_user //We will enable features for registered users to browse child case histories and choose sponsorship schemes

}

