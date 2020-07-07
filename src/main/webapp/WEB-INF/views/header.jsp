<%@ page import="com.cn.youyi.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/2
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头部</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<script>
    if($("#name").val()==="登录"){
    }else {}
</script>
<body>
<div style="position: fixed;top:0;width: 100%; height:40px;padding:12px;background-color: darkgrey">
    <ul>
        <%if (session.getAttribute("user")==null)
        {%><%}else {%>
        <li id="zhuxiao" style="list-style-type:none;width:150px;float: right"><a href="${pageContext.request.contextPath}/user/removeUser">注销</a></li>
        <%}%>
        <li id="name" style="list-style-type:none;width:150px;float: right"><a href="${pageContext.request.contextPath}/user/toLogin">
            <%if (session.getAttribute("user")==null)
            {%><%}else {User user = (User) session.getAttribute("user");%><img style="width:20px; height:20px; border-radius:50%;" src="${pageContext.request.contextPath}/statics/image/<%=user.getHeadphoto()%>"><%}%>
            <%if (session.getAttribute("user")==null)
            {%>登录<%}else {User user = (User) session.getAttribute("user");%><%=user.getName()%><%}%>
            <%if (session.getAttribute("user")==null)
            {%><%}else {User user = (User) session.getAttribute("user");%><a href="${pageContext.request.contextPath}/user/payYue?name=<%=user.getName()%>&Rname='wu'&cid=0&yue=<%=user.getYue()%>" style="color: red;font-size: 12px">(余额:<%=user.getYue()%>)</a><%}%>
        </a></li>
        <li style="list-style-type:none;width:150px;float: right"><a href="${pageContext.request.contextPath}/user/toRegister">注册</a></li>

        <%if (session.getAttribute("user")==null)
        {%><%}else {User user = (User) session.getAttribute("user");%>
        <li style="list-style-type:none;width:150px;float: right"><a href="${pageContext.request.contextPath}/order/orderByUid/<%=user.getUid()%>">购买记录</a></li>
        <%}%>
        <%if (session.getAttribute("user")==null)
        {%><%}else {User user = (User) session.getAttribute("user");if(user.getTypeid()==2){%>
        <li style="list-style-type:none;width:150px;float: right"><a href="${pageContext.request.contextPath}/ToaddCommidity">发布商品</a></li>
        <%}else {}}%>
        <%if (session.getAttribute("user")==null)
        {%><%}else {User user = (User) session.getAttribute("user");if(user.getTypeid()==1){%>
        <li style="list-style-type:none;width:150px;float: right"><a href="${pageContext.request.contextPath}/post1/ToaddPost">发布帖子</a></li>
        <%}else {}}%>
        <%if (session.getAttribute("user")==null)
        {%><%}else {User user = (User) session.getAttribute("user");%>
        <li style="list-style-type:none;width:150px;float: right"><a href="${pageContext.request.contextPath}/post1/getPostByUid/<%=user.getUid()%>">我的发布</a></li>
        <%}%>
        <li style="list-style-type:none;width:150px;float: right"><a href="${pageContext.request.contextPath}/user/">个人中心</a></li>
        <li style="list-style-type:none;width:150px;float: right"><a href="${pageContext.request.contextPath}/post1/getAllPost/2">社交</a></li>
        <li style="list-style-type:none;width:150px;float: right"><a href="${pageContext.request.contextPath}/index">回到首页</a></li>
    </ul>
</div>
</body>
</html>
