<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link href="<c:url value="/resources/styles/login/login.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<form:form commandName="loginForm" action="login" method="post">
	<div class="field">
		<label for="username">Username: </label>
		<form:input path="username" id="username" />
	</div>
	<div class="field">
		<label for="password">Password: </label>
		<form:password path="password" id="password" />
	</div>
	<div class="formbutton">
		<input type="submit" value="Login!" />
	</div>
</form:form>

</body>
</html>