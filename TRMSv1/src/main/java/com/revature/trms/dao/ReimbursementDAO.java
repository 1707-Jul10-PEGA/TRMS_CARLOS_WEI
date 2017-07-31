package com.revature.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

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
	
	public Form getForm(int formId){
	    Form form = null;
	    try {
		String sql = "SELECT * FROM FORMS WHERE FORMID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, formId);
		
		ResultSet rs = preparedStatement.executeQuery();
		if(rs.next()){
		    form = new Form(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
		}
		rs.close();
		preparedStatement.close();
		
		
		return form;
	    } catch (Exception e) {
		logger.error("Failed to fetch form with id:"+formId+" to database.");
		return null;
	    }
	}
	
	public ArrayList<Form> getFormList() {
		logger.info("Fetching form from database.");
		try {
			connection.setAutoCommit(false);
			
			String sql = "SELECT * FROM FORMS";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			ResultSet rs = preparedStatement.executeQuery();
			Form form;
			ArrayList<Form> formList = new ArrayList<Form>();
			while(rs.next()){
			    form = new Form(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7), rs.getInt(8), rs.getInt(9), rs.getString(10));
			    formList.add(form);
			}
			preparedStatement.close();
			return formList;
		} catch (Exception e) {
			logger.error("Failed to fetch form to database.");
			logger.error("Failed to fetch form list to database.");
			return null;
		}
	}
	
	public void setForm(Form form) {
		System.out.println("Saving form to database.");
		logger.info("Saving form to database.");
		
		try {
			connection.setAutoCommit(false);
			
			String sql = "INSERT INTO FORMS VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, form.getFormid());
			preparedStatement.setInt(2, form.getUserid());
			preparedStatement.setDate(3, form.getDate());
			preparedStatement.setString(4, form.getTimestamp());
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
			e.printStackTrace();
			logger.error("Failed to save form to database.");
		}
		
	}
	
	public void updateForm() {
		
	}
	
	public void deleteForm() {
		
	}
}
