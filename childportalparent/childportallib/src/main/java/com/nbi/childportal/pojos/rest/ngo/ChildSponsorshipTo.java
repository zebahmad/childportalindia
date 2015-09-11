/**
 * 
 */
package com.nbi.childportal.pojos.rest.ngo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.nbi.childportal.pojos.TimeDateAdapter;
import com.nbi.childportal.pojos.ngo.ChildSponsorship;
import com.nbi.childportal.pojos.rest.BaseTo;
import com.nbi.childportal.pojos.rest.ChildTo;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="childSponsorship")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChildSponsorshipTo  extends BaseTo implements Serializable {

	private static final long serialVersionUID = 8857656501457278759L;
	
	private ChildTo child;
	private SponsorTo sponsor;
	private List<PaymentDetailTo> paymentDetail;
	@XmlJavaTypeAdapter(TimeDateAdapter.class)
	private Date startDate;
	@XmlJavaTypeAdapter(TimeDateAdapter.class)
	private Date lapseDate;
	private SponsorshipTypeEnum sponsorshipType;
	private SponsorshipPaymentCycleEnum sponsorshipPaymentCycle;
	private String notesFromSponsor;

	public ChildTo getChild() {
		return child;
	}

	public void setChild(ChildTo child) {
		this.child = child;
	}

	public SponsorTo getSponsor() {
		return sponsor;
	}

	public void setSponsor(SponsorTo sponsor) {
		this.sponsor = sponsor;
	}

	public List<PaymentDetailTo> getPaymentDetail() {
		return paymentDetail;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getLapseDate() {
		return lapseDate;
	}

	public void setLapseDate(Date lapseDate) {
		this.lapseDate = lapseDate;
	}

	public SponsorshipTypeEnum getSponsorshipType() {
		return sponsorshipType;
	}

	public void setSponsorshipType(SponsorshipTypeEnum sponsorshipType) {
		this.sponsorshipType = sponsorshipType;
	}

	public SponsorshipPaymentCycleEnum getSponsorshipPaymentCycle() {
		return sponsorshipPaymentCycle;
	}

	public void setSponsorshipPaymentCycle(
			SponsorshipPaymentCycleEnum sponsorshipPaymentCycle) {
		this.sponsorshipPaymentCycle = sponsorshipPaymentCycle;
	}

	public String getNotesFromSponsor() {
		return notesFromSponsor;
	}

	public void setNotesFromSponsor(String notesFromSponsor) {
		this.notesFromSponsor = notesFromSponsor;
	}
	
	
	public static ChildSponsorshipTo getChildSponsorshipTo(ChildSponsorship childSponsorship) throws Exception {
		ChildSponsorshipTo childSponsorshipTo = new ChildSponsorshipTo();
		childSponsorshipTo.setChild(ChildTo.getChildTo(childSponsorship.getChild()));
		childSponsorshipTo.setLapseDate(childSponsorship.getLapseDate());
		childSponsorshipTo.setNotesFromSponsor(childSponsorship.getNotesFromSponsor());
		
		childSponsorshipTo.getPaymentDetail().addAll(PaymentDetailTo.getPaymentDetailToSet(childSponsorship.getPaymentDetail()));
		
		return childSponsorshipTo;
	}

	public static List<ChildSponsorshipTo> getChildSponsorshipToList(List<ChildSponsorship> sponsorships) throws Exception {
		if(sponsorships==null || sponsorships.size()==0) return null;
		
		List<ChildSponsorshipTo> childSponsorships = new ArrayList<ChildSponsorshipTo>();
		Iterator<ChildSponsorship> iter = sponsorships.iterator();
		while(iter.hasNext()){
			childSponsorships.add(getChildSponsorshipTo(iter.next()));
		}
		return childSponsorships;
	}
	
}
