/**
 * 
 */
package com.nbi.chlidportal.ngo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import com.nbi.childportal.pojos.ngo.Sponsor;
import com.nbi.childportal.pojos.rest.ngo.SponsorTo;
import com.nbi.chlidportal.dao.BaseDao;
import com.nbi.chlidportal.dao.SearchCriteriaUtil;

/**
 * @author zahmad
 *
 */
public class SponsorDao extends BaseDao<Sponsor, SponsorTo> {
	
	private static SponsorDao singleton;
	private SponsorDao(){
	}
	public static SponsorDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new SponsorDao();
		}
	}

	public void saveSponsor(Sponsor sponsor) throws HibernateException, Exception{
		save(sponsor);
	}

	public List<SponsorTo> getSponsor(Sponsor sponsor) throws HibernateException, Exception{
		return getDbObject(sponsor);
	}

	@Override
	protected SponsorTo getRestType(Sponsor sponsor) throws Exception {
		return SponsorTo.getSponsorTo(sponsor);
	}

	@Override
	protected void addCriteria(Sponsor sponsor, Criteria criteria) throws Exception {
		SearchCriteriaUtil.addSponsorCriteria(sponsor, criteria);
	}

}
