package com.dev.dao;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dev.beans.UserInfo;

public class JDBCImpl implements UserInfoDAO {

	public boolean createProfile(UserInfo user) {

		java.sql.Connection con = null;
		java.sql.PreparedStatement pmt = null;
		String qry = "insert into user_info values(?,?,?,?,?)";
		String dburl = "jdbc:mysql://localhost:3306/xforce_db";
		try {
			java.io.FileReader fr = new java.io.FileReader("D:\\X_Force\\prop\\info.properties.txt");
			java.util.Properties prop = new java.util.Properties();
			prop.load(fr);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dburl, prop);

			pmt = con.prepareStatement(qry);
			pmt.setInt(1, user.getUser_Id());
			pmt.setString(2, user.getFirstName());
			pmt.setString(3, user.getLastName());
			pmt.setString(4, user.getEmail());
			pmt.setString(5, user.getPassword());
			int state = pmt.executeUpdate();
			if (state > 0) {
				return true;
			} else
				return false;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (pmt != null) {
				try {
					pmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public boolean updateUser(int id, String oldPassword, String newPassword1, String newPassword2) {
		java.sql.Connection con = null;
		java.sql.PreparedStatement pmt = null;
		// ResultSet rs=null;
		String qry = "update user_info set password=? where user_id=? and password=?";
		String dburl = "jdbc:mysql://localhost:3306/xforce_db";
		UserInfo user = new UserInfo();
		try {
			java.io.FileReader fr = new java.io.FileReader("D:\\X_Force\\prop\\info.properties.txt");
			java.util.Properties prop = new java.util.Properties();
			prop.load(fr);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dburl, prop);
			pmt = con.prepareStatement(qry);

			pmt.setString(1, newPassword1);
			pmt.setInt(2, id);
			pmt.setString(3, oldPassword);
			int r = pmt.executeUpdate();
			if (r > 0) {
				return true;
			} else {
				return false;
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} finally {

			if (pmt != null) {
				try {
					pmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return true;
	}

	@Override
	public UserInfo searchUser(int id) {
		java.sql.Connection con = null;
		java.sql.PreparedStatement pmt = null;
		ResultSet rs = null;
		String qry = "select * from user_info where user_id=?";
		String dburl = "jdbc:mysql://localhost:3306/xforce_db";
		UserInfo user = new UserInfo();
		try {
			java.io.FileReader fr = new java.io.FileReader("D:\\X_Force\\prop\\info.properties.txt");
			java.util.Properties prop = new java.util.Properties();
			prop.load(fr);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dburl, prop);
			pmt = con.prepareStatement(qry);
			pmt.setInt(1, id);

			rs = pmt.executeQuery();

			if (rs.next()) {
				int userId = rs.getInt("user_id");
				user.setUser_Id(userId);
				String fname = rs.getString("First_Name");
				user.setFirstName(fname);
				String lname = rs.getString("Last_Name");
				user.setLastName(lname);
				String email = rs.getString("Email");
				user.setEmail(email);
				String password = rs.getString("password");
				user.setPassword(password);
				// System.out.println(user);
				return user;
			} else
				return null;
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pmt != null) {
				try {
					pmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return user;
	}

	@Override
	public boolean deleteuser(int id, String password) {
		java.sql.Connection con = null;
		java.sql.PreparedStatement pmt = null;

		String qry = "delete from user_info where user_id=? and password=?";
		String dburl = "jdbc:mysql://localhost:3306/xforce_db";
		// String qry1="select * from user_info where user_id=?";
		try {
			java.io.FileReader fr = new java.io.FileReader("D:\\X_Force\\prop\\info.properties.txt");
			java.util.Properties prop = new java.util.Properties();
			prop.load(fr);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dburl, prop);
			pmt = con.prepareStatement(qry);
			pmt.setInt(1, id);
			pmt.setString(2, password);

			int r = pmt.executeUpdate();
			if (r > 0) {
				return true;
			} else
				return false;

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		} finally {

			if (pmt != null) {
				try {
					pmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}

	@Override
	public String toString() {
		return "JDBC";
	}

}
