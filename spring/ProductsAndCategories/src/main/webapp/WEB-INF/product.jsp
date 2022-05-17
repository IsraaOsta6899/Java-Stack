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

</head>
<body>
<h1 style="text-align:center"><c:out value="${product.getName() }"></c:out></h1>
  <h2>Categories:</h2>
  
	 <c:forEach var="BelongCategory" items="${BelongCategories}">
		 <p>-<c:out value="${product.getName() }"></c:out></p>
	 </c:forEach>
 <h2>Add Category:</h2>	 
 <form action="/products/addCategory/${ product.getId()}" method="post">
 	<select name="c" >
 	<c:forEach var="notBelongCategory" items="${notBelongCategories}">
		<option value="${notBelongCategory.getId() }"> <c:out value="${notBelongCategory.getName() }"></c:out></option>
	 </c:forEach>
	 
	 </select>
	 <input type="submit" value="add">
</form>
	

</body>
</html>