<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import = "com.beans.Student,com.servlet.*" %>
<div style="padding: 5px;">
 
   <a href="${pageContext.request.contextPath}/">Home</a>
   |
   <a href="${pageContext.request.contextPath}/subjectList">Subject List</a>
   |
   <%if (request.getSession().getAttribute("loginedStudent")!= null) {%>
   <% Student student = (Student)request.getSession().getAttribute("loginedStudent");%>
   <% if (student.getUseradmin()== true){ %>
   	<a href="${pageContext.request.contextPath}/createStudent">Create Student</a>
   	|
   	<a href="${pageContext.request.contextPath}/studentList">All Student</a>
   	<%} %>
   	|
   	<a href="${pageContext.request.contextPath}/timetable">My Timetable</a>
   	|
   	<a href="${pageContext.request.contextPath}/userInfo">My Account Info</a>
   	|
   	<a href="${pageContext.request.contextPath}/logout">Logout</a>
   	<%} else { %>
   	<a href="${pageContext.request.contextPath}/login">Login</a>
   	<%} %>
    
</div> 