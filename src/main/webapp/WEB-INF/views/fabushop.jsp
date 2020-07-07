<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/5
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布商品页面</title>
    <%@ include file="header.jsp"%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/publishshop.css">
</head>
<body>
<div class="all">
    <div style="margin-top: 60px" class="logo">
        <img WIDTH="80" HEIGHT="80" src="${pageContext.request.contextPath}/statics/image/logo.png">
        <p>游易商城</p>
    </div>
    <div class="left">
        <img height="600" src="${pageContext.request.contextPath}/statics/image/jiansan.png">
    </div>
    <div class="right">
    <form id="action_form" action="${pageContext.request.contextPath}/addCommidity" method="post" enctype="multipart/form-data">
        <p>类别：*</p><div class="variety"><select id="variety" name="variety">
        <option value="卖号">卖号</option>
        <option value="租号">租号</option>
        <option value="道具">道具</option>
    </select></div>
        <p>游戏种类：*</p><div class="game"><select id="gid" name = "gid">
        <option value="1" selected="selected">王者荣耀</option>
        <option value="2">剑网三</option>
        <option value="3">绝地求生</option>
        <option value="4">QQ炫舞</option>
        <option value="5">LOL</option><br/>
    </select></div>
        <p>标题：*</p>
        <div class="title"><input style="height: 25px"  type="text" placeholder="标题" id="titile" name="titile" required="required"></div>
        <p>上传图片</p>
        <div class="add_img">：<input style="height: 25px"  type="file" name="file" id="file" required="required"></div>
        <p>详情：*</p>
        <div class="detail"><input style="height: 25px"  type="text" placeholder="详情" id="introduce" name="introduce" required="required"></div>
        <p>库存：*</p>
        <div class="kucun"><input style="height: 25px" type="number" placeholder="库存" id="popularity" name="popularity" required="required"></div>
        <p>价格：*</p>
        <div class="price"><input style="height: 25px" type="number" placeholder="价格" id="price" name="price" required="required"></div>
        <input type="submit" value="确认发布" class="special"><br/>
    </form>
</div>
</body>
</html>
