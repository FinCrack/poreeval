<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="nav" uri="/WEB-INF/navigation.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Poreeval</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav:navigation></nav:navigation>
	<div class="jumbotron text-center">
		<div class="container">
			<h1>Willkommen bei Poreeval!</h1>
		</div>
	</div>
	<div class="container">
		<table
			class="table table-striped tabled-bordered table-hover table-condensed">
			<tr>
				<th>Zuletzt bewertet</th>
				<th class="success">Am besten bewertet</th>
				<th class="danger">Zufälliges Produkt</th>
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
</body>
</html>