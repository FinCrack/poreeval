<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="nav" uri="/WEB-INF/navigation.tld"%>
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
	<nav:navigation></nav:navigation>
	<div class="jumbotron text-center">
		<div class="container">
			<h1>Willkommen bei Poreeval!</h1>
		</div>
	</div>
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