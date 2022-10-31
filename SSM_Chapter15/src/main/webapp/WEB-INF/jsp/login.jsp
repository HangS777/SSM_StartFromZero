<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<font style="color:Red;">${msg}</font>
	<form action="${pageContext.request.contextPath}/login" method="post">
		 <label for="Login name:">Login name:</label>
         <input type="text" name="username" id="username"/> <br />
         <label for="Password:">Password:</label>
         <input type="password" name="password" id="password" /> <br />
         <input type="submit" value="Login" />
	</form>
</body>
</html>