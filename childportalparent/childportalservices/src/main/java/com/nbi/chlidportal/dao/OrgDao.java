/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nbi.childportal.pojos.Organization;

/**
 * @author zahmad
 *
 */
public class OrgDao {
	private static OrgDao singleton;

	private OrgDao(){

	}

	public static OrgDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new OrgDao();
		}
	}

	public void saveOrg(Organization org) throws HibernateException, Exception{
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(org);
		session.getTransaction().commit();
		session.close();
	}

	public List<Organization> getOrg(Organization org) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Organization.class);
		criteria = addCriteria(org, criteria);
		List<Organization> result = criteria.list();

		session.getTransaction().commit();
		session.close();

		return result;
	}

	private Criteria addCriteria(Organization org, Criteria criteria) {
		if(org.getOrgId()!=null){
			criteria.add(Restrictions.eq("orgId", org.getOrgId()));
		}
		if(org.getOrgType()!=null){
			criteria.add(Restrictions.eq("orgType", org.getOrgType()));
		}
		if(org.getState()!=null){
			criteria.add(Restrictions.eq("state", org.getState()));
		}
		if(org.getDistrict()!=null){
			criteria.add(Restrictions.eq("district", org.getDistrict()));
		}
		return criteria;
	}


}
