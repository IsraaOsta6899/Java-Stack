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
     
<h1>Edit Language :</h1>
<form:form action="/langs/${language.id}" method="post" modelAttribute="language">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="Name">Name</form:label>
        <form:errors path="Name"/>
        <form:input path="Name"/>
    </p>
    <p>
        <form:label path="Creator">Creator</form:label>
        <form:errors path="Creator"/>
        <form:textarea path="Creator"/>
    </p>
    <p>
        <form:label path="Version">Language</form:label>
        <form:errors path="Version"/>
        <form:input path="Version"/>
    </p>
      
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>