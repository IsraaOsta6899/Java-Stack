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
<h1 style="text-align:center">New Product</h1>

 
<form:form action ="/products/new" method ="post" modelAttribute="product" >
	<table class="table table-striped-columns">
		
			<tr>
				<td> <form:label path="name">Name:</form:label></td>
				<td> <form:input path="name"/></td>
			</tr>
			
			
			<tr>
				<td> <form:label path="description">Description:</form:label></td>
				<td> <form:input path="description"/></td>
			</tr>
			
			<tr>
				<td> <form:label path="price">Price:</form:label></td>
				<td> <form:input path="price"/></td>
			</tr>
			
		
	</table>
	<button type="submit" value="create"> Create</button>
</form:form>
</body>
</html>
