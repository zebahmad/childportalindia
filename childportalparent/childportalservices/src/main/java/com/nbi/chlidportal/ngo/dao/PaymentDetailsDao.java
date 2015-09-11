/**
 * 
 */
package com.nbi.chlidportal.ngo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import com.nbi.childportal.pojos.ngo.PaymentDetail;
import com.nbi.childportal.pojos.rest.ngo.PaymentDetailTo;
import com.nbi.chlidportal.dao.BaseDao;
import com.nbi.chlidportal.dao.SearchCriteriaUtil;

/**
 * @author zahmad
 *
 */
public class PaymentDetailsDao extends BaseDao<PaymentDetail, PaymentDetailTo>{
	private static PaymentDetailsDao singleton;
	private PaymentDetailsDao(){
	}
	public static PaymentDetailsDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new PaymentDetailsDao();
		}
	}

	public void savePaymentDetail(PaymentDetail paymentDetail) throws HibernateException, Exception{
		save(paymentDetail);
	}

	public List<PaymentDetailTo> getPaymentDetail(PaymentDetail paymentDetail) throws HibernateException, Exception{
		return getDbObject(paymentDetail);
	}
	
	
	@Override
	protected PaymentDetailTo getRestType(PaymentDetail paymentDetail) throws Exception {
		return PaymentDetailTo.getPaymentDetailTo(paymentDetail);
	}
	@Override
	protected void addCriteria(PaymentDetail paymentDetail, Criteria criteria) {
		SearchCriteriaUtil.addPaymentDetailCriteria(paymentDetail, criteria);
	}


}
