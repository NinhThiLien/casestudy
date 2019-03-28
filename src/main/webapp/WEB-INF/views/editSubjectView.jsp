<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Subject</title>
   </head>
   <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Edit Subject</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty subject}">
         <form method="POST" action="${pageContext.request.contextPath}/editSubject">
            <input type="hidden" name="subject_id" value="${subject.subject_id}" />
            <table>
               <tr>
                  <td>Subject Code</td>
                  <td style="color:red;">${subject.subject_id}</td>
               </tr>
               <tr>
                  <td>Subject Name</td>
                  <td><input type="text" name="subject_name" value="${subject.subject_name}" /></td>
               </tr>
               <tr>
                  <td>Time Start</td>
                  <td><input type="time" name="time1" value="${subject.time1}" /></td>
                  <td>Time Finish</td>
                  <td><input type="time" name="time2" value="${subject.time2}" /></td>
               </tr>
               <tr>
               	  <td>Place</td>
               	  <td><input type="text" name="place" value="${subject.place}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/subjectList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>