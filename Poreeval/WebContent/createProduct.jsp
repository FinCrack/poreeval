<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produkterstellung</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="true">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="welcome.jsp">Home</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Login <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li>
								<form action="LoginServlet" method="post">
									<label>Username:</label><input type="text" name="username">
									<label>Password:</label><input type="password" name="password">
									<button type="submit">Login</button>
									<button type="submit">Login</button>
								</form>
							</li>
						</ul></li>
					<li><a href="createUser.jsp" role="button"
						aria-haspopup="true" aria-expanded="false">Registrieren</a>
						<ul class="dropdown-menu">
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Produktsuche <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li>
								<form action="SearchProductServlet" method="post">
									<label>Produktname:</label><input type="text"
										name="productname">
									<button type="submit">Login</button>
								</form>
							</li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Menü <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="createProduct.jsp">Produkterstellung</a></li>
							<li><a href="editProduct.jsp">Produkte editieren</a></li>
							<li><a href="giveReview.jsp">Review abgeben</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
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