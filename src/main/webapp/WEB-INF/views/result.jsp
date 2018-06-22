<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Scrumble</title>
</head>
<body>
<h2>Congratulations! You have Scrumbled!</h2>
<h3>Your score is:  ${score }</h3> 

<h3>Your max score is:  ${maxscore }</h3> 

<h3>Your max score for this word is:  ${maxwordscore }</h3> 

<h3>The average score for this word is:  ${avgwordscore }</h3>
<form action="playAgain">
<h4>
Would you like to Re-Scrumble?
<input  type="submit" value="Re-Scrumble">
</h4>
</form>

</body>
</html>