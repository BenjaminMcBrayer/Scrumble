<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Get ready to SCRUMBLE!!</h1>
<h2>Please Login</h2>
 <select name="players">
  <option value="1">1</option>
  <option value="2">2</option>
  </select> 
<br>
<form action="/newplayer">
<input type="checkbox" name="newplayer" value="New Player"> New Player<br>
<h2>Please login</h2>
<br>
</form>
 <form action="/index">
  Username:<br>
  <input type="text" name="username" value="Username"><br>
  Password:<br>
  <input type="text" name="password" value="Password"><br><br>
  <input type="submit" value="Submit">
</form> 
</body>
</html>