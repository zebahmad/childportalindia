/**
 * 
 */
package com.nbi.childportal.pojos.rest.ngo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.nbi.childportal.pojos.TimeDateAdapter;
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
	private PaymentDetailTo paymentDetail;
	@XmlJavaTypeAdapter(TimeDateAdapter.class)
	private Date startDate;
	@XmlJavaTypeAdapter(TimeDateAdapter.class)
	private Date lapseDate;
	private Long amountPaid;
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

	public PaymentDetailTo getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetailTo paymentDetail) {
		this.paymentDetail = paymentDetail;
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

	public Long getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Long amountPaid) {
		this.amountPaid = amountPaid;
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
	
	
	
}
