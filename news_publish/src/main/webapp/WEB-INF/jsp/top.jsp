<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>top.jsp</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//Top Navigation Switch
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
</head>
<body style="background:url(images/topbg.gif) repeat-x;">
    <div class="topleft">
    <a href="main.jsp" target="_parent"><img src="images/logo22.png" title="System_Main_Page" /></a>
    </div>        
    <ul class="nav">   
    </ul>            
    <div class="topright">    
    <ul>
    <li><span><img src="images/help.png" title="Help"  class="helpimg"/></span><a href="#">Help</a></li>
    <li><a href="#">About</a></li>
    <li><a href="#" onclick="logout();">Logout</a></li>
    </ul>
     
    <div class="user">
    <span>${sessionScope.login_user.userName }</span>
    </div>    
    
    </div>
    
    
     <script type="text/javascript">
		function logout(){
			if(window.confirm("Are you sure to logout？"))
			{
			   top.location.href="${pageContext.request.contextPath}/logout.action";
			 }else{
				 return false;
			 }
		}
	</script>
</body>
</html>
