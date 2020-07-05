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
<div style="width: 40%;margin: 100px auto">
    <form action="${pageContext.request.contextPath}/user/loginok" method="post">
        用户名：<input class="form-control" required="required" type="text" name="username" id="username" onblur="a1()" placeholder="输入用户名">
        <span id="userInfo"></span><br/>
        <span style="color: red">${msg_loginError}</span><br/>
        密码：<input class="form-control" required="required" type="password" name="pwd" id="pwd" onblur="a1()" placeholder="请输入密码">
        <span id="pwdInfo"></span><br/>
        <input type="submit" value="登录" class="btn btn-primary">
    </form>
</div>
</body>
</html>
