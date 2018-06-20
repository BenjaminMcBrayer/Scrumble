<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="hide();">
	${dummylogin}
	<h1>Are you ready?</h1>
	<form action="numPlay">
		<select id="nP" name="numPlayers" onChange="hideshowNPl1()">
			<option selected disabled>How many players?</option>
			<option value="1">1</option>
			<option value="2">2</option>
		</select>
	</form>
	<form action="newPlayer1">
		<select id="nPl1" name="newPlayer1" onChange="hideshowPlayer1()">
			<option selected disabled>Player One: Are you a new player?</option>
			<option value="yes">Yes</option>
			<option value="no">No</option>
		</select>
	</form>
	<form action="add1" name="registration1" method="post">
		<div id="register1">
			<label for="username">User Name:</label> 
			<input type="text" name="newusername1" id="newusername1" required></input>
			<label for="pword">Password:</label>
			<input type="password" name="newpword1" id="newpword1" required>
			<button type="button" value="Register" onclick=></button>
		</div>
	</form>
	<p>${thankyou1}</p>
	<form action="login1" method="post">
		<div id="login1">
		<label for="username">User Name:</label> 
		<input type="text" name="username1" id="username1" required></input>
		<label for="pword">Password:</label> 
		<input type="password" name="pword1" id="pword1" required></input> 
		<input type="submit" value="Login"></input>
		</div>
	</form>
	<br>
	<p>${welcome1}${failure1}</p>
	<br>
	<p id="welcome2">Welcome, Player Two.</p>
	<form action="newPlayer2">
		<select id="nPl2" name="newPlayer2" onChange="hideshowLogin()">
			<option selected disabled>New Player?</option>
			<option value="yes">Yes</option>
			<option value="no">No</option>
		</select>
	</form>
	<br>
	<p id="registerPlayer2">Player Two, create an account.</p>
	<form action="add2" name="registration2" method="post">
			<label for="username">User Name:</label> 
			<input type="text" name="newusername2" id="newusername2" required></input>
			<label for="pword">Password:</label>
			<input type="password" name="newpword2" id="newpword2" required>
			<input type="submit" value="Register"></input>
	</form>
	<br>
	<p>${thankyou2}</p>
	<br>
	<p id="loginPlayer2">Player Two, please log in.</p>
	<form id="login2" action="login2" method="post">
		<label for="username">User Name:</label> 
		<input type="text" name="username2" id="username2" required></input>
		<label for="pword">Password:</label> 
		<input type="password" name="pword2" id="pword2" required></input> 
		<input type="submit" value="Login"></input>
	</form>
	<br>
	<p>${welcome2}${failure2}</p>
	<br>
	<form action="play">
	<button id="play" name="play">Play</button>
	</form>
	<script type="text/javascript" src="js/hideandseek.js"></script>
</body>
</html>