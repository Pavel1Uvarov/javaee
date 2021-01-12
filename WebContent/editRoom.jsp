<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<title>Edit room</title>
	<style>
		body{
			font-family: 'Open Sans', sans-serif;
		}
		.edit{
			color: black;
			border-radius: 5px; 
			padding: 6px 30px; 
			background-color: white; 
			border-color: black;
			font-family: 'Open Sans', sans-serif;
		    font-size: 16px;
		}
	</style>
</head>
<body>
	<h3>Edit room</h3>
	<form method="post">
		<input type="hidden" value="${room.id}" name="id" />
		<label>Type</label><br>
		<input name="type" value="${room.type}" /><br><br>
		<label>Number</label><br>
		<input name="number" value="${room.number}" type="number"/><br><br>
		<input type="submit" value="Apply" class="edit" />
	</form>
</body>
</html>