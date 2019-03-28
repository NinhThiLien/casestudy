package com.beans;

public class TimeTable {

	private int id;
	private int student_id;
	private int subject_id;
	
	public TimeTable() {
		
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id=id;
	}
	
	public int getStudentID() {
		return student_id;
	}
	
	public void setStudentID(int student_id) {
		this.student_id = student_id;
	}
	
	public int getSubjectID() {
		return subject_id;
	}
	
	public void setSubjectID(int subject_id) {
		this.subject_id = subject_id;
	}
}
