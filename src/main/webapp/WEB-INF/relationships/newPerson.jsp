<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Person</title>
</head>
<body>
	<h1>New Person</h1>
	<form:form action="/persons/new" method="POST" modelAttribute="person">
		<p>
			<form:errors path="firstName" /><br />
			<form:label path="firstName">First Name</form:label>
			<form:input path="firstName" />
		</p>
		<p>
			<form:errors path="lastName" /><br />
			<form:label path="lastName">Last Name</form:label>
			<form:input path="lastName" />
		</p>
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>