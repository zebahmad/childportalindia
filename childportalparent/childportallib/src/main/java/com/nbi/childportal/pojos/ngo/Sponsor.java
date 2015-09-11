/**
 * 
 */
package com.nbi.childportal.pojos.ngo;

import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.nbi.childportal.pojos.User;


/**
 * @author zahmad
 *
 */

public class Sponsor extends User{	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sponsor")
	@NotFound(action=NotFoundAction.IGNORE)
	private List<ChildSponsorship> sponsorships;

	public List<ChildSponsorship> getSponsorships() {
		return sponsorships;
	}
	
}
	
	