<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/WEB-INF/views/top.jsp" %>
<html>
<head>
</head>
<body>
    <form id="form1" action="<%=ctx %>/user/upload" method="post" enctype="multipart/form-data">
        <div style="margin:50px 50px;">
            <input name="myFile" type="file"/>
            <input name="myFile" type="file"/>
            <input name="myFile1" type="file"/>
            <input type="submit" value="上传">
        </div>
    </form>
</body>
</html>
