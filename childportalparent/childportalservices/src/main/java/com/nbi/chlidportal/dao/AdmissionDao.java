/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;

import com.nbi.childportal.pojos.ChildAdmission;
import com.nbi.childportal.pojos.EnrollmentReport;
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
	
	public Statistic getEnrollmentStats(EnrollmentReport child) throws Exception{
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		
		StringBuilder whereClause = new StringBuilder("");
		addWhereClause(whereClause, "district", child.getDistrict());
		addWhereClause(whereClause, "state", child.getState());
		addWhereClause(whereClause, "enrolled_by", child.getEnrolledBy());
		
		SQLQuery sqlQuery = session.createSQLQuery(
				"SELECT year, month, count(*) as count"
				+ " FROM report_enrollment "
				+ whereClause
				+ " group by year, month");	
		sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		sqlQuery.addScalar("year", IntegerType.INSTANCE).addScalar("month", IntegerType.INSTANCE).addScalar("count", LongType.INSTANCE);
		
		List data = sqlQuery.list();
		Statistic stat = new Statistic();
		for(Object object : data)
        {
        	Map row = (Map)object;
        	StatPoint statPoint = new StatPoint();
        	if(row.get("year")!=null && row.get("month")!=null){
        		statPoint.setYear((Integer)row.get("year"));
        		statPoint.setMonth((Integer)row.get("month"));
        		statPoint.setCount((Long)row.get("count"));
        		stat.addStatPoint(statPoint);
        	}
        }
		
		session.getTransaction().commit();
		session.close();
		
		return stat;
	}
	
	private void addWhereClause(StringBuilder whereClause, String key, String value) {
		if(value!=null && !"".equalsIgnoreCase(value)){
			if(whereClause.length()>0){
				whereClause.append("and "+key+"='" + value+"'");
			}else{
				whereClause.append("where "+key+"='" + value+"'");				
			}
			
		}
	}

	private Criteria addCriteria(ChildAdmission child, Criteria criteria) {
		if(child.getAadharNo()!=null){
			criteria.add(Restrictions.eq("aadharNo", child.getAadharNo()));
		}
		return criteria;
	}
	
}
