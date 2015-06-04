/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.nbi.childportal.pojos.School;

/**
 * @author zahmad
 *
 */
public class SchoolDao {
	private static SchoolDao singleton;

	private SchoolDao(){

	}

	public static SchoolDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new SchoolDao();
		}
	}

	public void saveSchool(School school) throws HibernateException, Exception{
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(school);
		session.getTransaction().commit();
		session.close();
	}

	public List<School> getSchool(School school) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(School.class);
		addCriteria(school, criteria);
		List<School> result = criteria.list();

		session.getTransaction().commit();
		session.close();

		return result;
	}

	private Criteria addCriteria(School school, Criteria criteria) {
		if(school.getSchoolId()!=null){
			criteria.add(Restrictions.eq("schoolId", school.getSchoolId()));
		}
		return criteria;
	}


}
