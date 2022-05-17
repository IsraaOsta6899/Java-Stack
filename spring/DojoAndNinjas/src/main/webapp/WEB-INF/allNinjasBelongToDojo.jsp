<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"/> 
</head>
<body>
<h1>Burbank Lovation Ninjas</h1>
<table class="table">
  <thead class="table-dark">
  	<tr>
	  	<td>First Name:</td>
	  	<td>Last Name:</td>
	  	<td>Age:</td>
  	</tr>
  </thead>
  <tbody>
	  <c:forEach var="ninja" items="${ns }">
	  	<tr>
	  		<td> <c:out value="${ninja.getFirstName()}"></c:out></td>
	  		<td> <c:out value="${ninja.getLastName()}"></c:out></td>
	  		
	  		<td> <c:out value="${ninja.getAge()}"></c:out></td>
	  		
	  		
	  	</tr>
	  </c:forEach>

  </tbody>
</table>

</body>
</html>