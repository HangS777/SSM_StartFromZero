<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>测试JSON交互</title>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js">
	</script>
	<script type="text/javascript">
		function testJson() {
			var loginname=$("#loginname").val();
			var password=$("#password").val();
			$.ajax({
				url:"${pageContext.request.contextPath }/testJson",
				type:"post",
				data:JSON.stringify({loginname:loginname,password:password}),
				contentType:"application/json;charset=UTF-8",
				dateType:"json",
				success:function(data) {
					if (data != null) {
						alert("Your input loginname is " + data.loginname + ", password is " + data.password);
					}
				}
			});
		}
	</script>
</head>
<body>
	<form>
	     <label for="Loginname:">Loginname:</label>
         <input type="text" name="loginname" id="loginname"/> <br />
         <label for="Password:">Password:</label>
         <input type="text" name="password" id="password" /> <br />
         <input type="button" value="Json Test" onclick="testJson()" />
	</form>
</body>
</html>