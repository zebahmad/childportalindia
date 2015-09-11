/**
 * 
 */
package com.nbi.childportal.pojos.ngo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author zahmad
 *
 */
@Entity
@Table( name = "PAYMENT_DETAIL" )
public class PaymentDetail {
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "PAYMENT_DETAIL_ID")
	private String paymentDetailId;

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

	@ManyToOne(targetEntity = ChildSponsorship.class, fetch=FetchType.LAZY)
	private ChildSponsorship paymentFor;
	
	
	public String getPaymentDetailId() {
		return paymentDetailId;
	}
	public void setPaymentDetailId(String paymentDetailId) {
		this.paymentDetailId = paymentDetailId;
	}
	
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
	public ChildSponsorship getPaymentFor() {
		return paymentFor;
	}
	public void setPaymentFor(ChildSponsorship paymentFor) {
		this.paymentFor = paymentFor;
	}
	
}
