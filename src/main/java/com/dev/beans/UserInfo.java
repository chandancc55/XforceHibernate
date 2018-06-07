package com.dev.beans;

public class UserInfo 
{
  private int user_Id;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
public int getUser_Id() {
	return user_Id;
}
public void setUser_Id(int user_Id) {
	this.user_Id = user_Id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "UserInfo [user_Id=" + user_Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", password=" + password + "]";
}

  
}
