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


<link rel="stylesheet" href="/style.css"/>
</head>
<body>
<table class="table table-striped-columns">
	<tr>
		<th>Name:</th>
		<th>Creator</th>
		<th>Version</th>
		
	</tr>
	<c:forEach var="language" items="${languages}" >
	<tr>
		<td>
			<a href="/language/${language.getId()}"><c:out value="${language.getName()}"/></a>
		</td>
		<td>
			<c:out value="${language.getCreator()}"/>
		</td>
		
		<td>
			<c:out value="${language.getVersion()}"/>
		</td>
		<td>
			<a href="/languages/edit/${language.getId()}"> Edit</a>|<a href="/languages/delete/${language.getId()}"> Delete</a>
		</td>
	</tr>
	</c:forEach>
	
</table>

<h1>Add New Language</h1>
<form:form action="/languages" method="post" modelAttribute="language">
	<form:label path="Name">Name:</form:label><br>
	<form:errors path="Name"></form:errors><br>
	<form:input path="Name"/><br>
	
	<form:label path="Creator">Creator:</form:label><br>
	<form:errors path="Creator"></form:errors><br>
	<form:input path="Creator"/><br>
	
	
	<form:label path="Version">Version:</form:label><br>
	<form:errors path="Version"></form:errors><br>
	<form:input path="Version"/><br>
	
    <input type="submit" value="add New Book"/>
	
</form:form>


</body>
</html>