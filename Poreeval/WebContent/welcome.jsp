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
 	<c:if test="${ recentlyRatedProducts == null }">
		<jsp:forward page="/RecentlyRatedServlet" />
	</c:if> 
	<nav:navigation></nav:navigation>
	<wel:welcome></wel:welcome>
    ${ message }
	<table class="text-center">
		<tr>
			<td><rating:best></rating:best></td><td><rating:recently></rating:recently></td>
		</tr>
	</table>
	<searchR:search></searchR:search>
</body>
</html>
