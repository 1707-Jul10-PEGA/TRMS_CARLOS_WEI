package com.revature.trms.pojos;

import java.sql.Date;

import org.apache.log4j.Logger;

import com.revature.trms.dao.DAOManager;

public class Employee extends User {
	private Logger logger = Logger.getRootLogger();

	public void createForm(int formid, int userid, Date date,  String timestamp, String location, String description,
			double cost, int gradingFormat, int eventType, String justification) {
		
		if (this.getReimbursementTotal() <= 1000) {
			Form form = new Form(formid, userid, date, timestamp, location, description, cost, gradingFormat, eventType,
					justification);
			DAOManager.getReimbursementDAO().setForm(form);
		}else {
			logger.warn("Employee " + userid + " exceed reimbursement total.");
		}
	}

	public void uploadGrade(int gradeId, int userId, String grade, int gradeFormatId) {
		this.getUserid();
		Grade g = new Grade(gradeId, userId, grade, gradeFormatId);
		DAOManager.getGradeDAO().setGrade(g);
	}
}
