package com.dev.dao;

import com.dev.beans.UserInfo;

public interface UserInfoDAO 
{
	boolean createProfile(UserInfo user);
	boolean updateUser(int id,String oldPassword,String newPassword1,String newPassword2);
	UserInfo searchUser(int id);
	boolean deleteuser(int id,String password);
	

}
