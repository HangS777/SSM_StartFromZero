<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RESTful TEST</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" ></script>
<script type="text/javascript">
	function search() {
		var id = $("#number").val();
		$.ajax({
			url:"${pageContext.request.contextPath}/customer/" + id,
			type:"GET",
			dataType:"json",
			success:function(data) {
				if (data.loginname != null) {
					alert("The search result's loginname = " + data.loginname);
				} else {
					alert("No customer found with id = " + id);
				}
			}
		});
	}
</script>
</head>
<body>
	<form>
		<label for="CustomerID">CustomerID:</label>
         <input type="text" name="number" id="number" /> <br />
         <input type="button" value="Search" onclick="search()" />
	</form>
</body>
</html>