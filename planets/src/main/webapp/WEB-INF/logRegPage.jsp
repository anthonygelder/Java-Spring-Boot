<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>
<body>
    <h1>Welcome!</h1>
    
    
    <h1>Register</h1>
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="firstname">First Name:</form:label>
            <form:input path="firstname"/>
        </p>
        <p>
            <form:label path="lastname">Last Name:</form:label>
            <form:input path="lastname"/>
        </p>   
        <p>
            <form:label path="username">Username:</form:label>
            <form:input path="username"/>
        </p>
        <p>
            <form:label path="city">City:</form:label>
            <form:input path="city"/>
        </p>
        <p>	State:
			<select name="state">        
        	<option>AL</option><option>AZ</option><option>AR</option><option>CA</option>
        	<option>CO</option><option>CT</option><option>DE</option><option>FL</option>
        	<option>GA</option><option>HI</option><option>ID</option><option>IL</option>
        	<option>IN</option><option>IA</option><option>KS</option><option>KY</option>
        	<option>LA</option><option>ME</option><option>MD</option><option>MA</option>
        	<option>MI</option><option>MN</option><option>MS</option><option>MO</option>
        	<option>MT</option><option>NE</option><option>NV</option><option>NH</option>
        	<option>NJ</option><option>NM</option><option>NY</option><option>NC</option>
        	<option>ND</option><option>OH</option><option>OK</option><option>OR</option>
        	<option>PA</option><option>RI</option><option>SC</option><option>SD</option>
        	<option>TN</option><option>TX</option><option>UT</option><option>VT</option>
        	<option>VA</option><option>WA</option><option>WV</option><option>WI</option>
        	<option>WY</option>
        	</select> 
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>

	<c:if test="${logoutMessage != null}">
        <c:out value="${logoutMessage}"></c:out>
    </c:if>
    <h1>Login</h1>
    <c:if test="${errorMessage != null}">
        <c:out value="${errorMessage}"></c:out>
    </c:if>
    <form method="POST" action="/login">
        <p>
            <label for="username">Username</label>
            <input type="text" id="username" name="username"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Login!"/>
    </form>
</body>
</html>