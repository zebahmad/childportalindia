/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.nbi.childportal.pojos.ChildAdmission;

/**
 * @author zahmad
 *
 */
public class ChildAdmissionDao {
	
	private static SessionFactory sessionFactory;
	private static ChildAdmissionDao singleton;

	private ChildAdmissionDao(){
		
	}
	
	public static ChildAdmissionDao getInstance() throws Exception{
		if(sessionFactory==null){
			setUp();
		}
		return singleton;
	}
	
	protected static synchronized void setUp() throws Exception {
	    // A SessionFactory is set up once for an application
		if(sessionFactory==null){
			 sessionFactory = new Configuration()
	            .configure() // configures settings from hibernate.cfg.xml
	            .buildSessionFactory();
		}
		if(singleton==null){
			singleton = new ChildAdmissionDao();
		}
	}

	public void saveChildAdmission(ChildAdmission childAdmission){
		childAdmission.setUpdatedOn(new Date());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(childAdmission);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<ChildAdmission> getChildAdmission(ChildAdmission child){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(ChildAdmission.class);
		criteria.add(Restrictions.eq("aadharNo", child.getAadharNo()));
		List<ChildAdmission> result = criteria.list();

		session.getTransaction().commit();
		session.close();
		
		return result;
	}
	
}
