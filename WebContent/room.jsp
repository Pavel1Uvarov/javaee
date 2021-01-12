<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<title>Rooms</title>
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
	<h2>Rooms List</h2>
	<p><a href='<c:url value="/menu" />'>Back to menu</a></p>
	<p><a href='<c:url value="/createRoom" />'>Create new room</a></p>
	<p><a href='<c:url value="/searchRoom" />'>Search room by type</a></p>
	<table>
		<tr>
			<th>Type</th>
			<th>Number</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="room" items="${rooms}">
		<tr>
			<td>${room.type}</td>
		    <td>${room.number}</td>
		    <td><a href='<c:url value="/editRoom?id=${room.id}"/>' class="edit">Edit room</a>
			    <form method="post" action='<c:url value="/extractRoom" />'>
			        <input type="hidden" name="id" value="${room.id}">
			        <input type="submit" value="Delete room" class="delete">
			    </form>
		 	</td>
		 </tr>
		 </c:forEach>
	</table>
</body>
</html>