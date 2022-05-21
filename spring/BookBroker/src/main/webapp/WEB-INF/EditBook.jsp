<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
 <header>
<h1>Add Book To your Shell:</h1>
<h6><a href="/home"> Back To The Shell </a></h6>
</header>  
<form:form action="/books/edit/${book.getId() }" method="post" modelAttribute="book">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="title">Title:</form:label><br>
        <form:errors path="title"/><br>
        <form:input path="title"/><br>
    </p><br><br>
    <p>
        <form:label path="author">Author Name:</form:label><br>
        <form:errors path="author"/><br>
        <form:textarea path="author"/><br>
    </p><br><br>
    <p>
        <form:label path="userThought">Your Thought:</form:label><br>
        <form:errors path="userThought"/><br>
        <form:input path="userThought"/><br>
    </p><br><br>
      
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>