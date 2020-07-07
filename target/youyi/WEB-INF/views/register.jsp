<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2020/5/26
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <%@ include file="header.jsp"%>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/register.css">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<script>
    function a1(){
        $.post({
            url:"${pageContext.request.contextPath}/user/registering",
            data:{
                "name":$("#name").val(),
                "typeid":$("#typeid").val(),
                "IDcard":$("#IDcard").val(),
            },
            success:function (data) {
                if (JSON.parse(data)[0]===0){
                    $("#nameInfo").css("color","green");
                    $("#nameInfo").html("√");
                }else {
                    $("#nameInfo").css("color","red")
                    if (JSON.parse(data)[0]===2){
                        $("#nameInfo").html("用户名不能重复");
                    }else {
                        $("#nameInfo").html("用户名不能为空");
                    }
                }
                if (JSON.parse(data)[1]===3){
                    $("#IDInfo").css("color","green");
                    $("#IDInfo").html("√");
                }else {
                    $("#IDInfo").css("color","red");
                    if (JSON.parse(data)[1]===4){
                        $("#IDInfo").html("请输入有效身份证")
                        $("#nameInfo").css("required","required")
                    }else if(JSON.parse(data)[1]===2){
                        $("#IDInfo").html("该身份证已被注册")
                        $("#nameInfo").css("required","required")
                    }else if(JSON.parse(data)[1]===0){
                        $("#IDInfo").html("请填写身份证")
                        $("#nameInfo").css("required","required")
                    }else if(JSON.parse(data)[1]===5){
                        $("#IDInfo").html("pt用户无需填写");
                        $("#IDInfo").css("color","green");
                    }
                }
            },
        })
    }
</script>

<body>
<div class="all">
    <div class="logo" style="margin-top: 60px">
        <img src="${pageContext.request.contextPath}/statics/image/logo.png">
        <p>游易商城</p>
    </div>
    <div class="left">
        <img height="600" src="${pageContext.request.contextPath}/statics/image/jiansan.png">
    </div>
        <form id="action_form" action="${pageContext.request.contextPath}/user/register" method="post" enctype="multipart/form-data">
            <div class="right">
                <p>头像</p>
                <div class="head"><input type="file" name="file" id="filehead"></div>
                <p>用户名：*</p>
                <div class="user"><input type="text" placeholder="姓名" id="name" name="name" required="required" onblur="a1()"><span id="nameInfo"></span></div>
                <p>密码：*</p>
                <div class="paw"><input type="password" placeholder="密码" id="pwd" name="password" required="required"></div>
                <p>性别：*</p>
                <div class="sex"><select id="sex" name="sex">
                    <option value="男">男</option>
                    <option value="女">女</option>
                 </select></div>
                <p>手机号：*</p>
                <div class="phone"><input type="text" placeholder="手机号" id="phone" name="phone" required="required"></div>
                <p>选择注册类型：*</p>
                <div class="type"><select id="typeid" name = "typeid" onblur="a1()">
                            <option value="1" selected="selected">用户注册</option>
                            <option value="2">商家注册</option>
                        </select></div>
                <h3>以下为商家注册信息：</h3>
                <p>身份证：*</p>
                <div class="IDcard"><input type="text" placeholder="身份证" id="IDcard" name="IDcard" onblur="a1()"><span id="IDInfo"></span></div>

            <input type="submit" value="注册" class="special"><br/>
            </div>
        </form>
    </div>
</body>
</html>
