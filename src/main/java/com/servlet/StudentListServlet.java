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

import com.beans.Student;
import com.utils.DBUtils;
import com.utils.MyUtils;

@WebServlet(urlPatterns= {"/studentList"})
public class StudentListServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	public StudentListServlet() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		Connection conn = MyUtils.getStoredConnection(request);
		String errorString = null;
		List<Student>list = null;
		try {
			list = DBUtils.listStudent(conn);
		} catch(SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Save Information
		request.setAttribute("errorString", errorString);
		request.setAttribute("studentList", list);
		//View Information
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/listStudentView.jsp");
		dispatcher.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		doGet(request,response);
	}
}