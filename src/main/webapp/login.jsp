<%@ page import="com.lwr.entity.User" contentType="text/html;charset=utf-8"%>
<%@ page import="com.lwr.constant.ConstantName"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/top.jsp" %>
<% 
User user = (User)session.getAttribute(ConstantName.SESSION_USER);
if(user!=null && !"".equals(user.getLoginId())){
	response.sendRedirect(request.getContextPath()+"/user/index");
	return;
}
%>
<html>
<head>
    <script src="<%=ctx %>/public/jquery-3.4.1.min.js"></script>
</head>
<body>
	<form id="form1" action="<%=ctx %>/login/login" method="post">
		<div style="margin:50px 50px;">
			<table>
				<c:if test="${!empty msg}">
				<tr><td colspan="2" align="center" style="color: red"><c:out value="${msg }"/></td></tr>
				</c:if>
				<tr>
					<td>用户名：</td>
					<td><input name="loginId" value='<c:out value="${loginId }"/>'
						type="text"></td>
				</tr>
				<tr>
					<td>密 码：</td>
					<td><input name="password" type="password"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><br/>
					   <input type="button" value="登录" onclick="doLogin()"/>
					   &nbsp;<a href="<%=ctx %>/login/toRegister" style="text-decoration:none;">注册</a>
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
<script type="text/javascript">
function doLogin(){
    var loginId = $("input[name='loginId']").val();
    if(loginId==null || loginId==""){
    	alert("用户名不能为空");
    	return;
    }
    var password = $("input[name='password']").val();	
    if(password==null || password==""){
    	alert("密码不能为空");
    	return;
    }
    $("#form1").submit();
}
</script>
