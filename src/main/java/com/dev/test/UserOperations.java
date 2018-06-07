package com.dev.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dev.beans.UserInfo;

public class UserOperations {

	public static void main(String[] args)
	{
		Configuration config=new Configuration().configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		UserInfo user=new UserInfo();
		user.setUser_Id(6);
		user.setFirstName("Root");
		user.setLastName("Rvv");
		user.setEmail("root@gmail.com");
		user.setPassword("cvfg");
		session.getTransaction().begin();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		System.out.println("success");
		

	}

}
