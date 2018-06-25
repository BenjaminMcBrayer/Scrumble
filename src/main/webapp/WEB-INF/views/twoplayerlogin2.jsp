<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SCRUMBLE</title>
</head>
<body>
${thankyou1}${secondwelcome1}
<h4>PLAYER TWO: If you're new to the game, create an account. If you're an experienced player, just log in.</h4>
	<br>
	<!-- <form action="newPlayer2">
		<select id="nPl2" name="newPlayer2" onChange="hideshowPlayer2()">
			<option selected disabled>Player One: Are you a new player?</option>
			<option value="yes">Yes</option>
			<option value="no">No</option>
		</select>
	</form> -->
	<form action="twoplayeradd2" name="registration2" method="post">
		<div id="register2">
			<fieldset>
			<legend>Please create an account.</legend>
			<label for="username">User Name:</label> 
			<input type="text" name="username2" id="newusername2" required></input>
			<label for="pword">Password:</label>
			<input type="password" name="newpword2" id="newpword2" required>
			<input type="submit" value="Register"></input>
			</fieldset>
		</div>
	</form>
	<br>
	<p>${alreadyexists2}</p>
	<br>
	<form action="twoplayerlogin2" method="post">
		<div id="login2">
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
	<p>${failure2}</p>
	<br>
</body>
</html>