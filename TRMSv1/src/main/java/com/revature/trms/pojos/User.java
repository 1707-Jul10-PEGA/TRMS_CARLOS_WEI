package com.revature.trms.pojos;

public class User {
	private int userid;
	private String firstname;
	private String lastname;
	private String email;
	private String department;
	private int supervisor;
	private String position;
	private double reimbursementTotal;
	
	
	public User() {
		super();
	}
	public User(int userid, String firstname, String lastname, String email, String department, int supervisor,
			String position,double reimbursementTotal) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.department = department;
		this.supervisor = supervisor;
		this.position = position;
		this.reimbursementTotal = reimbursementTotal;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(int supervisor) {
		this.supervisor = supervisor;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public double getReimbursementTotal() {
		return reimbursementTotal;
	}
	public void setReimbursementTotal(double reimbursementTotal) {
		this.reimbursementTotal = reimbursementTotal;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", department=" + department + ", supervisor=" + supervisor + ", position=" + position
				+ ", reimbursementTotal=" + reimbursementTotal + "]";
	}
	
}
