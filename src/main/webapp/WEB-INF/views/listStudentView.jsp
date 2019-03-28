<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
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
 
    <h3>Student List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table>
       <tr>
          <th>Student Code</th>
          <th>Name</th>
          <th>Birthday</th>
          <th>Gender</th>
          <th>Edit</th>
          <th>Delete</th>
       </tr>
       <c:forEach items="${studentList}" var="student" >
          <tr>
             <td>${student.student_id}</td>
             <td>${student.student_name}</td>
             <td>${student.birthday}</td>
             <td>${student.gender}</td>
             <%-- <td>
                <a href="editSubject?subject_id=${subject.subject_id}">Edit</a>
             </td>
             <td>
                <a href="deleteSubject?subject_id=${subject.subject_id}">Delete</a>
             </td> --%>
          </tr>
       </c:forEach>
    </table>
 
    <!-- <a href="createSubject" >Create Subject</a> -->
 
    <jsp:include page="_footer.jsp"></jsp:include>
 
 </body>
</html>