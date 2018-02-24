<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="nav" uri="/WEB-INF/navigation.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrierung</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav:navigation></nav:navigation>
	<h1 style="text-align:center">Bitte geben Sie ihre Daten an!</h1>
	<div class="container">
		<form action="CreateUserServlet" method="post">

			<div class="form-group">
				<label>Rolle</label> <select class="form-control" id="role"
					name="role">
					<option value="RegUser">Benutzer</option>
					<option value="Mod">Moderator</option>
				</select>
			</div>

			<div class="form-group">
				<label>Username</label> <input type="text" class="form-control"
					placeholder="Username eingeben" name="username">
			</div>

			<div class="form-group">
				<label>E-Mail</label> <input type="email" class="form-control"
					placeholder="E-Mail eingeben" name="email">
			</div>

			<div class="form-group">
				<label>Passwort</label> <input type="password" class="form-control"
					placeholder="Passwort eingeben" name="password1">
			</div>

			<div class="form-group">
				<label>Passwort bestätigen</label> <input type="password"
					class="form-control" placeholder="Passwort bestätigen"
					name="password2">
			</div>

			<button class="btn-default" type="submit">Registrieren</button>
		</form>
		<button class="btn-default"
			onclick="window.location.href='welcome.jsp'">Zurück</button>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>