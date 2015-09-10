/**
 * 
 */
package com.nbi.childportal.pojos.ngo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import com.nbi.childportal.pojos.Child;

/**
 * @author zahmad
 *
 */
@Entity
@Table( name = "CHILD_SPONSORSHIP" )
public class ChildSponsorship implements Serializable {

	private static final long serialVersionUID = 8857656501457278759L;
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "CHILD_SPONSORSHIP_ID")
	private String childSponsorshipId;

	@ManyToOne(fetch=FetchType.LAZY, targetEntity = Child.class)	
	@JoinColumn(name="CHILD_ID", referencedColumnName="USER_ID")
	private Child child;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity = Sponsor.class)	
	@JoinColumn(name="SPONSOR_ID", referencedColumnName="USER_ID")
	private Sponsor sponsor;
	
	@OneToOne(fetch=FetchType.LAZY, targetEntity = PaymentDetail.class)	
	@JoinColumn(name="PAYMENT_DETAIL_ID", referencedColumnName="PAYMENT_DETAIL_ID")
	private PaymentDetail paymentDetail;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "START_DATE")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "LAPSE_DATE")
	private Date lapseDate;
	
	@Column(name = "AMOUNT_PAID")
	private Long amountPaid;
	
	@Column(name = "SPONSORSHIP_TYPE")
	private String sponsorshipType;
	
	@Column(name = "PAYMENT_CYCLE")
	private String sponsorshipPaymentCycle;
	
	@Column(name = "SPONSOR_NOTES")
	private String notesFromSponsor;

	
	public String getChildSponsorshipId() {
		return childSponsorshipId;
	}

	public void setChildSponsorshipId(String childSponsorshipId) {
		this.childSponsorshipId = childSponsorshipId;
	}
	
	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	public PaymentDetail getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(PaymentDetail paymentDetail) {
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

	public String getSponsorshipType() {
		return sponsorshipType;
	}

	public void setSponsorshipType(String sponsorshipType) {
		this.sponsorshipType = sponsorshipType;
	}

	public String getSponsorshipPaymentCycle() {
		return sponsorshipPaymentCycle;
	}

	public void setSponsorshipPaymentCycle(
			String sponsorshipPaymentCycle) {
		this.sponsorshipPaymentCycle = sponsorshipPaymentCycle;
	}

	public String getNotesFromSponsor() {
		return notesFromSponsor;
	}

	public void setNotesFromSponsor(String notesFromSponsor) {
		this.notesFromSponsor = notesFromSponsor;
	}
	
	
	
}
