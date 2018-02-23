<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Poreeval</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style>
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}
</style>
</head>
<body>
	<div class="jumbotron text-center">
		<div class="container">
			<h1>Willkommen bei Poreeval!</h1>
		</div>
	</div>
	
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
				<a class="navbar-brand" href="welcome.jsp">Poreeval</a>
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
								</form>
							</li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Login</a></li>
							<li><a href="#">Produktsuche</a></li>
							<li><a href="#">Produkterstellung</a></li>
							<li><a href="#">Produkte editieren</a></li>
							<li><a href="#">Review abgeben</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<button class="btn-default" onclick="createUser()">Als
			Benutzer registrieren</button>
		<button class="btn-default" onclick="createProduct()">Neues
			Produkt hinzufügen</button>
	</div>

	<script>
		function createProduct() {
			window.location.href = "createProduct.jsp";
		}
		function createUser() {
			window.location.href = "createUser.jsp";
		}
	</script>
	<!-- Nur Beispiele natürlich ihr kleinen Zuckerschnuten -->
	<div class="container">
		<table
			class="table table-striped tabled-bordered table-hover table-condensed">
			<tr>
				<th>Recently Reviewed</th>
				<th>Random Product</th>
				<th>Best Rated</th>
			</tr>
			<tr class="danger">
				<td>Sahnejoghut</td>
				<td>Kartoffelchips</td>
				<td>Humus</td>
			</tr>
			<tr class="success">
				<td>Milchkaffee</td>
				<td>Coca Cola</td>
				<td>Pommes</td>
			</tr>
			<tr>
				<td>Mio Mio Ginger + Rating</td>
				<td>Pueblo Tabak + Rating</td>
				<td>Erdinger Weißbier + Rating</td>
			</tr>
		</table>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>