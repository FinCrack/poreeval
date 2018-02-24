<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="nav" uri="/WEB-INF/navigation.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produkterstellung</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav:navigation></nav:navigation>
	<h1>Erstellen und bewerten Sie ein neues Produkt</h1>
	<div class="container">
		<form action="CreateProductServlet" method="post">
			<div class="form-group">
				<label>Produktname</label> <input type="text" class="form-control"
					placeholder="Namen hinzufügen" name="productname">
			</div>

			<div class="form-group">
				<label>EAN-Code</label> <input type="number" class="form-control"
					placeholder="EAN ist optional" name="ean">
			</div>

			<div class="form-group">
				<label>Notiz</label>
				<textarea class="form-control" placeholder="Notiz hinzufügen"
					name="note">
				</textarea>
				<!--  Schließendes Tag nicht vergessen! :) -->
			</div>

			<div class="form-group">
				<label>Bewertung</label> <select class="form-control" name="rating"
					id="rating">
					<option value="1 Star">1 Stern</option>
					<option value="2 Star">2 Stern</option>
					<option value="3 Star">3 Stern</option>
					<option value="4 Star">4 Stern</option>
					<option value="5 Star">5 Stern</option>
				</select>
			</div>

			<div class="form-group">
				<label>Bild</label> <label>Datei hochladen</label> <input
					type="file" name="image">
				<p class="help-block">Nur .png und .jpg erlaubt</p>
			</div>
			<button class="btn-default" type="submit">Produkt erstellen</button>
		</form>
		<button class="btn-default"
			onclick="window.location.href='welcome.jsp'">Zurück</button>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>