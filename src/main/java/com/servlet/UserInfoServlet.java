package com.servlet;

import java.io.IOException;
import java.sql.Connection;

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

@WebServlet(urlPatterns= {"/userInfo"})
public class UserInfoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 
    public UserInfoServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Connection conn = MyUtils.getStoredConnection(request);
        // Kiểm tra người dùng đã đăng nhập (login) chưa.
        Student loginedStudent = MyUtils.getLoginedStudent(session);
 
        // Nếu chưa đăng nhập (login).
        if (loginedStudent == null) {
            // Redirect (Chuyển hướng) tới trang login.
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        // Lưu thông tin vào request attribute trước khi forward (chuyển tiếp).
        String student_id = loginedStudent.getStudent_id();
        byte[]avatar = null;
        try {
        avatar = DBUtils.avatarStudent(conn, student_id);
        } catch(Exception e) {
        	
        }
        loginedStudent.setAvatar(avatar);
        request.setAttribute("student", loginedStudent);
        // Nếu người dùng đã login thì forward (chuyển tiếp) tới trang
        // /WEB-INF/views/userInfoView.jsp
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/WEB-INF/views/userInfoView.jsp");
        dispatcher.forward(request, response);
        response.getOutputStream().write(avatar);
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
