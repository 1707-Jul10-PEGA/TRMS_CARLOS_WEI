package com.revature.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.apache.log4j.Logger;

import com.revature.trms.pojos.Form;
import com.revature.trms.pojos.User;
import com.revature.trms.util.ConnectionFactory;

public class ApproverDAO {

    private Logger logger = Logger.getRootLogger();
    private Connection connection = null;
	
	public void setup() throws SQLException{
		connection = ConnectionFactory.getInstance().getConnection();
	}
	
	public ApproverDAO() throws SQLException{
		setup();
	}
	
	public int approveForm(User user, Form form) {
	    try {
		connection.setAutoCommit(false);
		String sql;
		int num = 0;
		User reimbursee = DAOManager.getUserDAO().getUser(form.getUserid());
		PreparedStatement preparedStatement = null;
		if("Department Head".equalsIgnoreCase(user.getPosition()) &&
		   user.getDepartment().equalsIgnoreCase(reimbursee.getDepartment())){
		    sql = "UPDATE FORMS_APPROVAL SET DEPARTMENTHEAD = 'A'  WHERE FORMID = ?";
		    preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setInt(2, form.getFormid());
		    num += preparedStatement.executeUpdate();
		}
		if(user.getUserid() == reimbursee.getSupervisor()){
		    sql = "UPDATE FORMS_APPROVAL SET DIRECTSUPERVISOR = 'A'  WHERE FORMID = ?";
		    preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setInt(2, form.getFormid());
		    num += preparedStatement.executeUpdate();
		}
		if("BenCo".equalsIgnoreCase(user.getDepartment())){
		    sql = "UPDATE FORMS_APPROVAL SET BENCO = 'A'  WHERE FORMID = ?";
		    preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setInt(2, form.getFormid());
		    num += preparedStatement.executeUpdate();
		}
		Savepoint s = connection.setSavepoint();
		if (num > 3) {
			connection.rollback();
		    }
		connection.setAutoCommit(true);
		preparedStatement.close();
		
		return num;
	    } catch (Exception e) {
		logger.error("Failed to approve form with id:"+form.getFormid()+" to database.");
		return -1;
	    }
	}
	
	public int denyForm(User user, Form form){
	    try {
		connection.setAutoCommit(false);
		String sql;
		int num = 0;
		User reimbursee = DAOManager.getUserDAO().getUser(form.getUserid());
		PreparedStatement preparedStatement = null;
		if("Department Head".equalsIgnoreCase(user.getPosition()) &&
		   user.getDepartment().equalsIgnoreCase(reimbursee.getDepartment())){
		    sql = "UPDATE FORMS_APPROVAL SET DEPARTMENTHEAD = 'D'  WHERE FORMID = ?";
		    preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setInt(2, form.getFormid());
		    num += preparedStatement.executeUpdate();
		}
		if(user.getUserid() == reimbursee.getSupervisor()){
		    sql = "UPDATE FORMS_APPROVAL SET DIRECTSUPERVISOR = 'D'  WHERE FORMID = ?";
		    preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setInt(2, form.getFormid());
		    num += preparedStatement.executeUpdate();
		}
		if("BenCo".equalsIgnoreCase(user.getDepartment())){
		    sql = "UPDATE FORMS_APPROVAL SET BENCO = 'D'  WHERE FORMID = ?";
		    preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setInt(2, form.getFormid());
		    num += preparedStatement.executeUpdate();
		}
		Savepoint s = connection.setSavepoint();
		if (num > 3) {
			connection.rollback();
		    }
		connection.setAutoCommit(true);
		preparedStatement.close();
		
		return num;
	    } catch (Exception e) {
		logger.error("Failed to approve form with id:"+form.getFormid()+" to database.");
		return -1;
	    }
	}
	
}
