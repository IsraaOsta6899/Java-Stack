<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Nijna</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<form:select path="dojo">
			<c:forEach var="dojo" items="${dojos}" >
			<form:option value="${ dojo}"><c:out value="${ dojo.getName()}"></c:out></form:option>
			</c:forEach>	
		</form:select><br>
		<form:label path="firstName">First Name : </form:label>
		<form:input path="firstName"/><br>
		
		<form:label path="lastName">Last Name : </form:label>
		<form:input path="lastName"/><br>
		
		<form:label path="age">Age : </form:label>
		<form:input path="age"/><br>
		<input type="submit" value="Create">
	</form:form>

</body>
</html>