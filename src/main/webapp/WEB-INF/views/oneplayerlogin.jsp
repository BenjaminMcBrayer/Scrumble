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
	${oneplayerlogin}
	<h1>Are you ready?</h1>
	<h4>If you're new to the game, create an account. If you're an experienced player, just log in.</h4>
	<br>
	<!-- <form action="newPlayer1">
		<select id="nPl1" name="newPlayer1" onChange="hideshowPlayer1()">
			<option selected disabled>Player One: Are you a new player?</option>
			<option value="yes">Yes</option>
			<option value="no">No</option>
		</select>
	</form>
	<br> -->
	<form action="add1" name="registration1" method="post">
		<div id="register1">
			<fieldset>
				<legend>Please create an account.</legend>
				<label for="username">User Name:</label> 
				<input type="text" name="newusername1" id="newusername1" required></input>
				<label for="pword">Password:</label>
				<input type="password" name="newpword1" id="newpword1" required>
				<button type="submit" onclick="hideshowLogin1()">Register</button>
			</fieldset>
		</div>
	</form>
	<br>
	<p>${alreadyexists1}${thankyou1}</p>
	<form action="login1" method="post">
		<div id="login1">
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
	<p>${welcome1}${failure1}</p>
	<h2>How to play:</h2>
	<h4>You will be given a base word.  </h4>
	<h4>Look at the letters in the word and type as many words as you can using only the letters in the base word.</h4>
	<h4>You will have 30 seconds.</h4>
	<form action="play">
		<button id="play" name="play">Play</button>
	</form>
<!-- 	<script type="text/javascript" src="js/hideandseek.js"></script> -->
</body>