<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="nav" uri="/WEB-INF/navigation.tld"%>
<%@ taglib prefix="cprod" uri="/WEB-INF/createProduct.tld" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produkterstellung</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav:navigation></nav:navigation>
	${ message }
	<h1>Erstellen und bewerten Sie ein neues Produkt</h1>
	<cprod:product></cprod:product>
</body>
</html>