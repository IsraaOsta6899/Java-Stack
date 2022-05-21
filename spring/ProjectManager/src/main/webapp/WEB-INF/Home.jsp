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


<link rel="stylesheet" href="/style.css"/>
</head>
<body>
<header>
<h1>Welcome, <c:out value="${user.getUserName() }"></c:out></h1>
<h6> <a href="/logout"> Logout</a></h6>
</header><br>

  <div>
  <h3>All projects That you are not in it</h3>
  <a href="/projects/new">+ New Project</a>
  </div>
<table class="table table-striped-columns">
	<tr>
		<th>Project:</th>
		<th>Team Lead</th>
		<th>Due Date</th>
		<th>Actions</th>
		
		
	</tr>
	<c:forEach var="project" items="${projects}" >
	<tr>
		<td>
			<a href="/projects/${project.getId()}"><c:out value="${project.getTitle()}"/></a>
		</td>
		<td>
			<c:out value="${project.getOwner().getUserName()}"/>
		</td>
		<td>
			<c:out value="${project.getDuedate()}"/>
		</td>
		<td>
			<a href="/users/join/${project.getId()}">Join team</a>
		</td>
	</tr>
	</c:forEach>
	
</table>

  <h3>All projects That you are working on it</h3>
 
 
<table class="table table-striped-columns">
	<tr>
		<th>Project:</th>
		<th>Team Lead</th>
		<th>Due Date</th>
		<th>Actions</th>
		
		
	</tr>
	<c:forEach var="project" items="${yourprojects}" >
	<tr>
		<td>
			<a href="/projects/${project.getId()}"><c:out value="${project.getTitle()}"/></a>
		</td>
		<td>
			<c:out value="${project.getOwner().getUserName()}"/>
		</td>
		<td>
			<c:out value="${project.getDuedate()}"/>
		</td>
	<c:choose>
    <c:when test="${user.getUserName()==project.getOwner().getUserName()}">
		<td>
			<a href="/projects/edit/${project.getId()}">Edit </a>
		</td>
    </c:when>    
    <c:otherwise>
		<td>
			<a href="/users/leave/${project.getId()}">leave team</a>
		</td>       <br />
    </c:otherwise>
	
	</c:choose>
		
		
		
		
	</tr>
	</c:forEach>
	
</table>
</body>
</html>