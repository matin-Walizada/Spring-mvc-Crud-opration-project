  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head >
<body  background="img/data4.jpg"  >

	<div class="container" style="width: 30%"  >
   <img alt="there is no img" src="img/kayhan.JPG" style="width: 50%">
		<h2 style="color:white">please log in</h2>
		<span  style="color: orange">${errorMessage}</span>
		<hr>
		<form action="signIn" method="post">
			<div class="form-group">
				<label style="color:white"  for="username">User:</label> 
				<input type="text" class="form-control"   placeholder="Enter username" name="username">
			</div>
			<div class="form-group">
				<label style="color:white" for="pwd">Password:</label> 
				<input type="text" class="form-control"   placeholder="Enter password" name="pwd">
			</div>
			 
			<button type="submit" class="btn btn-success">Login</button>
		</form>
	</div>




</body>
</html>