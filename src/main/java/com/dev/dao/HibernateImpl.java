package com.dev.dao;

import com.dev.beans.UserInfo;

public class HibernateImpl implements UserInfoDAO
{

	
	public boolean createProfile(UserInfo user) {
		// TODO Auto-generated method stub
		return false;
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
