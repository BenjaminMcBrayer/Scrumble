<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="hideNPl(); hideLogin();">
	${dummylogin}
	<h1>Get ready to SCRUMBLE!!!</h1>
	<form action="numPlay">
		<select id="nP" name="numPlayers" onChange="hideshowNPl()">
			<option selected disabled>How many players?</option>
			<option value="1">1</option>
			<option value="2">2</option>
		</select>
	</form>
	<br>
	<form action="newPlay">
		<select id="nPl" name="newPlayer" onChange="hideshowLogin()">
			<option selected disabled>New Player?</option>
			<option value="yes">Yes</option>
			<option value="no">No</option>
		</select>
	</form>
	<br>
	<form id="login" action="login" method="post">
		<!-- User Name -->
		<label for="username">User Name</label> <input type="email"
			name="email" placeholder="User Name" required></input>
		<!-- Password -->
		<label for="pword">Password</label> <input type="password"
			name="pword" placeholder="Password" required></input> <input
			type="submit" value="Login"></input>
	</form>
	<script>
		function hideshowNPl() {
			var s1 = document.getElementById("nP");
			var s2 = document.getElementById("nPl");
			if (s1.options[s1.selectedIndex].text == "How many players?") {
				s2.style.visibility = "visible";
				document.getElementById("nPl").style.visibility = "hidden";
			}
			if (s1.options[s1.selectedIndex].text == "1"
					|| s1.options[s1.selectedIndex].text == "2") {
				s2.style.visibility = "hidden";
				document.getElementById("nPl").style.visibility = "visible";
			}
		}
		function hideNPl() {
			document.getElementById("nPl").style.visibility = "hidden";
		}
		function hideshowLogin() {
			var s3 = document.getElementById("nPl");
			var s4 = document.getElementById("login");
			if (s3.options[s3.selectedIndex].text == "Yes") {
				s4.style.visibility = "visible";
				document.getElementById("login").style.visibility = "hidden";
			}
			if (s3.options[s3.selectedIndex].text == "No") {
				s4.style.visibility = "hidden";
				document.getElementById("login").style.visibility = "visible";
			}
		}
		function hideLogin() {
			document.getElementById("login").style.visibility = "hidden";
		}
	</script>
</body>
</html>