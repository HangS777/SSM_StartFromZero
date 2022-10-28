<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Course List</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/deleteCourse" method="post">
		<table>
			<tr>
				<td>Selection</td>
				<td>Course Name</td>
			</tr>
			<tr>
				<td><input name="ids" value="1" type="checkbox"></td>
				<td>Java Programming</td>
			</tr>
			<tr>
				<td><input name="ids" value="2" type="checkbox"></td>
				<td>MySQL Database</td>
			</tr>
			<tr>
				<td><input name="ids" value="3" type="checkbox"></td>
				<td>Java Web</td>
			</tr>
		</table>
		<input type="submit" value="Delete" />
	</form>
</body>
</html>