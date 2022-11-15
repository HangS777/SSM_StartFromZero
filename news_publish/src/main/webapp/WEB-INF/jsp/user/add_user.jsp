<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Add User</title>
		<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
    <span>Setting: </span>
    <ul class="placeul">
    <li><a href="#">Main Page</a></li>
    <li><a href="${pageContext.request.contextPath}/findUserList.action">User</a></li>
    </ul>
    </div>    
    <div class="formbody">    
    <div class="formtitle"><span>Add User</span></div>
	   <form action="${pageContext.request.contextPath}/addUser.action" name="ff" method="post" onsubmit="return checkValue()"> 
	   <ul class="forminfo">
    <li><label style="width:150px;">LoginAccount（<font style="color:Red;font-weight:bolder;">*</font>）：</label><input id="loginName" name="loginName" value="${user.loginName}" type="text" class="dfinput" /><i>&nbsp;<font style="color:Red;">${checkUserLoginNameMsg}</font></i></li>
    <li><label style="width:150px;">Password（<font style="color:Red;font-weight:bolder;">*</font>）：</label><input id="password" name="password" type="password" class="dfinput" /><i></i></li>
	<li><label style="width:150px;">UserName（<font style="color:Red;font-weight:bolder;">*</font>）：</label><input id="userName" name="userName"  value="${user.userName}" type="text" class="dfinput" /><i></i></li>
	<li><label style="width:150px;">PhoneNumber：</label><input id="tel" name="tel"  value="${user.tel}" type="text" class="dfinput" /><i></i></li>
    <li><label style="width:150px;">UserRole（<font style="color:Red;font-weight:bolder;">*</font>）：</label>
	<select name="roleId" id="roleId"  class="dfinput">
						<option value="">--Select--</option>
						<c:forEach items="${roleList}" var="r">
							<option value="${r.roleId}" <c:if test="${r.roleId eq user.roleId }">selected="selected"</c:if>>${r.roleName }</option>
						</c:forEach>
				</select>	
	<i></i></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="Confirm Add"/>
    &nbsp;&nbsp;<input name="" type="button" onclick="goback();"class="btn" value="Return List"/></li>
    </ul>
    </form>  
    </div>
    <script>
    function goback(){
    	window.location.href="${pageContext.request.contextPath}/findUserList.action";    	
    }
    function checkValue() {		
		var str = document.getElementById("loginName").value;
		if (str.length < 1) {
			alert("Please input your login name");
			document.getElementById("loginName").focus();
			return false;
		}
		str = document.getElementById("password").value;
		if (str.length < 1) {
			alert("Please input your password");
			document.getElementById("password").focus();
			return false;
		}
		if (str.length > 0 && str.length<6) {
			alert("Password length should greater than 6");
			document.getElementById("password").focus();
			return false;
		}
		str = document.getElementById("userName").value;
		if (str.length < 1) {
			alert("Please input username");
			document.getElementById("userName").focus();
			return false;
		}
		str = document.getElementById("roleId").value;
		if (str == '') {
			alert("Plase select role");
			return false;
		}
		return true;
	}
</script>
</body>
</html>