/**
 * 
 */
package com.nbi.chlidportal.ngo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import com.nbi.childportal.pojos.Child;
import com.nbi.childportal.pojos.rest.ChildTo;
import com.nbi.chlidportal.dao.BaseDao;
import com.nbi.chlidportal.dao.SearchCriteriaUtil;

/**
 * @author zahmad
 *
 */
public class ChildDao extends BaseDao<Child, ChildTo> {
	
	private static ChildDao singleton;
	private ChildDao(){
	}
	public static ChildDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new ChildDao();
		}
	}

	public void saveChild(Child child) throws HibernateException, Exception{
		save(child);
	}

	public List<ChildTo> getChild(Child child) throws HibernateException, Exception{
		return getDbObject(child);
	}

	@Override
	protected ChildTo getRestType(Child child) throws Exception {
		return ChildTo.getChildTo(child);
	}

	@Override
	protected void addCriteria(Child child, Criteria criteria) throws Exception {
		SearchCriteriaUtil.addChildCriteria(child, criteria);
	}

}
