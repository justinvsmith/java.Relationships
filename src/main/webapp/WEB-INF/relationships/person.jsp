<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${people.firstName}"/> <c:out value="${people.lastName}"/></h1>
	<table>
		<tr>
			<td>License Number:</td>
			<td><c:out value="${people.license.number}" /></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><c:out value="${people.license.state}" /></td>
		</tr>
		<tr>
			<td>Expiration Date:</td>
			<td><c:out value="${people.license.expirationDate}" /></td>
		</tr>
	</table>

</body>
</html>