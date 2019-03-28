<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page import = "com.beans.Student,com.servlet.*" %>
<!DOCTYPE html>
<html>
 <head>
  <style>
 table, th, td{
 	border-style: solid;
 	border-width: 1px;
 	padding: 5px;
 	border-color: black;
 }
 table{
 	spacing: 1px;
 }
 </style>
 <!-- <link rel="stylesheet" href="subjectList.css"> -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Subject List</title>
 </head>
 <body>
 
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_menu.jsp"></jsp:include>
 
    <h3>Subject List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table>
       <tr>
          <th>Code</th>
          <th>Name</th>
          <th>Time</th>
          <th>Place</th>
          <% Student student = (Student)request.getSession().getAttribute("loginedStudent");%>
   		<% if (student.getUseradmin()== true){ %>
          <th>Edit</th>
          <th>Delete</th>
          <%} %>
       </tr>
       <c:forEach items="${subjectList}" var="subject" >
          <tr>
             <td>${subject.subject_id}</td>
             <td>${subject.subject_name}</td>
             <td>${subject.time1}-${subject.time2}</td>
             <td>${subject.place}</td>
             <% if (student.getUseradmin()== true){ %>
             <td>
                <a href="editSubject?subject_id=${subject.subject_id}">Edit</a>
             </td>
             <td>
                <a href="deleteSubject?subject_id=${subject.subject_id}">Delete</a>
             </td>
             <%} %>
          </tr>
       </c:forEach>
    </table>
 
    <a href="createSubject" >Create Subject</a>
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>