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
${thankyou1}
<form action="secondlogin1" method="post">
		<div id="secondlogin1">
			<fieldset>
			<legend>Please log in.</legend>
				<label for="username">User Name:</label> 
				<input type="text" name="username1" id="username1" required></input>
				<label for="pword">Password:</label> 
				<input type="password" name="pword1" id="pword1" required></input> 
				<input type="submit" value="Login"></input>
			</fieldset>
		</div>
	</form>
	<br>
	<p>${secondwelcome1}${secondfailure1}</p>
	<form action="secondplay">
		<button id="play" name="play">Play</button>
	</form>
</body>
</html>