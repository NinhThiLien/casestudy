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

import com.utils.DBUtils;
import com.utils.MyUtils;

@WebServlet(urlPatterns= {"/deleteSubject"})
public class DeleteSubjectServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public DeleteSubjectServlet() {
		super();
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String subject_id = (String) request.getParameter("subject_id");
 
        String errorString = null;
 
        try {
            DBUtils.deleteSubject(conn, subject_id);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }          
   
        if (errorString != null) {
            
            request.setAttribute("errorString", errorString);
            // 
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/deleteSubjectErrorView.jsp");
            dispatcher.forward(request, response);
        }
        
        else {
            response.sendRedirect(request.getContextPath() + "/subjectList");
        }
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
