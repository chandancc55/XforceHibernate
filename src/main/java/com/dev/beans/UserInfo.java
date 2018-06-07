package com.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user_info")
public class UserInfo 
{
	@Id @Column(name="user_id")
  private int user_Id;
	@Column(name="First_Name")
  private String firstName;
	@Column(name="Last_name")
  private String lastName;
	@Column(name="Email")
  private String email;
	@Column(name="password")
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
