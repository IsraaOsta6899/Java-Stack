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
<h1>Save Travels</h1>
<table>
    <thead>
        <tr>
            
            <th>Expense</th>
            <th>Vendor</th>
            <th>Amount</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="travel" items="${travels}">
    	<tr>
    	<td>
    	<c:out value="${travel.expense}"></c:out>
    	<td>
    	<c:out value="${travel.vendor}"></c:out></td>
    	<td>
    	<c:out value="${travel.amount}"></c:out></td>
    	<td>
    	<a href="/expenses/edit/${travel.id}">Edit</a></td>
    	</tr>
        
    </c:forEach>
    </tbody>
</table>

<h1>New Travel</h1>
<form:form action="/addTravels" method="post" modelAttribute="travel">
    <p>
        <form:label path="expense">Expense</form:label>
        <form:errors path="expense"/>
        <form:input path="expense"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
         <form:input path="vendor"/>
        
       
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="amount">Pages</form:label>
        <form:errors path="amount"/>     
        <form:input  path="amount"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>