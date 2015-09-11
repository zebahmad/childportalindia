/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * @author zahmad
 *
 */
public abstract class BaseDao <DbType, RestType> {

	protected void save(DbType dbTypeObject) throws HibernateException, Exception{
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(dbTypeObject);
		session.getTransaction().commit();
		session.close();
	}

	protected List<RestType> getDbObject(DbType dbTypeObject) throws HibernateException, Exception{
		//TODO: Exception handling for db
		Session session = HibernateSession.getSessionFactory().openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(getClassOfDbType());
		addCriteria(dbTypeObject, criteria);
		List<DbType> result = criteria.list();

		List<RestType> resultTo = new ArrayList<RestType>();
		if(result==null){
			return null;
		}else{
			Iterator<DbType> iter = result.iterator();
			while(iter.hasNext()){
				DbType orgResult = iter.next();
				resultTo.add(getRestType(orgResult));
			}
		}
		session.getTransaction().commit();
		session.close();
		return resultTo;
	}

	protected abstract RestType getRestType(DbType dbType) throws Exception;

	protected abstract void addCriteria(DbType dbType, Criteria criteria) throws Exception;
	
	protected Class<DbType> getClassOfDbType() throws Exception 
    {
        ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<DbType>) superclass.getActualTypeArguments()[0];
    }
	
}
