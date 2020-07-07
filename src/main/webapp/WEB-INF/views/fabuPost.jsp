<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/7
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布帖子界面</title>
    <%@ include file="header.jsp"%>
</head>
<body>
<div style="width: 20%;margin:60px auto">
    <% User user = (User) session.getAttribute("user");%>
    <form action="${pageContext.request.contextPath}/post1/addPost" method="post" enctype="multipart/form-data">
        选择帖吧：*<select id="pbid" name = "pbid">
        <option value="1" selected="selected">王者荣耀吧</option>
        <option value="2">剑网三吧</option>
        <option value="3">绝地求生吧</option>
        <option value="4">QQ炫舞吧</option>
        <option value="5">LOL吧</option>
    </select><br/>
        商品详情：<input required="required" type="text" name="pcontent" id="pcontent" placeholder="描述商品信息"><br/>
        上传图片<input required="required" type="file" name="file" id="filehead"><br/>
        <input required="required" type="number" hidden="hidden" name="uid" id="uid" value="<%=user.getUid()%>">
        <input required="required" type="number" hidden="hidden" name="ptid" id="ptid" value="2">
        <input type="submit" value="确认发布"><br/>
    </form>
</div>
</body>
</html>
