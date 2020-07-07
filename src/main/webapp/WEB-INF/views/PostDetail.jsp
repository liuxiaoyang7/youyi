<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.js"></script>
    <link  rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/main.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/sinaFaceAndEffec.css" />
    <%@ include file="header.jsp"%>
</head>

<body>
<div style="width: 60%;margin: 60px auto;border: 1px solid grey">
    <div style="float:left;width: 200px;height:400px;border-right: 1px grey solid;">
        <div style="width: 100px;height: 100px;margin: 10px auto;">
            <img src="${pageContext.request.contextPath}/statics/image/${user.headphoto}" style="width: 100%;height: 100%;">
            <h5 hidden="hidden" id="PID">${postShow.pid}</h5>
            <h5 style="text-align: center">楼主：${user.name}</h5>
            <h6 style="text-align: center"><span style="color: saddlebrown">${dengji}<br/><br/></span>当前经验值:${user.experience}</h6>
        </div>
    </div>
    <div style="float:left;width: 50%;border-right: 1px slategrey solid">
        <div style="width: 100%;margin: 20px auto;text-align: center">
            <img style="width: 80%;height: 300px" src="${pageContext.request.contextPath}/statics/image/${postShow.pimg}">
            <c:if test="${postShow.cid!=null}">
                <h6><a href="${pageContext.request.contextPath}/Commodity/${postShow.cid}" style="display:block;font-size: 12px;float: right">返回商品详情</a></h6>
            </c:if>
            <c:if test="${postShow.cid==null}">
                <h6><a href="${pageContext.request.contextPath}/post1/getAllPost/2" style="display:block;font-size: 12px;float: right">返回帖子</a></h6>
            </c:if>
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
    <%if (session.getAttribute("user")!=null){User user1 = (User) session.getAttribute("user");%>
    <div id="content" style="width: 700px; height: auto;">
        <div class="wrap">
            <div class="comment">
                <div class="head-face">
                    <img src="${pageContext.request.contextPath}/statics/image/<%=user1.getHeadphoto()%>" />
                    <p><%=user1.getName()%></p>
                </div>
                <div class="content">
                    <c:if test="${postShow.cid!=null}">
                        <form action="${pageContext.request.contextPath}/comment/addComment" method="post">
                            <div class="cont-box">
                                <input class="text" type="text" name="comcontent" placeholder="请输入..." />
                                <input hidden="hidden" type="number" id="pid1" name="pid" value="${postShow.pid}" />
                                <input hidden="hidden" type="number" id="cid1" name="cid" value="${postShow.cid}" />
                                <input hidden="hidden" type="number" id="uid1" name="uid" value="${postShow.uid}" />
                            </div>
                            <div class="tools-box">
                                <div class="operator-box-btn"><span class="face-icon"  >☺</span><span class="img-icon">▧</span></div>
                                <div class="submit-btn"><input type="submit" value="提交评论" />
                                    <input type="button" onClick="out()" value="查看当前评论" /></div>
                            </div>
                        </form>
                    </c:if>
                    <c:if test="${postShow.cid==null}">
                        <form action="${pageContext.request.contextPath}/comment/addComment" method="post">
                            <div class="cont-box">
                                <input class="text" type="text" name="comcontent" placeholder="请输入..." />
                                <input hidden="hidden" type="number" id="pid2" name="pid" value="${postShow.pid}" />
                                <input hidden="hidden" type="number" id="uid2" name="uid" value="${postShow.uid}" />
                            </div>
                            <div class="tools-box">
                                <div class="operator-box-btn"><span class="face-icon"  >☺</span><span class="img-icon">▧</span></div>
                                <div class="submit-btn"><input type="submit" value="提交评论" />
                                    <input type="button" onClick="out()" value="查看当前评论" /></div>
                            </div>
                        </form>
                    </c:if>
                </div>
            </div>
            <div id="info-show">
                <ul></ul>
            </div>
        </div>
    </div>
    <%}else {}%>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/sinaFaceAndEffec.js"></script>
<script type="text/javascript">
    <%if (session.getAttribute("user")!=null){User user1 = (User) session.getAttribute("user");%>
    // 绑定表情
    $('.face-icon').SinaEmotion($('.text'));
    console.log($("#pid2").val());
    console.log($("#pid1").val());
    // 从后台获取json
    function out() {
        $.post({
            url:"${pageContext.request.contextPath}/comment/jsonComment",
            data: {
                <c:if test="${postShow.cid==null}">
                "pid1":$("#pid2").val(),
                </c:if>
                <c:if test="${postShow.cid!=null}">
                "pid1":$("#pid1").val(),
                </c:if>

            },
            success:function (data) {
                console.log(JSON.parse(data).length);
                console.log($("#pid1").val());
                var j = 0;
                var str = "";
                for (var i = 0; i<JSON.parse(data).length; i=i+5) {   //遍历
                    str  = '<li>';
                    str += '<div class="head-face">';
                    str += '<img src="${pageContext.request.contextPath}/statics/image/'+JSON.parse(data)[i]+'"+ />';
                    str += '</div>';
                    str += '<div class="reply-cont">';
                    str += '<p class="username">'+JSON.parse(data)[i+1]+'</p>';
                    str += '<p class="comment-body">'+JSON.parse(data)[i+2]+'</p>';
                    str += '<p class="comment-footer">'+JSON.parse(data)[i+3]+'　回复　点赞54　转发12</p>';
                    str += '</div>';
                    str += '</li>';
                    $('#info-show ul').append(str);
                }
            },
            error : function (arg1) {
                alert("加载数据失败");
                console.log(arg1);
            }
        })
    }
    <%}else {}%>
</script>

</html>
