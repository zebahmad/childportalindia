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

	public void saveChildAcademicReport(ChildOverallReport childOverallReport) throws HibernateException, Exception{
		save(childOverallReport);
	}

	public List<ChildOverallReportTo> getOverallReport(ChildOverallReport childOverallReport) throws HibernateException, Exception{
		return getDbObject(childOverallReport);
	}

	@Override
	protected ChildOverallReportTo getRestType(ChildOverallReport childOverallReport) throws Exception {
		return ChildOverallReportTo.getChildOverallReportTo(childOverallReport);
	}

	@Override
	protected void addCriteria(ChildOverallReport childOverallReport, Criteria criteria) throws Exception {
		SearchCriteriaUtil.addChildOverallReportCriteria(childOverallReport, criteria);
	}

}
