<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SCRUMBLE</title>
</head>
<style>
body{
    height: 850px;
background:#ace0ff;
background: linear-gradient(to bottom right,#8080ff,#4db8ff,#ace0ff);
font-family: 'Montserrat';font-size: 22px;}
.button {
    background-color: #008CBA;
    border: none;
    color: white;
    padding: 8px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button1 {font-size: 12px;}
.button1 {border-radius: 10px;} 
</style>
<body>
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
	<form action="oneplayeradd1" name="registration1" method="post">
		<div id="register1">
			<fieldset>
				<legend>Please create an account.</legend>
				<label for="username">User Name:</label> 
				<input type="text" name="username1" id="newusername1" required></input>
				<label for="pword">Password:</label>
				<input type="password" name="pword1" id="newpword1" required>
				<button class="button button1" type="submit">Register</button>
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
				<input class="button button1" type="submit" value="Login"></input>
			</fieldset>
		</div>
	</form>
	<br>
	<p>${failure1}</p>
	<!-- <h2>How to play:</h2>
	<h4>You will be given a base word.  </h4>
	<h4>Look at the letters in the word and type as many words as you can using only the letters in the base word.</h4>
	<h4>You will have 30 seconds.</h4>
	<form action="play">
		<button id="play" name="play">Play</button>
	</form> -->
</body>