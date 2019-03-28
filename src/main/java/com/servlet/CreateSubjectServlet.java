package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Subject;
import com.utils.DBUtils;
import com.utils.MyUtils;

@WebServlet(urlPatterns = {"/createSubject"})
public class CreateSubjectServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public CreateSubjectServlet() {
		super();
	}
	
	//View CreateSubject page
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/createSubjectView.jsp");
		dispatcher.forward(request, response);
	}
	
	//doPost
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
		throws ServletException, IOException{
		Connection conn = MyUtils.getStoredConnection(request);
		String subject_id = (String)request.getParameter("subject_id");
		String subject_name = (String)request.getParameter("subject_name");
		String time1 = (String)request.getParameter("time1");
		String time2 = (String)request.getParameter("time2");
		String place = (String)request.getParameter("place");
		
		Subject subject = new Subject(subject_id, subject_name,time1,time2,place);
		String errorString = null;
		
		String regex = "\\w+";
		
		if(subject_id == null|| !subject_id.matches(regex)) {
			errorString = "Subject Code invalid";
		}
		
		if(errorString == null) {
			try {
				DBUtils.insertSubject(conn, subject);
			}catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}
		
		request.setAttribute("errorString",errorString);
		request.setAttribute("subject",subject);
		
		if(errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/createSubjectView.jsp");
			dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/subjectList");
		}
	}
	
}