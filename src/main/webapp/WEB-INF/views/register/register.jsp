<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/top.jsp" %>
<html>
<head>
    <script src="<%=ctx %>/public/jquery-3.4.1.min.js"></script>
</head>
<body>
	<form id="form1" action="<%=ctx %>/login/saveRegister" method="post">
		<div style="margin:50px 50px;">
			<table>
			    <tr>
                    <td>用户名：</td>
                    <td><input name="loginId" value=''
                        type="text"></td>
                </tr>
                <tr>
                    <td>密 码：</td>
                    <td><input name="password" type="password"></td>
                </tr>
                <tr>
                    <td>重复密码：</td>
                    <td><input name="pwd" type="password"></td>
                </tr>
				<tr>
					<td>昵称：</td>
					<td><input name="name" value=''
						type="text"></td>
				</tr>
				<tr>
					<td>手机号码：</td>
					<td><input name="tel" type="text"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><br/><input type="button" value="提及注册" onclick="doSave()"/></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>
<script type="text/javascript">
function doSave(){
    var loginId = $("input[name='loginId']").val();
    if(loginId==null || loginId==""){
    	alert("用户名不能为空");
    	$("input[name='loginId']").focus();
    	return;
    }
    var password = $("input[name='password']").val();	
    if(password==null || password==""){
    	alert("密码不能为空");
    	$("input[name='password']").focus();
    	return;
    }
    var pwd = $("input[name='pwd']").val();	
    if(pwd==null || pwd==""){
    	alert("请再次输入密码");
    	$("input[name='pwd']").focus();
    	return;
    }else if(pwd!=password){
    	alert("两次输入的密码不一致");
        return;
    }
    var name = $("input[name='name']").val();	
    if(name==null || name==""){
    	alert("请输入昵称");
    	$("input[name='name']").focus();
    	return;
    }
    $("#form1").submit();
}
</script>
