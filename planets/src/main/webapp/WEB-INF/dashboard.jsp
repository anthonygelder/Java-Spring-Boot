<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
    <h1>Welcome Page <c:out value="${currentUser.firstname}"></c:out></h1>
    <h2>All Planets</h2>
    
    <table>
    	<tr>
    		<th>Name</th>
    		<th>Size</th>
    		<th>Mass</th>
    		<th>Action</th>
    	</tr>
    	<c:forEach items="${planets}" var="planets" varStatus="loop">
    	<tr>
    		<td><a href="/planets/${planets.id}"><c:out value="${planets.name}"/></a></td>
    		<td><c:out value="${planets.size}"/></td>
    		<td><c:out value="${planets.mass}"/></td>
    		<td><a href="/planets/${planets.id}/edit">Edit</a> | <a href="/planets/${planets.id}/destroy">Delete</a></td>
    	</tr>
    	</c:forEach>
    </table>
    <a href="/planets/new">Add Planet</a>
    
    
    
    
    
    
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>