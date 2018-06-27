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
    background-color: #008CBA; /* Green */
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
.button2 {font-size: 12px;}
.button1 {border-radius: 8px;}
.button2 {border-radius: 8px;}
</style>
<body>
	${dummylogin}
	<h1>Are you ready?</h1>
	<form action="numPlay">
		<select id="nP" name="numPlayers">
			<option selected disabled>How many players?</option>
			<option value="1">1</option>
			<option value="2">2</option>
		</select>
			<input class="button button1"type="submit" value="Submit">
	</form>
	<br>
	<!-- <form action="newPlayer2">
		<select id="nPl2" name="newPlayer2" onChange="hideshowLogin()">
			<option selected disabled>New Player?</option>
			<option value="yes">Yes</option>
			<option value="no">No</option>
		</select>
	</form>
	<br> -->
	<script type="text/javascript" src="js/hideandseek.js"></script>
</body>
</html>