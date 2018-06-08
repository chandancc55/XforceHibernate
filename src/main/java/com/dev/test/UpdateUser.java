package com.dev.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dev.beans.UserInfo;

public class UpdateUser {

	public static void main(String[] args) {

		Configuration config=new Configuration().configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		
		session.getTransaction().begin();
		UserInfo user=session.get(UserInfo.class,10);
		user.setFirstName("ravi");
		session.getTransaction().commit();
		
		
		session.close();
		factory.close();
		System.out.println(user);
	}

}
