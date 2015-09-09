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

import com.nbi.childportal.pojos.ChildAdmission;
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

	public void saveUser(User user) throws HibernateException, Exception{
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
	}

	public List<UserTo> getUser(User user) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = null;
		List<UserTo> resultTo = new ArrayList<UserTo>();
		
		try{
			session = HibernateSession.getSessionFactory().openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(User.class);
			addCriteria(user, criteria);
			List<User> result = criteria.list();
			
			if(result==null){
				return null;
			}else{
				
				Iterator<User> iter = result.iterator();
				while(iter.hasNext()){
					User orgResult = iter.next();
					resultTo.add(UserTo.getUserTo(orgResult));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.getTransaction().commit();
			session.close();
		}

		return resultTo;
	}
	
	private Criteria addCriteria(User user, Criteria criteria) {
		if(user.getAadharNo()!=null){
			criteria.add(Restrictions.eq("aadharNo", user.getAadharNo()));
		}
		if(user.getUserId()!=null){
			criteria.add(Restrictions.eq("userId", user.getUserId()));
		}
		if(user.getAddress()!=null){
			criteria.add(Restrictions.eq("address", user.getAddress()));
		}
		if(user.getAdmission()!=null){
			Iterator<ChildAdmission> iter = user.getAdmission().iterator();
			while(iter.hasNext()){
				criteria.add(Restrictions.eq("admission", iter.next()));
			}
		}
		if(user.getName()!=null){
			criteria.add(Restrictions.eq("name", user.getName()));
		}
		if(user.getLocalName()!=null){
			criteria.add(Restrictions.eq("localName", user.getLocalName()));
		}
		if(user.getFatherName()!=null){
			criteria.add(Restrictions.eq("fatherName", user.getFatherName()));
		}
		if(user.getMotherName()!=null){
			criteria.add(Restrictions.eq("motherName", user.getMotherName()));
		}
		if(user.getGender()!=null){
			criteria.add(Restrictions.eq("gender", user.getGender()));
		}
		if(user.getDob()!=null){
			criteria.add(Restrictions.eq("dob", user.getDob()));
		}
		if(user.getDob_type()!=null){
			criteria.add(Restrictions.eq("dob_type", user.getDob_type()));
		}
		if(user.getMobile()!=null){
			criteria.add(Restrictions.eq("mobile", user.getMobile()));
		}
		if(user.getEmail()!=null){
			criteria.add(Restrictions.eq("email", user.getEmail()));
		}
		
		return criteria;
	}


}
