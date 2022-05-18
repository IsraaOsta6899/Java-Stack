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
    <section class="registration">
        <form:form action="/register" method="post" modelAttribute="newUser">
            
            <h2>Registration</h2>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Name:</span>
            	<form:input path="userName"  class="form-control" placeholder="first name" aria-label="Username" aria-describedby="basic-addon1" name="first_name" />
           		<form:errors path="userName"></form:errors>
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Email:</span>
            	<form:input path="email"  class="form-control" placeholder="first name" aria-label="Username" aria-describedby="basic-addon1" name="first_name" />
           		<form:errors path="email"></form:errors>
           		
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Password:</span>
            	<form:input path="password"  class="form-control" placeholder="first name" aria-label="Username" aria-describedby="basic-addon1" name="first_name" />
                <form:errors path="password"></form:errors>
            
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Confirm Password:</span>
            	<form:input path="confirm"  class="form-control" placeholder="first name" aria-label="Username" aria-describedby="basic-addon1" name="first_name" />
                <form:errors path="confirm"></form:errors>
           
            </div>
            
            <button type="submit" class="btn btn-primary">Register</button>
            
        </form:form>
    </section>
    <section class="login">
        <form:form action="/login" method="post" modelAttribute="newLogin">
           
            <h2>Login</h2>
           
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Email Address:</span>
            	<form:input path="email"  class="form-control" placeholder="first name" aria-label="Username" aria-describedby="basic-addon1" name="first_name" />
           	    <form:errors path="email"></form:errors>
           	
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">Password:</span>
            	<form:input path="password"  class="form-control" placeholder="first name" aria-label="Username" aria-describedby="basic-addon1" name="first_name" />
                <form:errors path="password"></form:errors>
                
            
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
           
           

        </form:form>

    </section>
</body>
</html>