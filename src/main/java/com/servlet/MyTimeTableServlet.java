package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.Student;
import com.beans.Subject;
import com.utils.DBUtils;
import com.utils.MyUtils;

@WebServlet(urlPatterns = {"/timetable"})
public class MyTimeTableServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public MyTimeTableServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		Connection conn = MyUtils.getStoredConnection(request);
		HttpSession session = request.getSession();
		Student student = MyUtils.getLoginedStudent(session);
		String student_id = student.getStudent_id();
		String errorString = null;
		List<Subject>list = null;
		try {
			list = DBUtils.timeTable(conn, student_id);
		} catch(SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Save Information
		request.setAttribute("errorString", errorString);
		request.setAttribute("subjectList", list);
		//View Information
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/timeTableView.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		doGet(request,response);
	}
}
