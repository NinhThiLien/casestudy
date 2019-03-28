package com.beans;

public class Subject {

	private String subject_id;
	private String subject_name;
	private String time1;
	private String time2;
	private String place;
	
	public Subject(String subject_id,String subject_name,String time1,String time2,String place) {
		this.subject_id=subject_id;
		this.subject_name=subject_name;
		this.time1 = time1;
		this.time2 = time2;
		this.place = place;
	}
	
	public Subject() {
		
	}
	
	public String getSubject_id() {
		return subject_id;
	}
	
	public void setSubject_id(String subject_id) {
		this.subject_id=subject_id;
	}
	
	public String getSubject_name() {
		return subject_name;
	}
	
	public void setSubject_name(String subject_name) {
		this.subject_name=subject_name;
	}
	
	public String getTime1() {
		return time1;
	}
	
	public void setTime1(String time1) {
		this.time1 = time1;
	}
	
	public String getTime2() {
		return time2;
	}
	
	public void setTime2(String time2) {
		this.time2 = time2;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
}
