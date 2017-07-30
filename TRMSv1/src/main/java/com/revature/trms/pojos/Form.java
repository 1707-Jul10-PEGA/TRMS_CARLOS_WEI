package com.revature.trms.pojos;

import java.sql.Date;

public class Form {
	private int formid;
	private int userid;
	private Date date;
	private String timestamp;
	private String location;
	private String description;
	private double cost;
	private int gradingFormat;
	private int eventType;
	private String justification;
	
	public Form() {
		super();
	}

	public Form(int formid, int userid, Date date, String timestamp, String location, String description,
			double cost, int gradingFormat, int eventType, String justification) {
		super();
		this.formid = formid;
		this.userid = userid;
		this.date = date;
		this.timestamp = timestamp;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.justification = justification;
	}
	
	public int getFormid() {
		return formid;
	}
	public void setFormid(int formid) {
		this.formid = formid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(int gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	public int getEventType() {
		return eventType;
	}
	public void setEventType(int eventType) {
		this.eventType = eventType;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}

	@Override
	public String toString() {
		return "Form [formid=" + formid + ", userid=" + userid + ", date=" + date + ", timestamp=" + timestamp
				+ ", location=" + location + ", description=" + description + ", cost=" + cost + ", gradingFormat="
				+ gradingFormat + ", eventType=" + eventType + ", justification=" + justification + "]";
	}
	
}
