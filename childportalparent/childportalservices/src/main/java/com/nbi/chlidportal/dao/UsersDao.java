/**
 * 
 */
package com.nbi.chlidportal.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.nbi.childportal.pojos.ChildAdmission;
import com.nbi.childportal.pojos.Role;
import com.nbi.childportal.pojos.User;
import com.nbi.childportal.pojos.rest.UserTo;

/**
 * @author zahmad
 *
 */
public class UsersDao {
	private static UsersDao singleton;

	private UsersDao(){

	}

	public static UsersDao getInstance(){
		if(singleton==null){
			setUp();
		}
		return singleton;
	}

	protected static synchronized void setUp(){
		if(singleton==null){
			singleton = new UsersDao();
		}
	}

	public void saveUser(User user) throws HibernateException, Exception{//FIXME: Need to fix this. This needs to be an atomic transaction
		List<User> userList = loadUser(user);
		if(userList!=null && userList.size()>0){
			User loadedUser = userList.get(0);
			loadedUser.getRoles().clear();
		}
		
		Session session = HibernateSession.getSessionFactory().openSession();
		//user.getUserRole().clear();
		session.beginTransaction();
		session.saveOrUpdate(user);
		session.getTransaction().commit();
		session.close();
	}

	public List<UserTo> getUser(User user) throws HibernateException, Exception{
		List<UserTo> resultTo = new ArrayList<UserTo>();
		List<User> result = loadUser(user);
		
		if(result!=null){
			Iterator<User> iter = result.iterator();
			while(iter.hasNext()){
				User orgResult = iter.next();
				resultTo.add(UserTo.getUserTo(orgResult));
			}
		}
		
		return resultTo;
	}
	
	private List<User> loadUser(User user){
		Session session = null;
		try{
			session = HibernateSession.getSessionFactory().openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(User.class);
			addCriteria(user, criteria);
			List<User> result = criteria.list();
			
			return result;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.getTransaction().commit();
			session.close();
		}

		return null;
	}
	
	private Criteria addCriteria(User user, Criteria criteria) {
		
		if(user.getAadharNo()!=null){
			criteria.add(Restrictions.eq("aadharNo", user.getAadharNo()));
		}
		if(user.getUserId()!=null){
			criteria.add(Restrictions.eq("userId", user.getUserId()));
		}
		if(user.getAddress()!=null){
			criteria.add(Restrictions.eq("address", user.getAddress()));
		}
/*		if(user.getAdmission()!=null){
			Iterator<ChildAdmission> iter = user.getAdmission().iterator();
			while(iter.hasNext()){
				criteria.add(Restrictions.eq("admission", iter.next()));
			}
		}
		}*/
		if(user.getName()!=null){
			criteria.add(Restrictions.eq("name", user.getName()));
		}
		if(user.getLocalName()!=null){
			criteria.add(Restrictions.eq("localName", user.getLocalName()));
		}
		if(user.getFatherName()!=null){
			criteria.add(Restrictions.eq("fatherName", user.getFatherName()));
		}
		if(user.getMotherName()!=null){
			criteria.add(Restrictions.eq("motherName", user.getMotherName()));
		}
		if(user.getGender()!=null){
			criteria.add(Restrictions.eq("gender", user.getGender()));
		}
		if(user.getDob()!=null){
			criteria.add(Restrictions.eq("dob", user.getDob()));
		}
		if(user.getDob_type()!=null){
			criteria.add(Restrictions.eq("dob_type", user.getDob_type()));
		}
		if(user.getMobile()!=null){
			criteria.add(Restrictions.eq("mobile", user.getMobile()));
		}
		if(user.getEmail()!=null){
			criteria.add(Restrictions.eq("email", user.getEmail()));
		}
		
		
		addRoleCriteria(user, criteria);
		
		return criteria;
	}

	private void addRoleCriteria(User user, Criteria criteria) {
		if(user.getRoles()!=null && user.getRoles().size()>0){
			Iterator<Role> iter = user.getRoles().iterator();
			while(iter.hasNext()){
				Role role = iter.next();
				Criteria roleCriteria = criteria.createCriteria("roles");
				if(role.getRole()!=null && !"".equalsIgnoreCase(role.getRole())){
					roleCriteria.add(Restrictions.eq("role", role.getRole()));
				}
				if(role.getRoleId()!=null && 0!=role.getRoleId()){
					roleCriteria.add(Restrictions.eq("roleId", role.getRoleId()));
				}
			}
		}
	}
}
