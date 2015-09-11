/**
 * 
 */
package com.nbi.chlidportal.ngo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import com.nbi.childportal.pojos.ngo.ChildOverallReport;
import com.nbi.childportal.pojos.rest.ngo.ChildOverallReportTo;
import com.nbi.chlidportal.dao.BaseDao;
import com.nbi.chlidportal.dao.SearchCriteriaUtil;

/**
 * @author zahmad
 *
 */
public class ChildOverallReportDao extends BaseDao<ChildOverallReport, ChildOverallReportTo> {
	
	private static ChildOverallReportDao singleton;
	private ChildOverallReportDao(){
	}
	public static ChildOverallReportDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new ChildOverallReportDao();
		}
	}

	public void saveChildAcademicReport(ChildOverallReport childHealthReport) throws HibernateException, Exception{
		save(childHealthReport);
	}

	public List<ChildOverallReportTo> getSponsor(ChildOverallReport childHealthReport) throws HibernateException, Exception{
		return getDbObject(childHealthReport);
	}

	@Override
	protected ChildOverallReportTo getRestType(ChildOverallReport childHealthReport) throws Exception {
		return ChildOverallReportTo.getChildOverallReportTo(childHealthReport);
	}

	@Override
	protected void addCriteria(ChildOverallReport childHealthReport, Criteria criteria) throws Exception {
		SearchCriteriaUtil.addChildOverallReportCriteria(childHealthReport, criteria);
	}

}
