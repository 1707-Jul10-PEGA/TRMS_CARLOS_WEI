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
	private String gradingFormat;
	private String eventType;
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
		this.gradingFormat = getGradingFormatString(gradingFormat);
		this.eventType = getEventTypeString(eventType);
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
	public String getGradingFormat(){
	    return gradingFormat;
	}
	public int GradingFormatNum() {
	    	switch(gradingFormat){
	    	case "Letter Grade": return 1;
	    	case "Percentage": return 2;
	    	case "Pass/Fail": return 3;
	    	}
		return (Integer) null;
	}
	public void setGradingFormat(int gradingFormat) {
		this.gradingFormat = getGradingFormatString(gradingFormat);
	}
	public String getEventType(){
	    return eventType;
	}
	public int EventTypeNum() {
    	    	switch(eventType){
    	    	case "University Course": return 1;
    	    	case "Seminar": return 2;
    	    	case "Certification Preparation Class": return 3;
    	    	case "Certification": return 4;
    	    	case "Technical Training": return 5;
    	    	case "Other": return 6;
	    	}
    	    	//Should never reach. If it does, then something messed up in the db or when converting to a string
		return (Integer) null;
	}
	public void setEventType(int eventType) {
		this.eventType = getEventTypeString(eventType);
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
	
	private String getEventTypeString(int eventType){
	    switch(eventType){
	    case 1: return "University Course";
	    case 2: return "Seminar";
	    case 3: return "Certification Preparation Class";
	    case 4: return "Certification";
	    case 5: return "Technical Training";
	    case 6: return "Other";
	    }
	    return null;
	}
	
	private String getGradingFormatString(int gradingFormat){
	    switch(gradingFormat){
	    case 1: return "Letter Grade";
	    case 2: return "Percentage";
	    case 3: return "Pass/Fail";
	    }
	    return null;
	}
	/*@Override
	public String toString() {
		return "Form {\"formid\"=" + formid + ", \"userid\"=" + userid + ", \"date\"=" + date + ", \"timestamp\"=" + timestamp
				+ ", \"location\"=" + location + ", \"description\"=" + description + ", cost=" + cost + ", gradingFormat="
				+ gradingFormat + ", eventType=" + eventType + ", justification=" + justification + "}";
	}*/
	
}
