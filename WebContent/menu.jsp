<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<title>Hotel Menu LR</title>
	<style>
		body{
			text-align: center;
			margin: 0px;
			font-family: 'Open Sans', sans-serif;
			padding: 0px;
		}
		ul li a{
			text-decoration:none;
			font-size: 20px;
			color: blue;
		}
		a:hover{
			color: pink;
		}
		ul{
			list-style: none;
			justify-content: space-around;
		}
		.menu{
			background: #fff;
			max-width: 1100spx;
			margin: 0 auto;
			width: 500px;
			margin: 0 auto;
			background: linear-gradient(to right, red, yellow, green);	
			border-radius: 30px;
		}
		
	</style>
</head>
<body>
	<header class="menu">
		<nav>
			<ul>
				<li><a href="connection">Checking Database connection</a></li>
				<li><a href="client">Clients</a></li>
				<li><a href="room">Rooms</a></li>
				<li><a href="booking">Booking</a></li>
				<li><a href="setCookie">Set Cookie</a></li>
				<li><a href="getCookie">Get Cookie</a></li>
				<li><a href="setSession">Set and Get Session</a></li>
			</ul>
		</nav>
	</header>
	
</body>
</html>