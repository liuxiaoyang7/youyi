<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/4
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值页面</title>
    <%@ include file="header.jsp"%>
</head>
<body>
<div style="width: 30%;margin: 100px auto">
    <h1 style="">你的余额不足，请输入充值金额</h1>
    <form action="${pageContext.request.contextPath}/user/payYue" method="post">
        当前用户命：<input type="text" value="${user.name}" onfocus="this.blur()" name="name"><br/>
        确认用户名：<input type="text" placeholder="请再次输入当前用户名" name="Rname" required="required"><br/>
        账户所剩余额：<input type="text" value="${user.yue}" onfocus="this.blur()"><br/>
        请输入充值金额：<input type="text" name="yue" required="required">
        <input hidden="hidden" type="number" name="cid" value="${cid}">
        <input type="submit" value="确定充值">
    </form>
</div>
</body>
</html>
