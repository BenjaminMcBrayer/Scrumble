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
<table border="1">
	<tr>
		<th>Type</th>
		<th>Definition</th>
		<th>Example</th>
	</tr>
	<c:forEach items="${word }" var="text">
	<tr>
		<td>${text.type}</td>
		<td>${text.definition}</td>
		<td>${text.example}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>