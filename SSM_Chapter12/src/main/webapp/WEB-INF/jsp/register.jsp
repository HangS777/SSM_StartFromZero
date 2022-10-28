<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/registerUser" method="post">
         <label for="Username">Username:</label>
         <input type="text" name="username" /> <br />
         <label for="Password">Password:</label>
         <input type="password" name="password" /> <br />
         <input type="submit" value="Submit" />
    </form>
</body>