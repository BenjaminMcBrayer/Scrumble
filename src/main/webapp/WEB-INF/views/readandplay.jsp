<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
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
    font-family : inherit;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button1 {font-size: 12px;}
.button1 {border-radius: 8px;}
</style>
<body>
${welcome1}${welcome2}${secondwelcome2}${thankyou1}
<h2>How to play:</h2>
	<h4>You will be given a base word.  </h4>
	<h4>Look at the letters in the word and type as many words as you can using only the letters in the base word.</h4>
	<h4>You will have 30 seconds.</h4>
	<form action="play">
		<button class="button button1" id="play" name="play">Play</button>
	</form>
</body>
</html>