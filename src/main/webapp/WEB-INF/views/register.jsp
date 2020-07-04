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
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<script>
    function a1(){
        console.log($("#name").val());
        console.log($("#typeid").val());
        console.log($("#IDcard").val());
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
    <div style="margin: 0 auto;width: 30%">
        <form id="action_form" action="${pageContext.request.contextPath}/user/register" method="post" enctype="multipart/form-data">
            头像<input type="file" name="file" id="filehead"><br/>
            姓名：*<input type="text" placeholder="姓名" id="name" name="name" required="required" onblur="a1()">
            <span id="nameInfo"></span><br/>
            密码：*<input type="password" placeholder="密码" id="pwd" name="password" required="required"><br/>
            性别：*<select id="sex" name="sex">
                    <option value="男">男</option>
                    <option value="女">女</option>
                 </select><br/>
            手机号：*<input type="text" placeholder="手机号" id="phone" name="phone" required="required"><br/>
            选择注册类型：*<select id="typeid" name = "typeid" onblur="a1()">
                            <option value="1" selected="selected">用户注册</option>
                            <option value="2">商家注册</option>
                        </select><br/>

            <h3>以下为商家注册信息</h3>
            身份证：<input type="text" placeholder="身份证" id="IDcard" name="IDcard" onblur="a1()">
            <span id="IDInfo"></span><br/>

            <input type="submit" value="注册"><br/>
        </form>
    </div>
</body>
</html>
