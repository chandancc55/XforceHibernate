package com.dev.factory;

import com.dev.dao.HibernateImpl;
import com.dev.dao.JDBCImpl;
import com.dev.dao.UserInfoDAO;

public class UserInfoDAOFactory 
{
	private final static String DATABASE="HIBERNATE";
	private UserInfoDAOFactory()
	{
		
	}
    private static final UserInfoDAO ref=getDAO();
    private static UserInfoDAO getDAO()
    {
    	UserInfoDAO db=null;
    	if(DATABASE.equals("JDBC"))
    	{
    		db=new JDBCImpl();
    	}
    	else if(DATABASE.equals("HIBERNATE"))
    	{
    		db=new HibernateImpl();
    	}
    	return db;
    }
    public static UserInfoDAO getDatabase()
    {
    	return ref;
    }
}
