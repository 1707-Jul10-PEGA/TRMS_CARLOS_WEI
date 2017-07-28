package com.revature.trms.dao;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DAOManager {
	private static EmployeeDAO employeeDAO= null;
	private static ReimbursementDAO reimbursementDAO= null;
	private static GradeDAO gradeDAO= null;
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
	
	public static EmployeeDAO getEmployeeDAO() {
		logger.info("Fetching EmployeeDAO");
		if(employeeDAO == null) {
			try {
				employeeDAO = new EmployeeDAO();
			} catch (SQLException e) {
				logger.error("Failed to fetch EmployeeDAO");
			}
		}
		return employeeDAO;
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
}
