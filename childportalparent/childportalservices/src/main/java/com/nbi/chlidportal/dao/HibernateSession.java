/**
 * 
 */
package com.nbi.chlidportal.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author zahmad
 *
 */
public class HibernateSession {
	
	private static SessionFactory sessionFactory;

	
	public static SessionFactory getSessionFactory() throws Exception{
		if(sessionFactory==null){
			setUp();
		}
		return sessionFactory;
	}
	
	protected static synchronized void setUp() throws Exception {
	    // A SessionFactory is set up once for an application
		if(sessionFactory==null){
			 sessionFactory = new Configuration()
	            .configure() // configures settings from hibernate.cfg.xml
	            .buildSessionFactory();
		}
	}
	
}
