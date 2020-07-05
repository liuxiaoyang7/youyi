<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/6/22
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>游易首页</title>
    <%@ include file="header.jsp"%>
</head>
<body>
<div style="width: 90%; margin: 56px auto;border: rebeccapurple 1px solid">
    <div style="float: left">
        <form action="${pageContext.request.contextPath}/CommodityVG">
            选择分类：*<select id="variety" name="variety">
            <option value="卖号">卖号</option>
            <option value="租号">租号</option>
            <option value="道具">道具</option>
        </select><br/>
            选择游戏：*<select id="gid" name="gid">
            <option value="1">王者荣耀</option>
            <option value="2">剑网三</option>
            <option value="3">绝地求生</option>
            <option value="4">QQ炫舞</option>
            <option value="5">LOL</option>
        </select><br/>
            <input type="submit" value="搜索">
        </form>
    </div>
    <div style="border: 1px saddlebrown solid;margin: 20px auto;width: 1000px;">
        <div style="float: left">
            <a href="${pageContext.request.contextPath}/showRq" style="display:block;width:20px;margin:0 auto;line-height:24px;font-size:20px;color: red;font-weight: bold" >人气商品</a>
        </div>
        <c:forEach var="listR" items="${listR}">
            <div style="float: left;margin-left: 60px; width: 24%;height:200px;border: 1px saddlebrown dashed">
                <div style="width: 100%; height: 120px">
                    <img src="${pageContext.request.contextPath}/statics/image/${listR.cimg}" style="width: 100%;height: 100%;">
                </div>
                <h6 style="display: inline">${listR.titile}</h6><br/>
                <h6 style="display: inline">${listR.introduce}</h6><br/>
                <div>
                    <h6  style="display: inline;float:left;color: red">库存:${listR.popularity}</h6>
                    <h6 style="display: inline;float:left;color: red">￥${listR.price}</h6>
                    <h6 style="display: inline;float: left;margin-left: 50px">人气:${listR.rexiao}</h6>
                </div>
                <a href="${pageContext.request.contextPath}/Commodity/${listR.cid}" style="display:block;font-size: 12px;float: right">查看商品详情</a>
            </div>
        </c:forEach>
        <div style="clear: both"></div>
    </div>
    <div style="border: 1px saddlebrown solid;margin: 20px auto;width: 1000px">
        <div style="float: left">
            <a href="${pageContext.request.contextPath}/showNew" style="display:block;width:20px;margin:0 auto;line-height:24px;font-size:20px;color: red;font-weight: bold">新品</a>
        </div>
        <c:forEach var="listN" items="${listN}">
            <div style="float: left;margin-left: 60px; width: 24%;height:200px;border: 1px saddlebrown dashed">
                <div style="width: 100%; height: 120px">
                    <img src="${pageContext.request.contextPath}/statics/image/${listN.cimg}" style="width: 100%;height: 100%;">
                </div>
                <h6 style="display: inline">${listN.titile}</h6><br/>
                <h6 style="display: inline">${listN.introduce}</h6><br/>
                <div>
                    <h6  style="display: inline;float:left;color: red">库存:${listN.popularity}</h6>
                    <h6  style="display: inline;float:left;color: red">￥${listN.price}</h6>
                    <h6 style=" display: inline;float: left;margin-left: 50px">人气:${listN.rexiao}</h6>
                </div>
                <a href="${pageContext.request.contextPath}/Commodity/${listN.cid}" style="display:block;font-size: 12px;float: right">查看商品详情</a>
            </div>
        </c:forEach>
        <div style="clear: both"></div>
    </div>
    <div style="border: 1px saddlebrown solid;margin: 20px auto;width: 1000px">
        <div style="float: left">
            <a href="${pageContext.request.contextPath}/showAll" style="display:block;width:20px;margin:0 auto;line-height:24px;font-size:20px;color: red;font-weight: bold">所有</a>
        </div>
        <c:forEach var="listA" items="${listA}">
            <div style="float: left;margin-left: 60px; width: 24%;height:200px;border: 1px saddlebrown dashed;">
                <div style="width: 100%; height: 120px">
                    <img src="${pageContext.request.contextPath}/statics/image/${listA.cimg}" style="width: 100%;height: 100%;">
                </div>
                <h6 style="display: inline">${listA.titile}</h6><br/>
                <h6 style="display: inline">${listA.introduce}</h6><br/>
                <div>
                    <h6  style="display: inline;float:left;color: red">库存:${listA.popularity}</h6>
                    <h6 style="display: inline;float:left;color: red">￥${listA.price}</h6>
                    <h6 style="display: inline;float: left;margin-left: 50px">人气:${listA.rexiao}</h6>
                </div>
                <a href="${pageContext.request.contextPath}/Commodity/${listA.cid}" style="display:block;font-size: 12px;float: right">查看商品详情</a>
            </div>
        </c:forEach>
        <div style="clear: both"></div>
    </div>
    <div style="clear: both"></div>
</div>
</body>
</html>
