<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="nav" uri="/WEB-INF/navigation.tld"%>
<%@ taglib prefix="wel" uri="/WEB-INF/welcomeContent.tld"%>
<%@ taglib prefix="rating" uri="/WEB-INF/rating.tld"%>
<%@ taglib prefix="searchR" uri="/WEB-INF/searchResult.tld"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Poreeval</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<c:if test="${ bestRatedProducts == null }">
		<jsp:forward page="/BestRatedServlet" />
	</c:if>
	<nav:navigation></nav:navigation>
	<wel:welcome></wel:welcome>

	<table>
		<tr>
			<rating:best></rating:best>
		</tr>
		<tr>
			<rating:recently></rating:recently>
		</tr>
	</table>
	<searchR:search></searchR:search>

	${ createUserMessage } ${ searchResults } ${ user.userName }

</body>
</html>
