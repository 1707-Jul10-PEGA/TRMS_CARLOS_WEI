package com.revature.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.*;

import com.revature.trms.pojos.User;
import com.revature.trms.util.ConnectionFactory;

public class UserDAO {
	private static Logger logger = Logger.getRootLogger();
	private Connection connection = null;
	
	public void setup() throws SQLException{
		connection = ConnectionFactory.getInstance().getConnection();
	}
	
	public UserDAO() throws SQLException{
		setup();
	}
	
	public User getUser(int userID) {
	    User user = null;
	    logger.info("Fetching user from database.");
	   	try {
		    String sql = "SELECT * FROM USER_TABLE WHERE USERID = ?";
		    PreparedStatement pstmt = connection.prepareStatement(sql);
		    pstmt.setInt(1, userID);

		    ResultSet rs = pstmt.executeQuery();
		    if (rs.next()) {
		        user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getDouble(8));
		    }
		    rs.close();
		    pstmt.close();
		    return user;
		} catch (SQLException e) {
		    logger.error("Failed to fetch user from database.");
		    e.printStackTrace();
		    return null;
		}
	}
	
	public int setUser(User user) {
		return 0;
	}
	
	public int updateUser(User user) {
		return 0;
	}
	
	public int deleteUser(User user) {
		return 0;
	}
}
