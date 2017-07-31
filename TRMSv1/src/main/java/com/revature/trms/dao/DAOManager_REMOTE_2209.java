package com.revature.trms.dao;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DAOManager {
	private static UserDAO userDAO = null;
	private static ReimbursementDAO reimbursementDAO = null;
	private static GradeDAO gradeDAO = null;
	private static ApproverDAO approverDAO = null;
	private static Logger logger = Logger.getRootLogger();
	
	public static ReimbursementDAO getReimbursementDAO() {
		logger.info("Fetching ReimbursementDAO");
		if(reimbursementDAO == null) {
			try {
				reimbursementDAO = new ReimbursementDAO();
			} catch (SQLException e) {
				logger.error("Failed to fetch ReimbursementDAO");
			}
		}
		return reimbursementDAO;
	}
	
	public static UserDAO getUserDAO() {
		logger.info("Fetching UserDAO");
		if(userDAO == null) {
			try {
				userDAO = new UserDAO();
			} catch (SQLException e) {
				logger.error("Failed to fetch UserDAO");
			}
		}
		return userDAO;
	}
	
	public static GradeDAO getGradeDAO() {
		logger.info("Fetching GradeDAO");
		if(gradeDAO == null) {
			try {
				gradeDAO = new GradeDAO();
			} catch (SQLException e) {
				logger.error("Failed to fetch GradeDAO");
			}
		}
		return gradeDAO;
	}
	
	public static ApproverDAO getApproverDAO() {
	    logger.info("Fetching ApproverDAO");
		if(approverDAO == null) {
			try {
			    approverDAO = new ApproverDAO();
			} catch (SQLException e) {
				logger.error("Failed to fetch ApproverDAO");
			}
		}
		return approverDAO;
	}
}