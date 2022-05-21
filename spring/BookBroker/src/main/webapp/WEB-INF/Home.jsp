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
<header>
<h1>Welcome, <c:out value="${user.getUserName() }"></c:out></h1>
<h6> <a href="/logout"> Logout</a></h6>
</header><br>
<div>
<label> Books from every one's shells</label> <h6> <a href="/books/new"> add a to my shelf</a></h6> <h6> <a href="/bookmarket">Book Market</a></h6>
  </div>
<table class="table table-striped-columns">
	<tr>
		<th>ID:</th>
		<th>Title</th>
		<th>Author Name</th>
		<th>Posted By</th>
		
		
	</tr>
	<c:forEach var="book" items="${books}" >
	<tr>
		<td>
			<c:out value="${book.getId()}"/>
		</td>
		<td>
			<a href="/books/${book.getId()}"><c:out value="${book.getBookTitle()}"/></a>
		</td>
		<td>
			<c:out value="${book.getAuthorName()}"/>
		</td>
		
		<td>
			<c:out value="${book.getUser().getUserName()}"/>
		</td>
		
	</tr>
	</c:forEach>
	
</table>
</body>
</html>