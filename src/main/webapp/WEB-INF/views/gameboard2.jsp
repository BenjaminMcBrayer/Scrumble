<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game board 1 of 1</title>
</head>
<style>
h1 {text-align: center;}
h2 {text-align: center;}
h3{text-align: center;}
h4{text-align: right;}
p {text-decoration: underline overline;text-align: right;}
div{text-align: center;}
</style>
<body>
	<h1>Lets Get Ready To Scrumble!!!</h1>
	<p>Time left: <span id="count">30</span> seconds...</p>
	<h1>${rootword.wordname }</h1>
	<br>
	<br>
	<h2>Words entered:</h2>
	<br>
	<div id="display"></div>
	<br>
	<div id="score"></div>
	<br>
	<h3>
	<form action="result" method="post" onsubmit="crazy();"></form>
	<form onsubmit="insert(); event.preventDefault();">
		<input id="entry" type="text" placeholder="Word" /> 
		<input type="submit" value="Save/Show" />
	</form>
	</h3>
	<h4>
	<form method="get" action="/index">
		<button type="submit">Scores</button>
	</form>
	</h4>
	<form id="rematch" action = "playAgain">
	Would you like to rematch? <br><button type="submit">Rematch</button>
	</form>
	<form id="logout" action = "logout2">
	<button type="submit">Logout</button>
	</form>
</body>
<script type="text/javascript">
var s1 = document.getElementById("addPlayer");
	var entry = [];
	var entryInput = document.getElementById("entry");
	var messageBox = document.getElementById("display");
	var score = document.getElementById("score");
	function insert() {
		entry.push(entryInput.value);
		clearAndShow();
	}
	function hideNext() {
		document.getElementById("rematch").style.visibility = "hidden";
		document.getElementById("logout").style.visibility = "hidden";
	}
	function clearAndShow() {
		// Clear our fields
		entryInput.value = "";
		messageBox.innerHTML = "";
		messageBox.innerHTML += entry.join(", ") + "<br/>";
	}
	function beforeTimer(){
		document.getElementById("entry").style.visibility = "visible";
		document.getElementById("rematch").style.visibility = "hidden";
		document.getElementById("playAgain").style.visibility = "hidden";
	}
	setTimeout(crazy,30000);
	setTimeout(next,30000);
	function next(){
		document.getElementById("rematch").style.visibility = "visible";
		document.getElementById("logout").style.visibility = "visible";
	}
	function crazy() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				score.innerHTML = "The score is: " + this.responseText;
			}
		};
		xhttp.open("POST", "/index1", true);
		xhttp.setRequestHeader('Content-type',
				'application/x-www-form-urlencoded');
		xhttp.send("entry=" + entry);
		return true;
	}
	window.onload = function() {
		(function() {
			hideNext();
			var counter = 30;
			setInterval(function() {
				counter--;
				if (counter >= 0) {
					span = document.getElementById("count");
					span.innerHTML = counter;
				}
				// Display 'counter' wherever you want to display it.
				if (counter === -1) {
					clearInterval(counter);
				}
			}, 1000);
		})();
	}
</script>

</html>