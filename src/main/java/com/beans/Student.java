package com.beans;

import java.sql.Date;

public class Student {
	
	public static final String GENDER_MALE="M";
	public static final String GENDER_FEMALE = "F";
	
	private String student_id;
	private String student_name;
	private Date birthday;
	private String gender;
	private String password;
	private boolean useradmin;
	private byte[] avatar;
	
	public Student() {
		
	}
	
	public Student(String student_id, String student_name, Date birthday, String gender, String password) {
		this.student_id = student_id;
		this.student_name = student_name;
		this.birthday = birthday;
		this.gender = gender;
		this.password = password;
//		this.avatar = avatar;
	}
	
	public String getStudent_id() {
		return student_id;
	}
	
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public boolean getUseradmin() {
		return useradmin;
	}
	
	public void setUseradmin(boolean useradmin) {
		this.useradmin = useradmin;
	}
	
	public byte[] getAvatar() {
		return avatar;
	}
	
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}
}
