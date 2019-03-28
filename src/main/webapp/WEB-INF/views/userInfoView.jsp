<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ page import = "com.beans.Student,com.servlet.UserInfoServlet" %>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>User Info</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Hello: ${student.student_name}</h3>
 
    User Name: <b>${student.student_name}</b>
    <br />
    Gender: ${student.gender } <br />
    <jsp:include page="_footer.jsp"></jsp:include>
 	${student.avatar}
 </body>
</html>