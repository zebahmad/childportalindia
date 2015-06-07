/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;

import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.reports.StatPoint;
import com.nbi.childportal.pojos.reports.Statistic;

/**
 * @author zahmad
 *
 */
public class DropoutsDao {
	
	private static DropoutsDao singleton;

	private DropoutsDao(){
		
	}
	
	public static DropoutsDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}
	
	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new DropoutsDao();
		}
	}

	public Statistic getDropoutStats(String districtName, String state) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		
		StringBuilder andClause = new StringBuilder("");
		addAndClause(andClause, "outOfSchoolChild.district", districtName);
		addAndClause(andClause, "outOfSchoolChild.state", state);
		
		SQLQuery sqlQuery = session.createSQLQuery(
				"select"
						+" stats.yearValue as year,"
						+" stats.monthValue as month,"
						+" count(*) as count"
					+" from person outOfSchoolChild, stat_date_keys stats"
					+" WHERE YEAR(outOfSchoolChild.dob)+5<=stats.yearValue"
					+" AND outOfSchoolChild.aadhar_no not in"
					+" ("
						+" select enrolledChild.aadhar_no"
						+" from report_enrollment enrolledChild"
						+" where enrolledChild.aadhar_no = outOfSchoolChild.aadhar_no"
						+" and enrolledChild.year = year"
						+" and enrolledChild.month = month"
					+" )"
					+andClause
					+" group by stats.yearValue, stats.monthValue");

		sqlQuery.addScalar("year", IntegerType.INSTANCE).addScalar("month", IntegerType.INSTANCE).addScalar("count", LongType.INSTANCE);
		sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		
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
	
	private void addAndClause(StringBuilder whereClause, String key, String value) {
		if(value!=null && !"".equalsIgnoreCase(value)){
				whereClause.append("and "+key+"='" + value+"'");
		}
	}

	public List<User> getDropoutList(String districtName, String state, String schoolingYear) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		
		StringBuilder whereClause = new StringBuilder("");
		if(districtName!=null && !"".equalsIgnoreCase(districtName)){
			whereClause.append("and droppedOutChildren.district = '").append(districtName).append("'");
		}
		if(state!=null && !"".equalsIgnoreCase(state)){
			whereClause.append("and droppedOutChildren.state = '").append(state).append("'");
		}
		
		SQLQuery sqlQuery = session.createSQLQuery(
				"select * from person droppedOutChildren"
				+ " where droppedOutChildren.aadhar_no not in"
						+ " (SELECT childEnrolled.aadhar_no"
						+ " FROM person allChildren, admission childEnrolled"
						+ " where allChildren.aadhar_no = childEnrolled.aadhar_no"
				+ " and year(childEnrolled.enrollment_date) = "+schoolingYear+")"
				+whereClause
			);

		sqlQuery.addEntity(User.class);
        List<User> droppedOutChildren = sqlQuery.list();

		
		session.getTransaction().commit();
		session.close();
		
		return droppedOutChildren;
	}
}
