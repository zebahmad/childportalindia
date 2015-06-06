/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;

import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.reports.GroupingFilter;
import com.nbi.childportal.pojos.reports.StatPoint;
import com.nbi.childportal.pojos.reports.StatType;
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

	public Map<String, Statistic> getDropoutStats(GroupingFilter groupingFilter,StatType statType) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		
		SQLQuery sqlQuery = session.createSQLQuery(
				/*"select "
						+ "outOfSchoolChild.state as state," 
						+ "outOfSchoolChild.district as district,"
						+ "count(*) as count"
				+ " where outOfSchoolChild.aadhar_no not in" 
				+ " (select child.aadhar_no from person child, admission enrolledChild"
				+ "where child.aadhar_no = enrolledChild.aadhar_no)"
				+ " group by outOfSchoolChild.state, outOfSchoolChild.district");*/
				
				"select"
				 	+ " stats.yearValue as statYear,"
				 	+ " stats.monthValue as statMonth,"
				 	+ " outOfSchoolChild.state as state," 
				 	+ " outOfSchoolChild.district as district,"
				 	+ " count(*) as count"
				 + " from person outOfSchoolChild, stat_date_keys stats"
				 + " where concat(outOfSchoolChild.aadhar_no, '_'+stats.monthValue+'_'+stats.yearValue)" 
				 	+ " not in"
				 	+ " (select concat("
				 					+ " child.aadhar_no, '_'," 
				 					+ " month(enrolledChild.enrollment_date), '_'," 
				 					+ " year(enrolledChild.enrollment_date)"
				 					+ " )"
				 		+ " from person child, admission enrolledChild"
				 		+ " where child.aadhar_no = enrolledChild.aadhar_no"
				 		+ " group by enrolledChild.enrollment_date, year(enrolledChild.enrollment_date)"
				 		+ " )"
				 + " AND YEAR(outOfSchoolChild.dob)+5<=stats.yearValue"
				 + " group by outOfSchoolChild.state, outOfSchoolChild.district, concat(outOfSchoolChild.aadhar_no, '_'+stats.monthValue+'_'+stats.yearValue)" 
				 + " order by statYear, statMonth desc");

		sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List data = sqlQuery.addScalar("statYear", IntegerType.INSTANCE).addScalar("statMonth", IntegerType.INSTANCE).addScalar("count", LongType.INSTANCE).list();

        Map<String, Statistic> districtStats = new HashMap<String, Statistic>();
        Map<String, Statistic> stateStats = new HashMap<String, Statistic>();
        Map<String, Statistic> totalStats = new HashMap<String, Statistic>();
        for(Object object : data)
        {
        	Map row = (Map)object;
        	StatPoint statPoint = new StatPoint();
        	if(row.get("statYear")!=null && row.get("statMonth")!=null){
        		statPoint.setYear((Integer)row.get("statYear"));
        		statPoint.setMonth((Integer)row.get("statMonth"));
        		statPoint.setCount((Long)row.get("count"));
        	}
			
			Statistic statistic = null;
			switch(groupingFilter){
			case district:
				statistic = districtStats.get(row.get("district"));
				if(statistic==null){
					statistic = new Statistic();
				}
				statistic.addStatPoint(statPoint);
				districtStats.put("district", statistic);
				break;
			case state:
				statistic = stateStats.get(row.get("state"));
				if(statistic==null){
					statistic = new Statistic();
				}
				statistic.addStatPoint(statPoint);
				stateStats.put("state", statistic);
				break;
			default:
				statistic = totalStats.get("nationwide");
				if(statistic==null){
					statistic = new Statistic();
				}
				statistic.addStatPoint(statPoint);
				totalStats.put("nationwide", statistic);
				break;
			
			}
        }
		
		session.getTransaction().commit();
		session.close();
		
		switch(groupingFilter){
		case district:
			return districtStats;
		case state:
			return stateStats;
		default:
			return totalStats;
		
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
