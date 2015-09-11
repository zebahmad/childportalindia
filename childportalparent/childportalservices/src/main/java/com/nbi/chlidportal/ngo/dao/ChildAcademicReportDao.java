/**
 * 
 */
package com.nbi.chlidportal.ngo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import com.nbi.childportal.pojos.ngo.ChildAcademicReport;
import com.nbi.childportal.pojos.rest.ngo.ChildAcademicReportTo;
import com.nbi.chlidportal.dao.BaseDao;
import com.nbi.chlidportal.dao.SearchCriteriaUtil;

/**
 * @author zahmad
 *
 */
public class ChildAcademicReportDao extends BaseDao<ChildAcademicReport, ChildAcademicReportTo> {
	
	private static ChildAcademicReportDao singleton;
	private ChildAcademicReportDao(){
	}
	public static ChildAcademicReportDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new ChildAcademicReportDao();
		}
	}

	public void saveChildAcademicReport(ChildAcademicReport childAcademicReport) throws HibernateException, Exception{
		save(childAcademicReport);
	}

	public List<ChildAcademicReportTo> getSponsor(ChildAcademicReport childAcademicReport) throws HibernateException, Exception{
		return getDbObject(childAcademicReport);
	}

	@Override
	protected ChildAcademicReportTo getRestType(ChildAcademicReport childAcademicReport) throws Exception {
		return ChildAcademicReportTo.getChildAcademicReportTo(childAcademicReport);
	}

	@Override
	protected void addCriteria(ChildAcademicReport childAcademicReport, Criteria criteria) throws Exception {
		SearchCriteriaUtil.addChildAcademicReportCriteria(childAcademicReport, criteria);
	}

}
