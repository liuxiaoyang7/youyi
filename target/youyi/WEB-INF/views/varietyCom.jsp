<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/2
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品分类页面</title>
    <%@ include file="header.jsp"%>
</head>
<body>
<div style="border: 1px saddlebrown solid;margin: 40px auto;width: 1000px">
    <div style="float: left">
        <a href="${pageContext.request.contextPath}/index" style="display:block;width:20px;margin:0 auto;line-height:24px;font-size:20px;color: red;font-weight: bold" >回到首页</a>
    </div>
    <c:forEach var="listV" items="${listV}">
        <div style="float: left;margin-left: 60px;margin-top: 10px; width: 24%;height:200px;border: 1px saddlebrown dashed">
            <div style="width: 100%; height: 120px">
                <img src="${listV.cimg}" style="width: 100%;height: 100%;">
            </div>
            <h6 style="display: inline">${listV.titile}</h6><br/>
            <h6 style="display: inline">${listV.introduce}</h6><br/>
            <div style="position: relative; bottom: 20px">
                <h6 style="display: inline;float:left;color: red">￥${listV.price}</h6>
                <h6 style="display: inline;float: left;margin-left: 50px">人气:${listV.rexiao}</h6>
            </div>
            <a href="${pageContext.request.contextPath}/Commodity/${listV.cid}" style="display:block;font-size: 12px;float: right">查看商品详情</a>
        </div>
    </c:forEach>
    <div style="clear: both"></div>
</div>
</body>
</html>
