<%@ page import="com.lwr.entity.User"
	contentType="text/html;charset=utf-8"%>
<%@ page import="com.lwr.constant.ConstantName"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/top.jsp"%>
<html>
<head>
<script src="<%=ctx%>/public/jquery-3.4.1.min.js"></script>
</head>
<body>
	<form id="form1" action="<%=ctx%>/user/userList" method="post">
		<div style="margin: 50px 50px;">
			<table border="1">
				<c:if test="${!empty msg}">
					<tr>
						<td colspan="2" align="center" style="color: red"><c:out
								value="${msg }" /></td>
					</tr>
				</c:if>
				<tr>
					<td>昵称：</td>
					<td><input name="name" value='<c:out value="${form.name }"/>'
						type="text"></td>
					<td>开始时间：</td>
					<td><input name="start" placeholder="2010-10-23" value='<fmt:formatDate value="${form.start }" pattern="yyyy-MM-dd"/>'
						type="text"></td>
					<td>结束时间：</td>
					<td><input name="end" value='<fmt:formatDate value="${form.end }" pattern="yyyy-MM-dd"/>'
						type="text"></td>
				<tr>
					<td colspan="6" align="center"><br /> <input type="button"
						value="查询" onclick="doList()" /> &nbsp;</td>
				</tr>
			</table>
			<table border="1">
				<thead>
				    <tr><td>用户id</td><td>昵称</td><td>账号</td><td>手机号码</td><td>创建日期</td></tr>
				</thead>
				<tbody>
				    <c:forEach items="${userList }" var="user">
				        <tr><td><c:out value="${user.id }"/></td><td><c:out value="${user.name }"/></td><td><c:out value="${user.loginId }"/></td><td><c:out value="${user.tel }"/></td><td><fmt:formatDate value="${user.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
				    </c:forEach>
				</tbody>
				<tfoot>
				    <tr>
				    <td colspan="1" align="left">第<input type="number" style="width:30px;" readonly id="pageIndex" name="pageIndex" value="${form.pageIndex }" />页
				    <td colspan="4" align="right">每页<input style="width:50px;" type="number" name="pageSize" value="${form.pageSize }" />条&nbsp; 
				    <a href="javascript:prePage();">上一页</a>&nbsp; <a href="javascript:nextPage();">下一页</a></td></tr>
				</tfoot>
			</table>
		</div>
	</form>
</body>
</html>
<script type="text/javascript">
	function doList() {
		$("#pageIndex").val("1");
		$("#form1").submit();
	}
	function prePage(){
		$("#pageIndex").val($("#pageIndex").val()*1-1);
		$("#form1").submit();
	}
	function nextPage(){
		$("#pageIndex").val(1+1*$("#pageIndex").val());
		$("#form1").submit();
	}
</script>
