<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/top.jsp" %>
<html>
<head>
</head>
<body>
        <div style="margin:50px 50px;">
			<h2>欢迎您！ 
			<a href="<%=ctx %>/user/logOut" style="text-decoration:none;">退出</a>
			<a href="<%=ctx %>/user/toUpload" style="text-decoration:none;">上传文件</a>
			<a href="<%=ctx %>/user/userList" style="text-decoration:none;">用户查询</a>
			</h2>
            <table border="1">
                <tr>
                    <td>登录名：</td>
                    <td><c:out value="${user.loginId }"/></td>
                </tr>
                <tr>
                    <td>昵称：</td>
                    <td><c:out value="${user.name }"/></td>
                </tr>
                <tr>
                    <td>手机号码：</td>
                    <td><c:out value="${user.tel }"/></td>
                </tr>
                <tr>
                    <td>注册时间：</td>
                    <td><c:out value="${user.createDate }"/></td>
                </tr>
            </table>
        </div>
</body>
</html>
