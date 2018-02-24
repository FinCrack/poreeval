<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrierung</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1>Bitte geben Sie ihr Daten an!</h1>
	<div class="container">
		<form action="CreateUserServlet" method="post">
		
			<div class="form-group">
			<label>Rolle</label>
			<select class="form-control" id="role" name="role">
				<option value="RegUser">Benutzer</option>
				<option value="Mod">Moderator</option>
			</select>
			</div>
			
			<div class="form-group">
				<label>Username</label>
				<input type="text" class="form-control" placeholder="Username hinzuf�gen" name="username">
			</div>
			
			<div class="form-group">
				<label>E-Mail</label>
				<input type="email" class="form-control" placeholder="E-Mail hinzuf�gen" name="email">
			</div>
			
			<div class="form-group">
				<label>Password</label>
				<input type="password" class="form-control" placeholder="Password eingeben" name="password1">
			</div>
			
			<div class="form-group">
				<label>Password best�tigen</label>
				<input type="password" class="form-control" placeholder="Password eingeben" name="password2">
			</div>
			
			<button class="btn-default" type="submit">Registrieren</button>
		</form>
		<button class="btn btn-default" onclick="window.location.href='welcome.jsp'">Zur�ck</button>
	</div>
</body>
</html>