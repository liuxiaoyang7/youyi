<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/7
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>所有的帖子</title>
    <%@ include file="header.jsp"%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/AllPost.css">
</head>
<body>
<div class="all">
    <div style="margin-top: 60px;" class="logo">
        <img WIDTH="80" HEIGHT="80" src="${pageContext.request.contextPath}/statics/image/logo.png">
        <p>游易社区</p>
    </div>
    <div class="allpost">
        <p>全部贴子</p>
    </div>
    <c:forEach var="posts" items="${posts}">
    <div class="post">
        <c:forEach var="users" items="${users}">
        <c:if test="${users.uid==posts.uid}">
            <img style="width: 50px;height: 50px;border-radius: 50%;" src="${pageContext.request.contextPath}/statics/image/${users.headphoto}"/>
            <p>${users.name}</p>
        </c:if>
        </c:forEach>
        <c:forEach var="postbars" items="${postbars}">
            <c:if test="${postbars.pbid==posts.pbid}">
                <li><a href="#">${postbars.barowner}:${postbars.bname}</a></li>
            </c:if>
        </c:forEach>
        <li style="white-space:nowrap;overflow:hidden;text-overflow:ellipsis;">${posts.pcontent}</li>
        <img  width="180" height="120" style="margin-left: 45px;margin-top: 10px" src="${pageContext.request.contextPath}/statics/image/${posts.pimg}" />
        <h5 style="width: 240px;margin-top: 2px;font-weight: bold">${posts.publishtime}发布</h5>
        <%if (session.getAttribute("user")==null)
        {%><a class="postdetail" href="${pageContext.request.contextPath}/post1/getPostBypid/${posts.pid}">查看帖子详情</a>
        <%}else {User user = (User) session.getAttribute("user");%>
        <a class="postdetail" href="${pageContext.request.contextPath}/post1/getPostBypid/${posts.pid}/${posts.uid}">查看帖子详情</a><%}%>
    </div>
    </c:forEach>
</div>
</body>
</html>
