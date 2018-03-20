<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="nav" uri="/WEB-INF/navigation.tld"%>
<%@ taglib prefix="edit" uri="/WEB-INF/editProduct.tld"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<nav:navigation></nav:navigation>
	${message}
	<h1>Bearbeitung von Produkten</h1>
	<edit:edit></edit:edit>
</body>
</html>