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
<h1 style="text-align:center">Home Page</h1>
 <h6><a href="/products/new">New Product</a></h6><br>
 <h6><a href="/categories/new">New Category</a></h6><br>
 
 <table class="table">
  <thead class="table-dark">
  	<tr>
	  	<td><b>Products</b></td>
	  	<td><b>Categories</b></td>
	  	
  	</tr>
  </thead>
 
  <td>
  	  
	  <c:forEach var="product" items="${products}">
		 <p><a href="/products/${product.getId() }">-<c:out value="${product.getName() }"></c:out></a>  </p>
		  </c:forEach>
	
  </td>
   <td>
	 
	
		  <c:forEach var="category" items="${categories}">
		  <p><a  href="/categories/${category.getId() }">-<c:out value="${category.getName() }"></c:out></a> </p>
		  </c:forEach>
	  
 </td>

  
</table>
</body>
</html>