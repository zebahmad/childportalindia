/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nbi.childportal.pojos.User;

/**
 * @author zahmad
 *
 */
public class UsersDao {
	private static UsersDao singleton;

	private UsersDao(){

	}

	public static UsersDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new UsersDao();
		}
	}

	public void saveUser(User user) throws HibernateException, Exception{
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
	}

	public List<User> getUser(User user) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(User.class);
		addCriteria(user, criteria);
		List<User> result = criteria.list();

		session.getTransaction().commit();
		session.close();

		return result;
	}

	private Criteria addCriteria(User user, Criteria criteria) {
		if(user.getAadharNo()!=null){
			criteria.add(Restrictions.eq("aadharNo", user.getAadharNo()));
		}
		return criteria;
	}


}
