package com.utils;

import java.sql.Connection;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Student;

public class MyUtils {

	public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";
	public static final String ATT_NAME_STUDENT_ID = "ATTRIBUTE_FOR_STORE_STUDENT_ID";
	
	//Luu tru Connection vao Attribute cua request
	public static void storeConnection(ServletRequest request, Connection conn) {
		request.setAttribute(ATT_NAME_CONNECTION, conn);
	}
	
	//Lay doi tuong Connection da duoc luu trong Attribute cuar request
	public static Connection getStoredConnection(ServletRequest request) {
		Connection conn = (Connection)request.getAttribute(ATT_NAME_CONNECTION);
		return conn;
	}
	
	//Luu thong tin student da login vao Session
	public static void storeLoginedStudent(HttpSession session, Student loginedStudent) {
		session.setAttribute("loginedStudent", loginedStudent);
	}
	
	//Lay thong tin nguoi dung trong Session
	public static Student getLoginedStudent(HttpSession session) {
		Student loginedStudent= (Student)session.getAttribute("loginedStudent");
		return loginedStudent;
	}
	
	//Luu thong tin nguoi dung vao Cookie
	public static void storeStudentCookie(HttpServletResponse response, Student student) {
		System.out.println("Store student cookie");
		Cookie cookieStudentID=new Cookie(ATT_NAME_STUDENT_ID,student.getStudent_id());
		cookieStudentID.setMaxAge(24*60*60);
		response.addCookie(cookieStudentID);
	}
	
	public static String getStudentIDInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie : cookies) {
				if(ATT_NAME_STUDENT_ID.equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
	
	//Xoa Cookie user
	public static void deleteStudentCookie(HttpServletResponse response) {
		Cookie cookieStudentID = new Cookie(ATT_NAME_STUDENT_ID,null);
		cookieStudentID.setMaxAge(0);
		response.addCookie(cookieStudentID);
	}
}
