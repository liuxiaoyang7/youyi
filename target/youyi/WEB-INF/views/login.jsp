<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/7/1
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/login.css">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%@ include file="header.jsp"%>
    <script>
        function a1(){
            console.log($("#username").val());
            $.post({
                url:"${pageContext.request.contextPath}/user/login",
                data:{
                    "name":$("#username").val(),
                    "pwd":$("#pwd").val()
                },
                success:function (data) {
                    if (JSON.parse(data)[0]==='正确'){
                        $("#userInfo").css("color","green");
                    }else {
                        $("#userInfo").css("color","red")
                    }
                    $("#userInfo").html(JSON.parse(data)[0]);
                    if (JSON.parse(data)[1]==='正确'){
                        $("#pwdInfo").css("color","green");
                        $("#pwdInfo").html(JSON.parse(data)[1])
                    }else {
                        $("#pwdInfo").css("color","red");
                        $("#pwdInfo").html("错误")
                    }
                },
            })
        }
    </script>
</head>
<body>
<div class="all">
    <div class="logo" style="margin-top: 40px">
        <img WIDTH="80" HEIGHT="80" src="${pageContext.request.contextPath}/statics/image/logo.png">
        <p>游易商城</p>
    </div>
    <div class="left">
        <img src="${pageContext.request.contextPath}/statics/image/jiansan.png">
    </div>
    <div class="right">
    <form action="${pageContext.request.contextPath}/user/loginok" method="post">
        <p>用户名：</p>
        <div class="user"><input style="height: 28px" size="26" required="required" type="text" name="username" id="username" onblur="a1()" placeholder="输入用户名"><span id="userInfo"></span></div>
        <br/>
        <span style="color: red">${msg_loginError}</span><br/>
        <p>密码：</p><div class="psw"><input style="height: 28px" size="26" required="required" type="password" name="pwd" id="pwd" onblur="a1()" placeholder="请输入密码"><span id="pwdInfo"></div>
        </span><br/>
        <input class="special" type="submit" value="登录">
    </form>
    </div>
</div>
</body>
</html>
