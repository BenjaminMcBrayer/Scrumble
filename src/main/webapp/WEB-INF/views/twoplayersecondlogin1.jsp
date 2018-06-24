<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>${thankyou2}</p>
	<br>
	<form action="secondlogin2" method="post">
		<div id="secondlogin2">
		<fieldset>
		<legend>Please log in.</legend>
		<label for="username">User Name:</label> 
		<input type="text" name="username2" id="username2" required></input>
		<label for="pword">Password:</label> 
		<input type="password" name="pword2" id="pword2" required></input> 
		<input type="submit" value="Login"></input>
		</fieldset>
		</div>
	</form>
	<br>
	<p>${secondwelcome2}${secondfailure2}</p>
	<br>
</body>
</html>