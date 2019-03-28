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
import javax.servlet.http.HttpSession;

import com.beans.Student;
import com.utils.DBUtils;
import com.utils.MyUtils;

@WebServlet(urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public LoginServlet() {
		super();
	}
	
	//Hien thi trang Login
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		RequestDispatcher dispatcher //
			= this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String student_id = request.getParameter("student_id");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("rememberMe");
		boolean remember = "Y".equals(rememberMeStr);
		
		Student student = null;
		boolean hasError = false;
		String errorString = null;
		 
        if (student_id == null || password == null || student_id.length() == 0 || password.length() == 0) {
            hasError = true;
            errorString = "Required username and password!";
        } else {
            Connection conn = MyUtils.getStoredConnection(request);
            try {
                // Tìm user trong DB.
                student = DBUtils.findStudent(conn, student_id, password);
 
                if (student == null) {
                    hasError = true;
                    errorString = "Name or password invalid";
                }
            } catch (SQLException e) {
                e.printStackTrace();
                hasError = true;
                errorString = e.getMessage();
            }
        }
        
        //neu co loi thi chuyen sang trang login
        if(hasError) {
        	student = new Student();
        	student.setStudent_id(student_id);
        	student.setPassword(password);
        	
        	 // Lưu các thông tin vào request attribute trước khi forward.
            request.setAttribute("errorString", errorString);
            request.setAttribute("student", student);
 
            // Forward (Chuyển tiếp) tới trang /WEB-INF/views/login.jsp
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
 
            dispatcher.forward(request, response);
        }
        
        //Neu k loi thi chuyen sang trang thong tin nguoi dung
        else {
            HttpSession session = request.getSession();
            MyUtils.storeLoginedStudent(session, student);
 
            // Nếu người dùng chọn tính năng "Remember me".
            if (remember) {
                MyUtils.storeStudentCookie(response, student);
            }
            // Ngược lại xóa Cookie
            else {
                MyUtils.deleteStudentCookie(response);
            }
 
            // Redirect (Chuyển hướng) sang trang /userInfo.
            response.sendRedirect(request.getContextPath() + "/userInfo");
        }
	}
}
