<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Student</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/findStudentWithBanji" method="post">
		 <label for="Student ID:">Student ID:</label>
         <input type="text" name="stu_id" /> <br />
         <label for="Class name:">Class name:</label>
         <input type="text" name="banji.banji_name" /> <br />
         <input type="submit" value="Find" />
	</form>
</body>
</html>