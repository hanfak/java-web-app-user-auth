<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to the web app</h1>
	<p>Please choose</p>
	<div>
		<a href="${pageContext.request.contextPath}/register">Register</a>
	</div>
	<div>
		<a href="${pageContext.request.contextPath}/login">Login</a>
	</div>
</body>
</html>