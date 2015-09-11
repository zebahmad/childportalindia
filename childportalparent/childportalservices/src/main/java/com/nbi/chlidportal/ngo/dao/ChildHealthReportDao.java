/**
 * 
 */
package com.nbi.chlidportal.ngo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import com.nbi.childportal.pojos.ngo.ChildHealthReport;
import com.nbi.childportal.pojos.rest.ngo.ChildHealthReportTo;
import com.nbi.chlidportal.dao.BaseDao;
import com.nbi.chlidportal.dao.SearchCriteriaUtil;

/**
 * @author zahmad
 *
 */
public class ChildHealthReportDao extends BaseDao<ChildHealthReport, ChildHealthReportTo> {
	
	private static ChildHealthReportDao singleton;
	private ChildHealthReportDao(){
	}
	public static ChildHealthReportDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new ChildHealthReportDao();
		}
	}

	public void saveChildAcademicReport(ChildHealthReport childHealthReport) throws HibernateException, Exception{
		save(childHealthReport);
	}

	public List<ChildHealthReportTo> getSponsor(ChildHealthReport childHealthReport) throws HibernateException, Exception{
		return getDbObject(childHealthReport);
	}

	@Override
	protected ChildHealthReportTo getRestType(ChildHealthReport childHealthReport) throws Exception {
		return ChildHealthReportTo.getChildHealthReportTo(childHealthReport);
	}

	@Override
	protected void addCriteria(ChildHealthReport childHealthReport, Criteria criteria) throws Exception {
		SearchCriteriaUtil.addChildHealthReportCriteria(childHealthReport, criteria);
	}

}
