/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.hibernate.type.Type;

import com.nbi.childportal.pojos.ChildAdmission;
import com.nbi.childportal.pojos.reports.StatPoint;
import com.nbi.childportal.pojos.reports.Statistic;

/**
 * @author zahmad
 *
 */
public class AdmissionDao {
	
	private static AdmissionDao singleton;

	private AdmissionDao(){
		
	}
	
	public static AdmissionDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}
	
	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new AdmissionDao();
		}
	}

	public void saveChildAdmission(ChildAdmission childAdmission) throws HibernateException, Exception{
		childAdmission.setUpdatedOn(new Date());
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(childAdmission);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<ChildAdmission> getChildAdmission(ChildAdmission child) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(ChildAdmission.class);
		addCriteria(child, criteria);
		List<ChildAdmission> result = criteria.list();

		session.getTransaction().commit();
		session.close();
		
		return result;
	}
	
	public Statistic getChildAdmissionStats(ChildAdmission child) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(ChildAdmission.class, "admission");
		criteria.setProjection(
					Projections.projectionList()
						.add(Projections.sqlGroupProjection(
								"year(enrollment_date) as enrolledYear, month(enrollment_date) as enrolledMonth, count(*) as count", 
								"year(enrollment_date), month(enrollment_date)", 
								new String[]{"enrolledYear","enrolledMonth","count"}, 
								(org.hibernate.type.Type[]) new Type[]{IntegerType.INSTANCE, IntegerType.INSTANCE}))
						//.add(Projections.groupProperty("year(enrollment_date)"))
						//.add(Projections.groupProperty("month(enrollment_date)"))
						.add((Projections.rowCount()))
		);
		criteria = addCriteria(child, criteria);
		List<Object[]> result = criteria.list();
		Statistic stats = new Statistic();
		if(result!=null){
			Iterator<Object[]> iter = result.iterator();
			while(iter.hasNext()){
				StatPoint statPoint = new StatPoint();
				Object[] next = iter.next();
				statPoint.setYear((Integer)next[0]);
				statPoint.setMonth((Integer)next[1]);
				statPoint.setCount((Long)next[2]);
				stats.addStatPoint(statPoint);
			}
		}
		

		session.getTransaction().commit();
		session.close();
		
		return stats;
	}

	private Criteria addCriteria(ChildAdmission child, Criteria criteria) {
		if(child.getAadharNo()!=null){
			criteria.add(Restrictions.eq("aadharNo", child.getAadharNo()));
		}
		return criteria;
	}
	
}
