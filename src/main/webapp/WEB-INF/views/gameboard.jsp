<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Game Board</title>
</head>
<body>
<h1>Lets Get Ready To Scrumble!!!</h1>

<h3>The rootword is: </h3>${rootword }
<br>
<br>

<h6>Words entered:</h6>
<br>
<div id="display"></div>
<br>
<form>
<input id="entry" type="text" placeholder="Word" />
<input type="button" value="Save/Show" onclick="insert()" />
</form>
</body>
<script type="text/javascript">
var entry  = [];
var entryInput  = document.getElementById("entry");
var messageBox  = document.getElementById("display");
function insert ( ) {
	entry.push( entryInput.value );
	clearAndShow();
}
function clearAndShow () {
	  // Clear our fields
	  entryInput.value = "";
	  messageBox.innerHTML = "";
	  
	  messageBox.innerHTML += "Entry Words: " + entry.join(", ") + "<br/>";
}


        </script>
</html>