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
	<table>
		<thead>
			<tr>
				<td>Name: </td>
				<td>Description: </td>
				<td>Sku: </td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="category" items="${categories}">
					<tr>
						<td><c:out value="${category.name}" /> </td>
						<td><c:out value="${category.description}" /></td>
						<td><c:out value="${category.categoryId}" /></td>
						<td><a href="/delete/${category.id}">Delete</a></td>
					</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>