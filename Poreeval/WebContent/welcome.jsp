<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Poreeval</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1 style="text-align: center"> Willkommen zu Poreeval! </h1>
	<form action="LoginServlet" method="post" style="float: right;">
	<label>Username:</label><input type="text">	<label>Password:</label><input type="password"><input type="submit" value="Login">
	</form>
	<br>
	<hr>
	
	<div class="container">
		<button class="btn-default" onclick="createUser()">Als Benutzer registrieren</button>	
		<button class="btn-default" onclick="changePage()">Neues Produkt hinzufügen</button>
	</div>
	<script>
		function changePage(){
			window.location.href = "createProduct.jsp";
		}
		function createUser(){
			window.location.href = "createUser.jsp";
		}
	</script>
	<!-- Nur Beispiele natürlich ihr kleinen Zuckerschnuten -->
	<div class="container">
		<table class="table table-striped tabled-bordered table-hover table-condensed">
		<tr> 
			<th> Recently Reviewed </th>
			<th> Random Product </th>
			<th> Best Rated </th>
		</tr>
		<tr class="danger"> 
			<td> Sahnejoghut </td>
			<td> Kartoffelchips </td>
			<td> Humus </td>
		</tr>
		<tr class="success"> 
			<td> Milchkaffee </td>
			<td> Coca Cola </td>
			<td> Pommes </td>
		</tr>
		<tr> 
			<td> Mio Mio Ginger + Rating</td>
			<td> Pueblo Tabak + Rating </td>
			<td> Erdinger Weißbier + Rating </td>
		</tr>
		</table>
	</div>
</body>
</html>