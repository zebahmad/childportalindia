/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nbi.childportal.pojos.UserRole;

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

	public List<UserRole> getUser(UserRole user) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(UserRole.class);
		addCriteria(user, criteria);
		List<UserRole> result = criteria.list();

		session.getTransaction().commit();
		session.close();

		return result;
	}

	private Criteria addCriteria(UserRole user, Criteria criteria) {
		if(user.getAadharNo()!=null){
			criteria.add(Restrictions.eq("aadharNo", user.getAadharNo()));
		}
		return criteria;
	}


}
