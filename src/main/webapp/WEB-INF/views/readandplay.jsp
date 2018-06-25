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
${welcome1}${welcome2}${secondwelcome2}
<h2>How to play:</h2>
	<h4>You will be given a base word.  </h4>
	<h4>Look at the letters in the word and type as many words as you can using only the letters in the base word.</h4>
	<h4>You will have 30 seconds.</h4>
	<form action="play">
		<button id="play" name="play">Play</button>
	</form>
</body>
</html>