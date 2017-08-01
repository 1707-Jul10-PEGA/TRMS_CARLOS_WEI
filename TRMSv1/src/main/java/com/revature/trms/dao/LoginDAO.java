package com.revature.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.apache.log4j.Logger;

import com.revature.trms.pojos.Login;
import com.revature.trms.servlets.LoginServlet;
import com.revature.trms.util.ConnectionFactory;

import oracle.core.lmx.CoreException;

public class LoginDAO {
	private static Logger logger = Logger.getRootLogger();
	private Connection connection = null;

	public void setup() throws SQLException {
		connection = ConnectionFactory.getInstance().getConnection();
	}

	public LoginDAO() throws SQLException {
		setup();
	}

	public Login getLogin(String username) {
		logger.info("Fetching login to database.");
		Login correctLogin = null;
		try {
			String sql = "SELECT * FROM LOGIN_INFORMATION WHERE USERNAME=?";
			String password = null;
			int userid;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, username);
			preparedStatement.executeQuery();
			
			ResultSet resultSet = preparedStatement.getResultSet();
			while (resultSet.next()) {
				password = resultSet.getString("PASSWORD");
				userid = resultSet.getInt("USERID");
				if(password != null) {
					correctLogin = new Login(username,password);
					correctLogin.setUserid(userid);
				}
			}
			
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error("Failed to fetch login to database.");
		}
		return correctLogin;

	}

	public void setLogin(Login login) {
		logger.info("Saving login to database.");
		try {
			connection.setAutoCommit(false);

			String sql = "INSERT INTO LOGIN_INFORMATION VALUES(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, login.getUserId());
			preparedStatement.setString(2, login.getUsername());
			preparedStatement.setString(3, login.getPassword());

			Savepoint savepoint = connection.setSavepoint();
			int num = preparedStatement.executeUpdate();
			if (num > 1) {
				connection.rollback();
			}
			connection.commit();
			connection.setAutoCommit(false);
			preparedStatement.close();
		} catch (Exception e) {
			logger.error("Failed to save login to database.");
		}
	}

	public void updateLogin(Login login) {

	}

	public int deleteLogins(Login ...logins) {
		return 0;
	}
}
