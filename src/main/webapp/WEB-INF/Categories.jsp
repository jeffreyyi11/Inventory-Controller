<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Categories</title>
</head>
<body>
	<h1>Categories</h1>
	<a href="/addcategory">Add Category</a>
	<c:forEach var="category" items="${categories}">
			<p>
				<c:out value="${category.name}"/>
				<c:out value="${category.description}"/>
			</p>
	</c:forEach>
</body>
</html>