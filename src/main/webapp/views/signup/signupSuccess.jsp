<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create an Account</title>
<link href="<c:url value="/resources/styles/signup/signup.css" />" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="signupsuccess">
		<h2>Your account has been created successfully!</h2>
		<p>Your username is <c:out value="${signupForm.username}" />.</p>
		<p>We've sent a confirmation email to <c:out value="${signupForm.email}" />.</p>
		<ul class="links">
			<li>
				<a href="/loginapp/login">Click here to go to the Log In page.</a>
			</li>
		</ul>		
	</div>
	
</body>
</html>