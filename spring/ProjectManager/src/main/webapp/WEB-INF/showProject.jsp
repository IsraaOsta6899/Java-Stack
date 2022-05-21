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
<h1>Project Details:</h1>
<h6><a href="/home"> Back To DashBoard </a></h6>
</header> 
<p> Project Title     :      <c:out value="${project.getTitle() }"></c:out></p>
<p> Description       :      <c:out value="${project.getDescription() }"></c:out></p>
<p> Due Date          :      <c:out value="${project.getDuedate() }"></c:out></p>
<a href="/projects/delete/${project.getId() }"> Delete </a> <br>
<a href="/projects/addTask/${project.getId()}">add New Task</a>

</body>
</html>