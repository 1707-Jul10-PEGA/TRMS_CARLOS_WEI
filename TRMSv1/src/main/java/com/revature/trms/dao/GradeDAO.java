package com.revature.trms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.apache.log4j.Logger;

import com.revature.trms.pojos.Grade;
import com.revature.trms.util.ConnectionFactory;

public class GradeDAO {
	private static Logger logger = Logger.getRootLogger();
	private Connection connection = null;

	public void setup() throws SQLException {
		connection = ConnectionFactory.getInstance().getConnection();
	}

	public GradeDAO() throws SQLException {
		setup();
	}

	public Grade getGrade(int userID) {
		return null;

	}

	public void setGrade(Grade grade) {
		logger.info("Saving grade to database.");
		try {
			connection.setAutoCommit(false);

			String sql = "INSERT INTO GRADE_TABLE VALUES(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, grade.getGradeId());
			preparedStatement.setInt(2, grade.getUserId());
			preparedStatement.setString(3, grade.getGrade());
			preparedStatement.setInt(4, grade.getGradeFormatId());

			Savepoint savepoint = connection.setSavepoint();
			int num = preparedStatement.executeUpdate();
			if (num > 1) {
				connection.rollback();
			}
			connection.commit();
			connection.setAutoCommit(false);
			preparedStatement.close();
		} catch (Exception e) {
			logger.error("Failed to save grade to database.");
		}
	}

	public void updateGrade(Grade grade) {

	}

	public int deleteGrade(Grade ...grades) {
		return 0;
	}
}
