<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main Page</title>
</head>
<body>
	<label for="UserInfo">UserInfo:${user_session.username}</label> </br>
	<a href="${pageContext.request.contextPath}/logout">Logout</a>
</body>
</html>