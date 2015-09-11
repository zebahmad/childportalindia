/**
 * 
 */
package com.nbi.childportal.pojos.rest.ngo;

import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.nbi.childportal.pojos.ngo.Sponsor;
import com.nbi.childportal.pojos.rest.UserTo;


/**
 * @author zahmad
 *
 */
@XmlRootElement(name="sponsor")
@XmlAccessorType(XmlAccessType.FIELD)
public class SponsorTo extends UserTo{	
	
	private static final long serialVersionUID = -1380744136871960028L;
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="sponsor")
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<ChildSponsorshipTo> sponsorships;

	public Set<ChildSponsorshipTo> getSponsorships() {
		return sponsorships;
	}

	public void setSponsorships(Set<ChildSponsorshipTo> sponsorships) {
		this.sponsorships = sponsorships;
	}
	
	public static SponsorTo getSponsorTo(Sponsor sponsor) throws Exception{
		SponsorTo sponsorTo = new SponsorTo();
		populateUserTo(sponsorTo, sponsor);
		sponsorTo.getSponsorships().addAll(ChildSponsorshipTo.getChildSponsorshipToList(sponsor.getSponsorships()));
		return sponsorTo;
	}
}
	
	