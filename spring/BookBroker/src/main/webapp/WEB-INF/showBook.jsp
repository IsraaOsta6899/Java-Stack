<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
 <header>
<h1><c:out value="${book.getTitle()}"></c:out></h1>
<h6><a href="/home"> Back To The Shell </a></h6>
</header>  
<form:form action="/books/editt/${book.getId() }" modelAttribute="book">
	<p> <c:out value="${book.getUser().getUserName() }"></c:out>  read <c:out value="${book.getTitle() }"></c:out>by 
	<c:out value="${book.getAuthor() }"></c:out>
	</p><br>
	Here are <c:out value="${book.getUser().getUserName() }"></c:out> thought's:
	<form:textarea path="userThought"/>
	
	<c:choose>
    <c:when test="${book.getUser().getId()==user.getId()}">
	<form:button type="submit">Edit</form:button>
        <br />
    </c:when>    
    <c:otherwise>
        <br />
    </c:otherwise>
</c:choose>
</form:form>
</body>
</html>