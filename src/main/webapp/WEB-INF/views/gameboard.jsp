<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Board</title>
</head>
<body>
	<h1>Lets Get Ready To Scrumble!!!</h1>
	<p>
		Time left: <span id="count">30</span> seconds...
	</p>
	<h1>${rootword.wordname }</h1>
	<br>
	<br>
	<h2>Words entered:</h2>
	<br>
	<div id="display"></div>
	<br>
	<div id="score"></div>
	<br>
	<form action="result" method="post" onsubmit="crazy();"></form>
	<form>
		<input id="entry" type="text" placeholder="Word" /> <input
			type="button" value="Save/Show" onclick="insert()" />
	</form>
	<form method="get" action="/addscore">
	<button type="submit">Scores</button>
	</form>
</body>
<script type="text/javascript">
	var entry = [];
	var entryInput = document.getElementById("entry");
	var messageBox = document.getElementById("display");
	var score = document.getElementById("score");
	function insert() {
		entry.push(entryInput.value);
		clearAndShow();
	}
	function clearAndShow() {
		// Clear our fields
		entryInput.value = "";
		messageBox.innerHTML = "";

		messageBox.innerHTML += entry.join(", ") + "<br/>";
	}

	//setTimeout("location.href = '/index';",30000);
	setTimeout(crazy, 30000);
	function crazy() {
		console.log("Crazy");
		console.log(JSON.stringify(entry));
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				//document.getElementById("demo").innerHTML =
				console.log(this.responseText);
				score.innerHTML = "The score is: " + this.responseText;
			}
		};
		xhttp.open("POST", "/index", true);
		xhttp.setRequestHeader('Content-type',
				'application/x-www-form-urlencoded');
		xhttp.send("entry=" + entry);
		//xhttp.send(entry);
		return true;
	}
	window.onload = function() {
		(function() {
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