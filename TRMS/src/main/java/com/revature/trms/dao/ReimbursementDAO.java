package com.revature.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.apache.log4j.Logger;

import com.revature.trms.pojos.Form;
import com.revature.trms.util.ConnectionFactory;

public class ReimbursementDAO {
	private static Logger logger = Logger.getRootLogger();
	private Connection connection = null;
	
	public void setup() throws SQLException{
		connection = ConnectionFactory.getInstance().getConnection();
	}
	
	public ReimbursementDAO() throws SQLException{
		setup();
	}
	public void getForm() {
		
	}
	
	public void setForm(Form form) {
		logger.info("Saving form to database.");
		try {
			connection.setAutoCommit(false);
			
			String sql = "INSERT INTO FORMS VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, form.getFormid());
			preparedStatement.setInt(2, form.getUserid());
			preparedStatement.setDate(3, form.getDate());
			preparedStatement.setTimestamp(4, form.getTimestamp());
			preparedStatement.setString(5, form.getLocation());
			preparedStatement.setString(6, form.getDescription());
			preparedStatement.setDouble(7, form.getCost());
			preparedStatement.setInt(8, form.getGradingFormat());
			preparedStatement.setInt(9, form.getEventType());
			preparedStatement.setString(10, form.getJustification());
			
			Savepoint savepoint = connection.setSavepoint();
			int num = preparedStatement.executeUpdate();
			if(num > 1) {
				connection.rollback();
			}
			connection.commit();
			connection.setAutoCommit(false);
			preparedStatement.close();
		} catch (Exception e) {
			logger.error("Failed to save form to database.");
		}
		
	}
	
	public void updateForm() {
		
	}
	
	public void deleteForm() {
		
	}
}
