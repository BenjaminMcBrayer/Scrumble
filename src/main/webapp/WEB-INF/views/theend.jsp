<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<link href='https://fonts.googleapis.com/css?family=Montserrat'
	rel='stylesheet'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SCRUMBLE</title>
</head>
<style>
body {
	height: 850px;
	background: #ace0ff;
	background: linear-gradient(to bottom right, #8080ff, #4db8ff, #ace0ff);
	font-family: 'Montserrat';
	font-size: 22px;
}

h1 {
	text-align: center;
}

h2 {
	text-align: center;
}

h3 {
	text-align: center;
}

h4 {
	text-align: right;
}

p {
	text-decoration: underline overline;
	text-align: right;
}

div {
	text-align: center;
}

.button {
	background-color: #008CBA;
	border: none;
	color: white;
	padding: 8px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-family: 'Montserrat';
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.button1 {
	font-size: 12px;
}

.button2 {
	font-size: 12px;
}

.button1 {
	border-radius: 8px;
}

.button2 {
	border-radius: 8px;
}
</style>
<body>
<center>
${winner}

<form id="rematch" action="playAgain">
			Would you like to rematch? <br>
			<button class="button button1" type="submit">Rematch</button>
	</form>
	<form id="logout" action="logout2">
		<button class="button button1" type="submit">Logout</button>
	</form>
</center>
</body>
</html>