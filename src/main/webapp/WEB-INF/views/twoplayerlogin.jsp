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
	${dummylogin}
	<h1>Are you ready?</h1>
	<form action="numPlay">
		<select id="nP" name="numPlayers">
			<option selected disabled>How many players?</option>
			<option value="1">1</option>
			<option value="2">2</option>
		</select>
			<input type="submit" value="Submit">
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