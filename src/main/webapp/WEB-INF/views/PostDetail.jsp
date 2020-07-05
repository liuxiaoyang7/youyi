<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/5
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情页</title>
    <%@ include file="header.jsp"%>
</head>
<body>
<div style="width: 60%;margin: 60px auto;border: 1px solid grey">
    <div style="float:left;width: 200px;height:400px;border-right: 1px grey solid;">
        <div style="width: 100px;height: 100px;margin: 10px auto;">
            <img src="${pageContext.request.contextPath}/statics/image/${user.headphoto}" style="width: 100%;height: 100%;">
            <h5 style="text-align: center">楼主：${user.name}</h5>
            <h6 style="text-align: center"><span style="color: saddlebrown">${dengji}<br/><br/></span>当前经验值:${user.experience}</h6>
        </div>
    </div>
    <div style="float:left;width: 50%;border-right: 1px slategrey solid">
        <div style="width: 100%;margin: 20px auto;text-align: center">
            <img style="width: 80%;height: 300px" src="${pageContext.request.contextPath}/statics/image/${postShow.pimg}">
            <h6><a href="${pageContext.request.contextPath}/Commodity/${postShow.cid}" style="display:block;font-size: 12px;float: right">返回商品详情</a></h6>
            <h6>${postShow.pcontent}</h6>
            <span style="float: right;font-size: 10px;margin-left: 100px">发帖时间：${postShow.publishtime}</span>
        </div>
    </div>
    <%if (session.getAttribute("user")!=null){User user1 = (User) session.getAttribute("user");%>
    <div style="float:right;width: 200px;height:400px;border-right: 1px grey solid;">
        <h6 style="font-weight: bolder;margin-top: 70px">我在贴吧</h6>
        <div style="float:left;width: 60px;height: 60px;margin: 3px auto;">
            <img src="${pageContext.request.contextPath}/statics/image/<%=user1.getHeadphoto()%>" style="width: 100%;height: 100%;">
        </div>
        <div style="float:left;width: 60px;height: 60px;margin: 3px auto;">
            <h6 style="text-align: center"><%=user1.getName()%></h6>
            <h6 style="text-align: center;font-size: 10px"><span style="color: saddlebrown"></span><br>当前经验值:<%=user1.getExperience()%></h6>
        </div>
    </div>
    <div style="clear: both"></div>
    <%}else {}%>


</div>
</body>
</html>
