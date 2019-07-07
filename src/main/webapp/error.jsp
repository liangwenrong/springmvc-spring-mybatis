<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/top.jsp" %>
<html>
<head>
</head>
<body>
	<c:if test="${!empty msg}">
		<h1><c:out value="${msg }" /></h1>
	</c:if>
	<a href="<%=ctx %>/user/index" style="text-decoration:none;">首页</a>
</body>
</html>
