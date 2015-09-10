/**
 * 
 */
package com.nbi.childportal.pojos;

import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.nbi.childportal.pojos.ngo.ChildAcademicReport;
import com.nbi.childportal.pojos.ngo.ChildHealthReport;
import com.nbi.childportal.pojos.ngo.ChildSponsorship;


/**
 * @author zahmad
 *
 */

public class Child extends User{	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="child")
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<ChildAdmission> admission;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="child")
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<ChildAcademicReport> academicReports;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="child")
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<ChildHealthReport> healthReports;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="child")
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<ChildSponsorship> sponsorships;
}
	
	