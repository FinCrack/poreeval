<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Poreeval</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	function updateTime() {
		var date = new Date();
		var stunden = date.getHours();
		var minuten = date.getMinutes();
		var tag = date.getDate();
		var monatDesJahres = date.getMonth();
		var jahr = date.getFullYear();
		var tagInWoche = date.getDay();
		var wochentag = new Array("Sonntag", "Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag");
		var monat = new Array("Januar", "Februar", "M&auml;rz", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember");
		var datum = wochentag[tagInWoche] + ", " + tag + ". " + monat[monatDesJahres] + " " + jahr + " " + stunden + ":" + minuten;
		document.getElementById('time').innerHTML = datum;
		setTimeout(updateTime, 60000);
	}
	window.addEventListener("load", updateTime);
</script>
</head>
<body>
	<div id="time">
	</div>
	<h1 style="text-align: center"> Willkommen zu Poreeval! </h1>
	<form action="LoginServlet" method="post" style="float: right;">
	<label>Username:</label><input type="text">	<label>Password:</label><input type="password"><input type="submit" value="Login">
	</form>
	<br>
	<hr>
	
	<div class="container">
		<button class="btn-default" onclick="createUser()">Als Benutzer registrieren</button>	
		<button class="btn-default" onclick="createProduct()">Neues Produkt hinzufügen</button>
	</div>
	<script>
		function createProduct(){
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