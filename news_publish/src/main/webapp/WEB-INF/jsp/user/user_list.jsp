<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
 </head>
<body>
	<div class="place">
    <span>Location：</span>
    <ul class="placeul">
    <li><a href="#">Main Page</a></li>
    <li><a href="#">UserList</a></li>
    </ul>
    </div>    
    <div class="rightinfo">    
    <div class="tools">    
    	<ul class="toolbar">
        <li class="click"><a href="${pageContext.request.contextPath}/toAddUser.action"><span><img src="images/t01.png" /></span>添加用户</a></li>
        </ul>
       </div>
       <form action="${pageContext.request.contextPath}/findUserList.action" id="userListForm"
			name="ff" method="post">
			<ul class="seachform">
				<li><label>&nbsp;&nbsp;&nbsp;&nbsp;Search Keywords:</label>
				<input name="keywords" value="${keywords}" placeholder="Input name or login account" type="text" style="width: 400px;" class="scinput" /></li>
				<li><label style="width: 60px;">Role：</label> <select
					name="userListRoleId" id="userListRoleId" class="dfinput">
						<option value="">--Select--</option>
						<c:forEach items="${roleList}" var="r">
							<option value="${r.roleId}" <c:if test="${r.roleId eq userListRoleId }">selected="selected"</c:if>>&nbsp;&nbsp;&nbsp;&nbsp;${r.roleName }</option>
						</c:forEach>
				</select></li>
				<li><label>&nbsp;</label><input name="" type="submit"
					class="scbtn" value="Search" /></li>
			</ul>
		</form>
       
   		 <table class="tablelist" >
	    	<thead>
	    	<tr>
	        <th style="width:100px;text-align:center;">Username</th>
	        <th style="width:100px;text-align:center;">Login Account</th>
	        <th style="width:100px;text-align:center;">Phone Number</th>
	        <th style="width:100px;text-align:center;">Register Time</th>
	        <th style="width:120px;text-align:center;">User status</th>
	        <th style="width:120px;text-align:center;">Approval Status</th>
	        <th style="width:200px;text-align:center;">Operate</th>
	        </tr>
	        </thead>
				<tbody>
				<c:if test="${!empty userList}">	
					<c:forEach items="${userList}" var="user">	
						<tr>
							<td align="center">${user.userName}</td>
							<td align="center">${user.loginName}</td>
							<td align="center">${user.tel}</td>
							<td align="center"><fmt:formatDate value="${user.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td align="center">${user.roleName}</td>
							<td align="center">
							<c:if test="${user.status=='2'}" var="flag">
								Activated
			                </c:if> 
			                <c:if test="${not flag}">
			                	Not activated or Disabled
			                </c:if>
							</td>
						    <td align="center">
								<a href="${pageContext.request.contextPath}/toEditUser.action?userId=${user.userId}">Edit</a>
								<c:if test="${user.loginName!='admin'}">
								<c:if test="${user.status=='2'}" var="status_flag">
									&nbsp;|&nbsp;<a href='#' onclick="disableUser(${user.userId})">Disable</a>
			                    </c:if> 
			                    <c:if test="${not status_flag}">
			                    	&nbsp;|&nbsp;<a href='#' onclick="enableUser(${user.userId})">Activate</a> 
			                    </c:if>
								&nbsp;|&nbsp;<a href='#' onclick="del(${user.userId})">Delete</a>
								</c:if>
								</td>
						</tr>	
					</c:forEach>		
				</c:if>
			  <c:if test="${empty userList}">
				<div>
					<tr>
					<td colspan="7" align="center">
					No user yet
					</td>
					</tr>  
				</div>
			</c:if>					
          </tbody>
		</table>
	   <script type="text/javascript">
		function disableUser(userId){
			$.ajax({
				url:"${pageContext.request.contextPath }/disableUser.action",
				type:"post",
				data:JSON.stringify({userId:userId,status:3}),
				contentType:"application/json;charset=UTF-8",
				dataType:"json",
				success:function(data){
					if(data!=null){
						if(data.userId>0){
							alert("Disable Success！");
							window.location.reload();							
						}else{
							alert("Disable Failed！");
							window.location.reload();
						}
					}
				}
	  		});
		}
		function enableUser(userId){
			$.ajax({
				url:"${pageContext.request.contextPath }/enableUser.action",
				type:"post",
				data:JSON.stringify({userId:userId,status:2}),
				contentType:"application/json;charset=UTF-8",
				dataType:"json",
				success:function(data){
					if(data!=null){
						if(data.userId>0){
							alert("Activiate Success！");
							window.location.reload();							
						}else{
							alert("Activiate Failed！");
							window.location.reload();
						}
					}
				}
	  		});
		}
		function del(userId){
			if(window.confirm("Are your sure to delete？"))
			{
				$.ajax({
					url:"${pageContext.request.contextPath }/delUser.action",
					type:"post",
					data:JSON.stringify({userId:userId}),
					contentType:"application/json;charset=UTF-8",
					dataType:"json",
					success:function(data){
						if(data!=null){
							if(data.userId>0){
								alert("Delete Success！");
								window.location.reload();							
							}else{
								alert("Delete Failed！");
								window.location.reload();
							}
						}
					}
		  		});
			}
		}
	</script>
    </div>
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>