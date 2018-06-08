package com.dev.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dev.beans.UserInfo;

public class GetUserInfo {

	public static void main(String[] args)
	{
		Configuration config=new Configuration().configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		UserInfo user=session.get(UserInfo.class,2);
		session.getTransaction().begin();
		
		session.getTransaction().commit();
		
		System.out.println(user);
		session.close();
		factory.close();

	}

}
