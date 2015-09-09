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

import com.nbi.childportal.pojos.UserRole;
import com.nbi.childportal.pojos.rest.UserRoleTo;

/**
 * @author zahmad
 *
 */
public class UserRoleDao {
	private static UserRoleDao singleton;

	private UserRoleDao(){

	}

	public static UserRoleDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new UserRoleDao();
		}
	}

	public void saveUserRole(UserRole user) throws HibernateException, Exception{
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
	}

	public List<UserRoleTo> getUser(UserRole userRole) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(UserRole.class);
		addCriteria(userRole, criteria);
		List<UserRole> result = criteria.list();

		List<UserRoleTo> resultTo = new ArrayList<UserRoleTo>();
		if(result==null){
			return null;
		}else{
			Iterator<UserRole> iter = result.iterator();
			while(iter.hasNext()){
				UserRole orgResult = iter.next();
				resultTo.add(UserRoleTo.getUserRoleTo(orgResult));
			}
		}
		
		session.getTransaction().commit();
		session.close();

		return resultTo;
	}

	private Criteria addCriteria(UserRole user, Criteria criteria) {
		if(user.getRole()!=null){
			criteria.add(Restrictions.eq("role", user.getRole()));
		}
		if(user.getUser()!=null && user.getUser().getUserId()!=null){
			criteria.add(Restrictions.eq("user_id", user.getUser()));
		}
		return criteria;
	}


}
