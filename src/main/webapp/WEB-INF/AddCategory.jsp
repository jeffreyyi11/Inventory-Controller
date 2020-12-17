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
	<form:form action="/addcategory" method="post" modelAttribute="category">
		<p>
			<form:label path="name">Name: </form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="description">Description: </form:label>
			<form:errors path="description" />
			<form:textarea path="description" />
		</p>
		<p>
			<form:label path="categoryId">Sku: </form:label>
			<form:errors path="categoryId" />
			<form:input path="categoryId" />
		</p>
		<input type="submit" value="Submit" />
	</form:form>
</body>
</html>
