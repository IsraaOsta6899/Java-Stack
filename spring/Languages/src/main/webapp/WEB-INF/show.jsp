<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"/> 


<link rel="stylesheet" href="/style.css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     
<h1> Language Info :</h1>
<table class="table table-striped-columns">
	<tr>
		<th>Name:</th>
		<th>Creator</th>
		<th>Version</th>
		
	</tr>
	
	<tr>
		<td>
			<c:out value="${language.getName()}"/>
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
	
	
</table>

</body>
</html>