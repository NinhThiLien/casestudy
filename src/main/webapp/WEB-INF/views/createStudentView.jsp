<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Sign up</title>
   </head>
   <body>
    
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
       
      <h3>Create Product</h3>
       
      <p style="color: red;">${errorString}</p>
       
      <form method="POST" action="${pageContext.request.contextPath}/createStudent"  enctype="multipart/form-data">
         <table>
         	
         	<tr>
               <td>Student ID</td>
               <td>
               	<input type="text" name="student_id" value="${student.student_id}" /> 
               </td>
            </tr>
            
            <tr>
               <td>Student Name</td>
               <td>
               	<input type="text" name="student_name" value="${student.student_name}" /> 
               </td>
            </tr>
            
            <tr>
               <td>Birthday</td>
               <td>
               	<input type="date" name="birthday" value="${student.birthday}" /> 
               </td>
            </tr>
            
            <tr>
               <td>Gender</td>
               <td>
               	<input type = "radio" name ="gender" value="M" /> Male
               	<input type = "radio" name ="gender" value="F" /> Female
               </td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type="password" name="password" value="${student.password}" /></td>
            </tr>
            <tr>
             <td>Select file to upload:</td>
            <td><input type="file" name="file"  /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="home">Cancel</a>
               </td>
            </tr>
         </table>
      </form>
       
      <jsp:include page="_footer.jsp"></jsp:include>
       
   </body>
</html>