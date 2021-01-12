<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="https://fonts.googleapis.com/css2?family=Open+Sans&display=swap" rel="stylesheet">
	<title>Create client</title>
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
	<h3>New client</h3>
	<form method="post">
		<label>Name</label><br>
		<input name="name"/><br><br>
		<label>Age</label><br>
		<input name="age" type="number"/><br><br>
		<input type="submit" value="Save client" class="save"/>
	</form>
</body>
</html>