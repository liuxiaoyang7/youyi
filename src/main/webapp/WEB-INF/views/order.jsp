<%@ page import="com.cn.youyi.entity.Commodity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/4
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买记录</title>
    <%@ include file="header.jsp"%>
    <style>
        .f{
            width: 25%;
            float: left;
            margin-left: 30px;
            margin-top: 40px;
        }
    </style>
</head>
<body>
<div style="width: 90%; margin: 60px auto;border: rebeccapurple 1px solid">
    <c:forEach var="oorders" items="${oorders}">
        <div style="border-bottom: 1px solid crimson; width: 100%; margin: 60px auto">
        <c:forEach var="commodities" items="${commodities}">
            <c:if test="${oorders.cid==commodities.cid}">
                <div style="float: left;width: 100px;height: 100px;margin-bottom: 60px;margin-left: 20px"><img style="width: 100%;height: 100%;" src="${commodities.cimg}"></div>
                <div class="f">${commodities.introduce}</div>
            </c:if>
        </c:forEach>
            <div class="f">${oorders.buyTime}</div>
            <c:if test="${oorders.orderState==1}">
                <div class="f">已付款</div>
            </c:if>
            <c:if test="${oorders.orderState!=1}">
                <div class="f">已付款</div>
            </c:if>
            <div style="clear: both"></div>
        </div>

    </c:forEach>
</div>

</body>
</html>
