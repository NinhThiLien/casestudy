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

import com.beans.Subject;
import com.utils.DBUtils;
import com.utils.MyUtils;

@WebServlet(urlPatterns = {"/subjectList"})
public class SubjectListServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public SubjectListServlet() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		Connection conn = MyUtils.getStoredConnection(request);
		String errorString = null;
		List<Subject>list = null;
		try {
			list = DBUtils.querySubject(conn);
		} catch(SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Save Information
		request.setAttribute("errorString", errorString);
		request.setAttribute("subjectList", list);
		//View Information
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/subjectListView.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		doGet(request,response);
	}
}
