/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nbi.childportal.pojos.Organization;
import com.nbi.childportal.pojos.rest.OrganizationTo;

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

	public List<OrganizationTo> getOrg(Organization org) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = null;
		List<OrganizationTo> resultTo = new ArrayList<OrganizationTo>();
		try{
			session = HibernateSession.getSessionFactory().openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Organization.class);
			criteria = addCriteria(org, criteria);
			List<Organization> result = criteria.list();
			
			if(result==null){
				return null;
			}else{
				
				Iterator<Organization> iter = result.iterator();
				while(iter.hasNext()){
					Organization orgResult = iter.next();
					resultTo.add(OrganizationTo.getOrgTo(orgResult));
				}
			}
		}finally{
			if(session!=null){
				session.getTransaction().commit();
				session.close();
			}
		}
		return resultTo;
	}

	private Criteria addCriteria(Organization org, Criteria criteria) {
		if(org.getOrgId()!=null){
			criteria.add(Restrictions.eq("orgId", org.getOrgId()));
		}
		if(org.getOrgType()!=null){
			criteria.add(Restrictions.eq("orgType", org.getOrgType()));
		}
		if(org.getOrgCode()!=null){
			criteria.add(Restrictions.eq("orgCode", org.getOrgCode()));
		}
		if(org.getOrgName()!=null){
			criteria.add(Restrictions.eq("orgName", org.getOrgName()));
		}
		if(org.getAddress()!=null){
			criteria.add(Restrictions.eq("address", org.getAddress()));
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
