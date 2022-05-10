<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="js/app.js"></script> 
<title>Insert title here</title>
</head>
<body>
<h1>Send an Omikuji </h1>
<div class="container">
	<form action='/confirm' method='post'>
	<label>Pick Number from 5 to 25</label><br>
	<select name=selectYear>
		<option  value="5">5</option>
		<option  value="6">6</option>
		<option  value="7">7</option>
		<option  value="8">8</option>
		<option  value="9">9</option>
		<option  value="10">10</option>
		<option  value="11">11</option>
		<option  value="12">12</option>
		<option  value="13">13</option>
		<option  value="14">14</option>
		<option  value="15">15</option>
		<option  value="16">16</option>
		<option  value="17">17</option>
		<option  value="18">18</option>
		<option  value="19">19</option>
		<option  value="20">20</option>
		<option  value="21">21</option>
		<option  value="22">22</option>
		<option  value="23">23</option>
		<option  value="24">24</option>
		<option  value="25">25</option>
	</select><br>
	<label>Enter the name of any city</label><br>
	<input type='text' name='person'><br>
	<label>Enter the name of any real person</label><br>
	<input type='text' name='hoppy'><br>
	<label>Enter profissional or any hoppy</label><br>
	<input type='text' name='city'><br>
	<label>Enter any type of living thing</label><br>
	<input type='text' name='living'><br>
	
	
    <input type='submit' value='send'>
    </form>

</div>
</body>
</html>