<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New License</title>
</head>
<body>
	<form:form action="/licenses/new" method="post" modelAttribute="license">
    <p>
        <form:errors path="person.id"/><br />
        <form:label path="person.id">Person</form:label>
        <form:select path="person.id">
        <c:forEach  items="${people}" var="person">
        <form:option value="${person.id}" label="${person.id}-${person.firstName} ${person.lastName}" />
        </c:forEach>
        </form:select>
    </p>
		<p>
        	<form:errors path="expirationDate"/> <br />
       		<form:label path="expirationDate">Expiration Date</form:label>
        	<form:input path="expirationDate" type="date"/>
    	</p>
    	<p>
    		<form:errors path="state" />
    		<form:label path="state">State</form:label>
    		<form:input path="state" type="text" />
    	</p>
    	<form:input path="number" type="hidden" value="00000" />
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>