<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Here's your Omikuji
</h1>

<div>
In <c:out value="${selectYear}"></c:out>Years , you will live in 
<c:out value="${person}"></c:out>with <c:out value="${hoppy}"></c:out>
as your rommate,selling <c:out value="${city}"></c:out> for a living 
the next time you see a<c:out value="${living}"></c:out>
you will have a good luck
</div>
</body>
</html>