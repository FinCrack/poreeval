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

	<div class="container">
		<button class="btn-default" onclick="createUser()">Als
			Benutzer registrieren</button>
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
				<th class="success">Best Rated</th>
				<th class="danger">Random Product</th>
			</tr>
			<tr>
				<td>Sahnejoghut</td>
				<td>Mio Mio Ginger + Rating</td>
				<td>Milchkaffee</td>
			</tr>
			<tr>
				<td>Kartoffelchips</td>
				<td>Pueblo Tabak + Rating</td>
				<td>Coca Cola</td>
			</tr>
			<tr>
				<td>Humus</td>
				<td>Erdinger Weißbier + Rating</td>
				<td>Pommes</td>
			</tr>
		</table>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>