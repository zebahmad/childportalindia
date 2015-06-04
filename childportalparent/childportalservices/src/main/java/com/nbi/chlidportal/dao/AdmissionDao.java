/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nbi.childportal.pojos.ChildAdmission;

/**
 * @author zahmad
 *
 */
public class AdmissionDao {
	
	private static AdmissionDao singleton;

	private AdmissionDao(){
		
	}
	
	public static AdmissionDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}
	
	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new AdmissionDao();
		}
	}

	public void saveChildAdmission(ChildAdmission childAdmission) throws HibernateException, Exception{
		childAdmission.setUpdatedOn(new Date());
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(childAdmission);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<ChildAdmission> getChildAdmission(ChildAdmission child) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(ChildAdmission.class);
		addCriteria(child, criteria);
		List<ChildAdmission> result = criteria.list();

		session.getTransaction().commit();
		session.close();
		
		return result;
	}

	private Criteria addCriteria(ChildAdmission child, Criteria criteria) {
		if(child.getAadharNo()!=null){
			criteria.add(Restrictions.eq("aadharNo", child.getAadharNo()));
		}
		return criteria;
	}
	
}
