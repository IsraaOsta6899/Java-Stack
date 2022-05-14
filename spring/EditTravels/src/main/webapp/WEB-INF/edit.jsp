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
</head>
<body>
<h1>Edit Expense </h1>
<form action="/update/${Travel.id}" method="post" >
    <p>
        <label >Expense</label>
       
        <input value="${Travel.expense}" />
    </p>
    <p>
        <label >Vendor</label>
       
        <input value="${Travel.vendor }" />
        
       
    </p>
    <p>
        <label >description</label>
       
        <input value="${Travel.description }" />
    </p>
    <p>
        <label >Amount</label>
       
        <input value="${Travel.amount }" />
    </p> 
<input type="submit" value="save"/>

</form>
</body>
</html>