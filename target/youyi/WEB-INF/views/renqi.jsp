<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/2
  Time: 1:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人气商品</title>
    <%@ include file="header.jsp"%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/index.css">
    <style>
        .line-limit-length{
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }
    </style>
</head>
<body>
<div class="all">
    <div style="margin-top: 60px" class="logo">
        <img WIDTH="80" HEIGHT="80" src="${pageContext.request.contextPath}/statics/image/logo.png">
        <p>游易商城</p>
    </div>
    <form action="${pageContext.request.contextPath}/CommodityVG">
        <div class="lb">
            <p>类别：*</p>
            <div class="variety">
                <select id="variety" name="variety">
                    <option value="卖号">卖号</option>
                    <option value="租号">租号</option>
                    <option value="道具">道具</option>
                </select>
            </div>
        </div>
        <div class="zl">
            <p>游戏种类：*</p>
            <div class="game">
                <select id="gid" name="gid">
                    <option value="1">王者荣耀</option>
                    <option value="2">剑网三</option>
                    <option value="3">绝地求生</option>
                    <option value="4">QQ炫舞</option>
                    <option value="5">LOL</option>
                </select>
            </div>
        </div>
        <input type="submit" value="搜索" class="special">
    </form>
    <div class="wenzi">
        <a href="${pageContext.request.contextPath}/index">回到首页</a>
    </div>
    <div class="renqi" style="height: 1px">
        <c:forEach var="listR" items="${listR}">
            <div class="c1" style="float: left">
                <img width="200" height="100" src="${pageContext.request.contextPath}/statics/image/${listR.cimg}" style="margin-left: 40px">
                <h5 class="line-limit-length">${listR.titile}</h5>
                <h5 class="line-limit-length">${listR.introduce}</h5>
                <li>库存:${listR.popularity}</li>
                <li>￥${listR.price}</li>
                <li>人气:${listR.rexiao}</li>
                <a href="${pageContext.request.contextPath}/Commodity/${listR.cid}">查看商品详情</a>
            </div>

        </c:forEach>
    </div>
    <DIV style="clear: both"></DIV>
</div>

</body>
</html>
