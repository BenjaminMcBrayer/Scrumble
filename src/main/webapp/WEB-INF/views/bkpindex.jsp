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
<h1>Let's get ready to SCRUMBLE!!!</h1>

<form action="bkpindex">
Enter a word<input type="text" name="entry">
<input type="submit" value="Submit">
</form>
<br>
${response }

</body>
</html>