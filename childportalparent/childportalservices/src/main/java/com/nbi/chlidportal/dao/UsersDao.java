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

import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.rest.UserTo;

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

	public void saveUser(User user) throws HibernateException, Exception{//FIXME: Need to fix this. This needs to be an atomic transaction
		List<User> userList = loadUser(user);
		if(userList!=null && userList.size()>0){
			User loadedUser = userList.get(0);
			loadedUser.getRoles().clear();
		}

		Session session = HibernateSession.getSessionFactory().openSession();
		//user.getUserRole().clear();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
	}

	public List<UserTo> getUser(User user) throws HibernateException, Exception{
		List<UserTo> resultTo = new ArrayList<UserTo>();
		List<User> result = loadUser(user);

		if(result!=null){
			Iterator<User> iter = result.iterator();
			while(iter.hasNext()){
				User orgResult = iter.next();
				resultTo.add(UserTo.getUserTo(orgResult));
			}
		}

		return resultTo;
	}

	private List<User> loadUser(User user){
		Session session = null;
		try{
			session = HibernateSession.getSessionFactory().openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(User.class);
			addCriteria(user, criteria);
			List<User> result = criteria.list();

			return result;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.getTransaction().commit();
			session.close();
		}

		return null;
	}

	private void addCriteria(User user, Criteria criteria) {
		SearchCriteriaUtil.addUserCriteria(user, criteria);
	}

}
