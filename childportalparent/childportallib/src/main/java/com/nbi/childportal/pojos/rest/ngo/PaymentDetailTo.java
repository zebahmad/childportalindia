/**
 * 
 */
package com.nbi.childportal.pojos.rest.ngo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.nbi.childportal.pojos.rest.BaseTo;

/**
 * @author zahmad
 *
 */
@XmlRootElement(name="paymentDetail")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentDetailTo  extends BaseTo implements Serializable {
	
	private static final long serialVersionUID = -967800094748102224L;

	@Temporal(TemporalType.DATE)
	@Column(name = "DOP")
	private Date dateOfPayment;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "AMOUNT_PAID")
	private String amountPaid;
	
	@Column(name = "REF")
	private String paymentRef;
	
	@Column(name = "RECEIPT")
	private byte[] receipt;

	@OneToOne(fetch=FetchType.LAZY, mappedBy="paymentDetail")
	private ChildSponsorshipTo paymentFor;
	
	public Date getDateOfPayment() {
		return dateOfPayment;
	}
	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	public String getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getPaymentRef() {
		return paymentRef;
	}
	public void setPaymentRef(String paymentRef) {
		this.paymentRef = paymentRef;
	}
	public byte[] getReceipt() {
		return receipt;
	}
	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}
	public ChildSponsorshipTo getPaymentFor() {
		return paymentFor;
	}
	public void setPaymentFor(ChildSponsorshipTo paymentFor) {
		this.paymentFor = paymentFor;
	}

	
}
