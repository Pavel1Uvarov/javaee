<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<title>Clients</title>
	<style>
		body{
			font-family: 'Open Sans', sans-serif;
		}
		a{
			color: black;
			text-decoration:none;
			padding: 5px 30px; 
			border: 1px solid black;
		}
		.delete{
			color: black;
			border-radius: 5px; 
			padding: 6px 30px; 
			background-color: white; 
			border-color: black;
			font-family: 'Open Sans', sans-serif;
   		 	font-size: 16px;
		}
		form{
			display:inline;
		}
		.edit{
			text-decoration: none; 
			color: black; 
			padding: 5px 30px; 
			border: 2px solid black; 
			border-radius: 5px; 
			display: inline-block
		}
		table{
			border-collapse: collapse;
			text-align: center;
		}
		th{
			background: #AFCDE7;
			color: white;
			padding: 10px 20px;
		}
		th, td {
			border-style: solid;
			border-width: 0 1px 1px 0;
			border-color: white;
		}
		td {
			background: #D8E6F3;
		}
	</style>
</head>
<body>
	<h2>Clients List</h2>
	<p><a href='<c:url value="/menu" />'>Back to menu</a></p>
	<p><a href='<c:url value="/createClient" />'>Create new client</a></p>
	<p><a href='<c:url value="/searchClient" />'>Search client by age</a></p>
	<table>
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="client" items="${clients}">
	 	<tr>
	 		<td>${client.name}</td>
	    	<td>${client.age}</td>
	    	<td><a href='<c:url value="/editClient?id=${client.id}"/>' class="edit">Edit client</a>
	    		<form method="post" action='<c:url value="/extractClient" />'>
	        		<input type="hidden" name="id" value="${client.id}">
	        		<input type="submit" class="delete" value="Delete client">
	    		</form>
	 		</td>
	 	</tr>
		</c:forEach>
	</table>
</body>
</html>