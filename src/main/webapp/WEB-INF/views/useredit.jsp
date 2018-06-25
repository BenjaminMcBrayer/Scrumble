<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous"><title>Edit User</title>
</head>
<body>
<h2> Update a User</h2>	
<form action="useredit">
		<input type="hidden" name="userid" value="${user.userid}">
		<table>
			<tr>
				<td>User ID</td>
				<td>${user.userid}</td>
			</tr>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username" value="${user.username}"></input></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="pword" value="${user.pword}"></input></td>
			</tr>
		</table>
		<input id="submitBtn" type="submit" value="Update"></input>
	</form>
</body>
</html>