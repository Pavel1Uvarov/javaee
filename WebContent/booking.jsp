<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Bookings</title>
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
		th, td{
			border-style: solid;
			border-width: 0 1px 1px 0;
			border-color: white;
		}
		td{
			background: #D8E6F3;
		}
	</style>
</head>
<body>
	<h2>Bookings List</h2>
	<p><a href='<c:url value="/menu" />'>Back to menu</a></p>
	<p><a href='<c:url value="/createBooking" />'>Create new booking</a></p>
	<p><a href='<c:url value="/searchBooking" />'>Search booking by number</a></p>
	<table>
		<tr>
			<th>Name</th>
			<th>Number</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="booking" items="${bookings}">
 		<tr>
 			<td>${booking.name}</td>
    		<td>${booking.number}</td>
    		<td><a href='<c:url value="/editBooking?id=${booking.id}"/>' class="edit" >Edit booking</a>
    			<form method="post" action='<c:url value="/extractBooking" />'>
        			<input type="hidden" name="id" value="${booking.id}">
        			<input type="submit" value="Delete booking" class="delete">
    			</form>
 			</td>
 		</tr>
		</c:forEach>
	</table>
</body>
</html>