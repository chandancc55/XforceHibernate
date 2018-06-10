package com.dev.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dev.beans.UserInfo;
import com.dev.dao.UserInfoDAO;
import com.dev.factory.UserInfoDAOFactory;

public class UserOperations {

	public static void main(String[] args)
	{ 
		
		UserInfo user=new UserInfo();
		user.setUser_Id(17);
		user.setFirstName("Root");
		user.setLastName("Rvb");
		user.setEmail("root@gmail.com");
		user.setPassword("cvfg");
		UserInfoDAO db=UserInfoDAOFactory.getDatabase();
		boolean state=db.createProfile(user);
		if(state)
		{
			System.out.println("success");
		}
		else
		System.out.println("failed");
		

	}

}
