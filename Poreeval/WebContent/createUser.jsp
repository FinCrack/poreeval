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
				<label>Nachname</label>
				<input type="text" class="form-control" placeholder="Namen hinzufügen" name="lastname">
			</div>
			
			<div class="form-group">
				<label>Vorname</label>
				<input type="text" class="form-control" placeholder="Namen hinzufügen" name="firstname">
			</div>
			
			<div class="form-group">
				<label>E-Mail</label>
				<input type="email" class="form-control" placeholder="E-Mail hinzufügen" name="email">
			</div>
			
			<button class="btn-default" type="submit">Registrieren</button>
		</form>
		<button class="btn btn-default" onclick="window.location.href='welcome.jsp'">Zurück</button>
	</div>
</body>
</html>