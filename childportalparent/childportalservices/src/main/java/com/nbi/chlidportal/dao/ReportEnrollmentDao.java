/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;

import com.nbi.childportal.pojos.EnrollmentReport;
import com.nbi.childportal.pojos.reports.StatPoint;
import com.nbi.childportal.pojos.reports.Statistic;

/**
 * @author zahmad
 *
 */
public class ReportEnrollmentDao {
	
	private static ReportEnrollmentDao singleton;

	private ReportEnrollmentDao(){
		
	}
	
	public static ReportEnrollmentDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}
	
	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new ReportEnrollmentDao();
		}
	}

	public void saveEnrollmentReport(EnrollmentReport childAdmission) throws HibernateException, Exception{
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(childAdmission);
		session.getTransaction().commit();
		session.close();
	}
	
	public void saveEnrollmentReports(List<EnrollmentReport> childAdmission) throws HibernateException, Exception{
		if(childAdmission==null || childAdmission.size()==0) return;
		
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		Iterator<EnrollmentReport> iter = childAdmission.iterator();
		while(iter.hasNext()){
			EnrollmentReport next = iter.next();
			session.saveOrUpdate(next);
			session.flush();
			session.clear();
		}
		session.getTransaction().commit();
		session.close();
	}
	
	public List<EnrollmentReport> getEnrollmentReport(EnrollmentReport child) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(EnrollmentReport.class);
		addCriteria(child, criteria);
		List<EnrollmentReport> result = criteria.list();

		session.getTransaction().commit();
		session.close();
		
		return result;
	}
	
	private Criteria addCriteria(EnrollmentReport child, Criteria criteria) {
		if(child.getAadharNo()!=null){
			criteria.add(Restrictions.eq("aadharNo", child.getAadharNo()));
		}
		if(child.getDistrict()!=null){
			criteria.add(Restrictions.eq("district", child.getDistrict()));
		}
		if(child.getState()!=null){
			criteria.add(Restrictions.eq("state", child.getState()));
		}
		return criteria;
	}
	
}
