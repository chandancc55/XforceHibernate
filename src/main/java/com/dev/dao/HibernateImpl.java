package com.dev.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dev.beans.UserInfo;
import com.dev.util.HibernateUtils;

public class HibernateImpl implements UserInfoDAO{
	
	SessionFactory factory=HibernateUtils.getSessionFactory();
	public boolean createProfile(UserInfo user) {
		Session session=null;
		try
		{
		session=factory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		finally
		{
			session.close();
		}
	}

	
	public boolean updateUser(int id, String oldPassword, String newPassword1, String newPassword2) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public UserInfo searchUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteuser(int id, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public String toString() {
		return "Hibernate";
	}
	
   
}
