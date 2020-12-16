<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add Category</title>
</head>
<body>
	<h1>Add Category</h1>
	<form:form action="/addcategory" method="Post" modelAttribute="category">
		<p>
			<label for="name">Name:</label>
			<input type="text" name="name" />
		</p>
		<p>
			<label for="description">Description:</label>
			<input type="text" name="description" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>
