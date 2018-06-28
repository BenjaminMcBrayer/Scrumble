<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet'>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>It's Scrumble Time!</title>
<style>
body{
    height: 850px;
background:#ace0ff;
background: linear-gradient(to bottom right,#8080ff,#4db8ff,#ace0ff);
font-family: 'Montserrat';font-size: 22px;}
h1 {text-align: center;}
h2 {text-align: center;}
h3{text-align: center;}
h4{text-align: right;}
p {text-decoration: underline overline;text-align: right;}
div{text-align: center;}
.button {
    background-color: #008CBA; /* Green */
    border: none;
    color: white;
    padding: 8px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button1 {font-size: 12px;}
.button2 {font-size: 12px;}
.button1 {border-radius: 8px;}
.button2 {border-radius: 8px;}
</style>
</head>
<body>
<div id="numPlayers" data-prodnumber="${numPlayers}"></div>
	<h1>Let's Get Ready To Scrumble!!!</h1>
	<p>Time left: <span id="count">30</span> seconds...</p>
	<h1>${rootword.wordname }</h1>
	<h2>Words entered:</h2>
	<div id="display"></div>
	<center><div style="background-color: DodgerBlue; width: 45%;" id="score"></div></center>
	<h3>
	<form action="result" method="post" onsubmit="crazy();"></form>
	<form onsubmit="insert(); event.preventDefault();">
		<input id="entry" type="text" placeholder="Word" autofocus/>	 
	</form>
	</h3>
	<center><form action="next" method="post" id="next" >
	<input class="button button1" type="submit" value="Next Player">
	</form>
	<form action="logout2" method="post" id="logout2" >
	<input class="button button1" type="submit" value="Logout">
	</form>
	<form action="logout1" method="post" id="logout1" >
	<input class="button button1" type="submit" value="Logout">
	</form>
	<form action="playAgain" method="post" id="playAgain" >
	<input class="button button1" type="submit" value="Re-Scrumble">
	</form></center>

</body>
<script type="text/javascript">
var numPlayers = ${numPlayers};
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
	function beforeTimer(){
		document.getElementById("entry").style.visibility = "visible";
		document.getElementById("next").style.visibility = "hidden";
		document.getElementById("playAgain").style.visibility = "hidden";
		document.getElementById("logout1").style.visibility = "hidden";
		document.getElementById("logout2").style.visibility = "hidden";
	}
	setTimeout(crazy, 30000);
	setTimeout(next,36000);
	setTimeout(entry1,30000);
	function crazy() {
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				score.innerHTML =this.responseText;
			}
		};
		xhttp.open("POST", "/index", true);
		xhttp.setRequestHeader('Content-type',
				'application/x-www-form-urlencoded');
		xhttp.send("entry=" + entry);
		return true;
	}
	function next(){
		if(numPlayers != "1"){
		document.getElementById("next").style.visibility = "visible";
		document.getElementById("logout2").style.visibility = "visible";
	}else{
		document.getElementById("playAgain").style.visibility = "visible";
		document.getElementById("logout1").style.visibility = "visible";
	}}
	function entry1(){
		document.getElementById("entry").style.visibility = "hidden";
	}
	window.onload = function() {
			console.log("CRAAAAZY FUNCTION ENGAGED!!!");
			console.log(numPlayers);
		(function() {
			beforeTimer();
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