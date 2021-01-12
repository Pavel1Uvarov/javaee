<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<title>Find Room</title>
	<style>
		body{
			font-family: 'Open Sans', sans-serif;
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
<h2>Find List</h2>
	<table>
		<tr>
			<th>Type</th>
			<th>Number</th>
		</tr>
		<c:forEach var="room" items="${rooms}">
		 <tr>
		 	<td>${room.type}</td>
		    <td>${room.number}</td>
		 </tr>
		</c:forEach>
	</table>
</body>
</html>