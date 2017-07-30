package com.revature.trms.dao;

import java.sql.Connection;
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
		
		return null;
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
