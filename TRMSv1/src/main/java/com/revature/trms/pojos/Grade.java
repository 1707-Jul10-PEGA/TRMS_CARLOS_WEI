package com.revature.trms.pojos;

public class Grade {
	private int gradeId;
	private int userId;
	private String grade;
	
	public Grade() {
		super();
	}
	
	public Grade(int gradeId, int userId, String grade, int gradeFormatId) {
		super();
		this.gradeId = gradeId;
		this.userId = userId;
		this.grade = grade;
		this.gradeFormatId = gradeFormatId;
	}
	private int gradeFormatId;
	
	
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getGradeFormatId() {
		return gradeFormatId;
	}
	public void setGradeFormatId(int gradeFormatId) {
		this.gradeFormatId = gradeFormatId;
	}
	@Override
	public String toString() {
		return "Grade [gradeId=" + gradeId + ", userId=" + userId + ", grade=" + grade + ", gradeFormatId="
				+ gradeFormatId + "]";
	}
	
	
}
