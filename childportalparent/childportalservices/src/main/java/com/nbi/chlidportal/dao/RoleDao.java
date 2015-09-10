/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nbi.childportal.pojos.Role;
import com.nbi.childportal.pojos.rest.RoleTo;

/**
 * @author zahmad
 *
 */
public class RoleDao {
	private static RoleDao singleton;

	private RoleDao(){

	}

	public static RoleDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new RoleDao();
		}
	}

	public void saveRole(Role role) throws HibernateException, Exception{
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(role);
		session.getTransaction().commit();
		session.close();
	}

	public Set<RoleTo> getUser(Role role) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(Role.class);
		addCriteria(role, criteria);
		List<Role> result = criteria.list();

		Set<RoleTo> resultTo = new HashSet<RoleTo>();
		if(result==null){
			return null;
		}else{
			Iterator<Role> iter = result.iterator();
			while(iter.hasNext()){
				Role orgResult = iter.next();
				resultTo.add(RoleTo.getRoleTo(orgResult));
			}
		}
		
		session.getTransaction().commit();
		session.close();

		return resultTo;
	}

	private Criteria addCriteria(Role user, Criteria criteria) {
		if(user!=null && user.getRole()!=null){
			criteria.add(Restrictions.eq("role", user.getRole()));
		}
		if(user!=null && user.getRoleId()!=null){
			criteria.add(Restrictions.eq("role_id", user.getRole()));
		}
		return criteria;
	}


}
