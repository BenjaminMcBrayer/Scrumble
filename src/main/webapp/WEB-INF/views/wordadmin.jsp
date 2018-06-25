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
	crossorigin="anonymous">
<title>ROOTWORDS</title>
</head>
<body>
<div class="container">
		<h3>List of Root-Words</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="word" items="${words}">
					<tr>
						<td>${word.wordname}</td>
						<td><a href="editword?wordid=${word.wordid}">Edit</a>
						<td><a href="deleteword?wordid=${word.wordid}" onclick="myFunction()">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br>
	<div class="container">
		<a href="addnewword?wordid=${word.wordid}">Add a New Word</a>
	</div>
	
<script>
function myFunction() {
    var txt;
    if (confirm("Do you really wish to delete this word?")) {
        txt = "The word has been deleted.";
    } else {
        txt = "";
    }
    document.getElementById("demo").innerHTML = txt;
}
</script>
</body>
</html>