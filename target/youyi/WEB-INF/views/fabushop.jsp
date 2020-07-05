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
</head>
<body>
<div style="margin: 0 auto;width: 30%">
    <form id="action_form" action="${pageContext.request.contextPath}/addCommidity" method="post" enctype="multipart/form-data">
        类别：*<select id="variety" name="variety">
        <option value="卖号">卖号</option>
        <option value="租号">租号</option>
        <option value="道具">道具</option>
    </select><br/>
        游戏种类：*<select id="gid" name = "gid">
        <option value="1" selected="selected">王者荣耀</option>
        <option value="2">剑网三</option>
        <option value="3">绝地求生</option>
        <option value="4">QQ炫舞</option>
        <option value="5">LOL</option><br/>
    </select><br/>
        标题：*<input type="text" placeholder="标题" id="titile" name="titile" required="required"><br/>
        上传图片：<input type="file" name="file" id="file" required="required"><br/>
        详情：*<input type="text" placeholder="详情" id="introduce" name="introduce" required="required"><br/>
        库存：*<input type="number" placeholder="库存" id="popularity" name="popularity" required="required"><br/>
        价格：*<input type="number" placeholder="价格" id="price" name="price" required="required">
        <input type="submit" value="确认发布"><br/>
    </form>
</div>
</body>
</html>
