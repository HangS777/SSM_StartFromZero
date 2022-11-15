<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>left.jsp</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//Navigation Switch
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>
</head>
<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>Manage Menu</div>
	<c:choose>
		<c:when test="${sessionScope.login_user.roleId==1}">
			<dl class="leftmenu">				
				<dd>
					<div class="title">
						<span><img src="images/leftico04.png" /></span>User Manage
					</div>
					<ul class="menuson">
						<li><cite></cite><a href="${pageContext.request.contextPath}/findUserList.action"
							target="rightFrame">User List</a><i></i></li>
						<li><cite></cite><a href="${pageContext.request.contextPath}/toAddUser.action"
							target="rightFrame">Add User</a><i></i></li>
					</ul>
				</dd>
				<dd>
					<div class="title">
						<span><img src="images/leftico02.png" /></span>News Category Manage
					</div>
					<ul class="menuson">
						<li><cite></cite><a href="${pageContext.request.contextPath}/findCategoryList.action"
							target="rightFrame">News Category List</a><i></i></li>
					</ul>
				</dd>
			</dl>
		</c:when>
		<c:when test="${sessionScope.login_user.roleId==2}">
			<dl class="leftmenu">
				<dd>
					<div class="title">
						<span><img src="images/leftico01.png" /></span>News Manage
					</div>
					<ul class="menuson">
						<li><cite></cite><a href="${pageContext.request.contextPath}/findNewsByPage.action"
							target="rightFrame">News List</a><i></i></li>
						<li><cite></cite><a href="${pageContext.request.contextPath}/toAddNews.action"
							target="rightFrame">Publish News</a><i></i></li>
					</ul>
				</dd>
			</dl>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</body>
</html>