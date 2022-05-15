<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/style.css"/>

</head>
<body>
  <section>
        <form action="/process_money/Farm" method="post">
            
            <input type="hidden" name="which_form" value="Farm" >
            <div class="mydiv">
                <p>Farm</p>
                <p>(earns 10 - 20 golds)</p>
                <input type="submit" value="Find Gold">
            </div>
         </form>
         <form action="/process_money/Cave" method="post">
           
            <input type="hidden" name="which_form" value="Cave" >
            <div class="mydiv">
                <p>Cave</p>
                <p>(earns 5 - 10 golds)</p>
                <input type="submit" value="Find Gold">
            </div>
         </form>
         <form action="/process_money/House" method="post">
          
            <input type="hidden" name="which_form" value="House" >
            <div class="mydiv">
                <p>House</p>
                <p>(earns 2 - 5 golds)</p>
                <input type="submit" value="Find Gold">
            </div>
        </form>
        <form action="/process_money/Casino" method="post">
            
            <input type="hidden" name="which_form" value="Casino" >
            <div class="mydiv">
                <p>Casino</p>
                <p>(earns/takes 0 - 50 golds)</p>
                <input type="submit" value="Find Gold">
            </div>
        </form>
    </section>
    <section>
        <textarea name="textArea" cols="150" rows="2">
        <c:out value="${total }" /></textarea>
    </section>
</body>
</html>