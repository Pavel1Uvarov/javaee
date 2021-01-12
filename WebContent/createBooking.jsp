<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create booking</title>
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<style>
		body{
			font-family: 'Open Sans', sans-serif;
		}
		.save{
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
	<h3>New booking</h3>
	<form method="post">
		<label>Name</label><br>
		<input name="name"/><br><br>
		<label>Number</label><br>
		<input name="number" type="number"/><br><br>
		<input type="submit" value="Save booking" class="save" />
	</form>
</body>
</html>