<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/editUsers" method="post">
		<table>
			<tr>
				<td>Selection</td>
				<td>User Name</td>
			</tr>
			<tr>
				<td>
					<input name="users[0].id" value="1" type="checkbox">
				</td>
				<td>
					<input name="users[0].username" value="zhangsan" type="text">
				</td>
			</tr>
			<tr>
				<td><input name="users[1].id" value="2" type="checkbox"></td>
				<td>
					<input name="users[1].username" value="lisi" type="text">
				</td>
			</tr>
		</table>
		<input type="submit" value="Edit" />
	</form>
</body>
</html>