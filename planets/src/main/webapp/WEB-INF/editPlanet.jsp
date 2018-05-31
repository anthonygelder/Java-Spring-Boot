<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Add a planet</h2>
	<form:form method="POST" action="/planets/${planet.id}" modelAttribute="planet">
    
    	<form:label path="name">Name:
    	<form:input path="name"/></form:label><form:errors path="name"/><br>
    
    	<form:label path="size">Size:
    	<form:input path="size"/></form:label><form:errors path="size"/><br>
    
    	<form:label path="mass">Mass
    	<form:input type="number" path="mass"/></form:label><form:errors path="mass"/><br>
    
    	<input type="submit" value="Submit"/><br>
    	
</form:form>
	<a href="/">Home</a>
</body>
</html>