<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/2
  Time: 2:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品详情页</title>
</head>
<body>
<div style="border: 1px saddlebrown solid;margin: 20px auto;width: 1000px">
    <div style="float: left">
        <a href="${pageContext.request.contextPath}/index" style="display:block;width:20px;margin:0 auto;line-height:24px;font-size:20px;color: red;font-weight: bold" >回到首页</a>
    </div>
    <div style="margin: 20px auto; width: 60%;border: 1px saddlebrown dashed">
        <div style="width: 100%; height: 500px">
            <img src="${pageContext.request.contextPath}/statics/image/${commodity.cimg}" style="width: 100%;height: 100%;">
        </div>
        <h4 style="display: inline">${commodity.variety}<br/></h4><br/>
        <h4 style="display: inline">${commodity.titile}</h4><br/>
        <h4 style="display: inline">${commodity.introduce}<br/></h4><br/>
        <div>
            <h3 style="display: inline;float:left;color: red">￥${commodity.price}</h3>
            <h3 style="display: inline;float: left;margin-left: 50px">人气:${commodity.rexiao}</h3
            <div style="float: right;">
                <%
                    if(session.getAttribute("user")!=null){
                %>
                <a href="${pageContext.request.contextPath}/post1/getPostByCid/${commodity.cid}/${commodity.uid}" style="display:block;width:80px;font-size:20px;color: red;font-weight: bold;float: right;" >商品帖子</a>
                <%
                }else{%>
                <a href="${pageContext.request.contextPath}/post1/getPostByCid/${commodity.cid}" style="display:block;width:80px;font-size:20px;color: red;font-weight: bold;float:right;margin-right: 60px" >商品帖子</a>
                <%}%>
                <%
                    if(session.getAttribute("user")!=null){
                        %>
                <a href="${pageContext.request.contextPath}/buyCommodity/${commodity.cid}/${user.name}" style="display:block;width:80px;font-size:20px;color: red;font-weight: bold;float:right;margin-right: 60px" >立即购买</a>
                <%
                    }else{%>
                        <a href="${pageContext.request.contextPath}/buyCommodity/${commodity.cid}" style="display:block;width:80px;font-size:20px;color: red;font-weight: bold;float:right;margin-right: 60px" >立即购买</a>
                    <%}%>

            </div>
            <div style="clear: both" ></div>
        </div>
    </div>
    <div style="clear: both"></div>
</div>
</body>
</html>
