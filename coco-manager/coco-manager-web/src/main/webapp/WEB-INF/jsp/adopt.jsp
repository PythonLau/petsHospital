<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/24 0024
  Time: 下午 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/common.css"/>
    <link rel="stylesheet" href="/css/material-icons.css">
    <link rel="stylesheet" href="/css/header.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/search.css"/>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link href="/css/homepage.css" rel="stylesheet">
    <style>
        body {
            margin: 0 0;
            padding: 0 0;
        }
    </style>
</head>
<body>
<div id="header">
    <div class="header_left"><a href="#"><img src="/image/star.png" class="image"><span>收藏淘淘</span></a></div>
    <div class="header_right"><span>您好！欢迎来到coco！</span>&nbsp;<span>[<a href="#">登录</a>]</span><span>[<a href="#">免费注册</a>]</span>　|　<a href="#">我的订单</a></div>
</div>

<div id="secondHeader">
    <ul>
        <li>
            <div id="secondHeader_img">
                <img src="/image/logo.png"/>
            </div>
        </li>
        <li>
            <div id="search">
                <form target="_top" action="#" name="search" class="">
                    <div class="" style="width: 60px; height: 26px; position: absolute; margin-left: 233px; margin-top: 3px;">
                        <button class="btn-search" type="submit" >搜索</button>
                    </div>
                    <div class="search-input">
                        <input class="search-input-content1" >
                    </div>
                </form>
            </div>
        </li>
        <li>
            <div id="coco"><a href="#"><img src="/image/hello.png"/><span style="padding-bottom: 20px">我的coco</span></a></div>
        </li>
        <li>
            <div id="order"><a href="#"><img src="/image/order.png"/><span>我的订单</span></a></div>
        </li>

    </ul>

</div>

<div id="nav">
    <div id="nav-content">
        <ul>
            <li><a href="/">首页</a></li>
            <li><a href="#">我要挂号</a></li>
            <li><a href="#">寄养领养</a></li>
            <li><a href="/package/1">订购套餐</a></li>
            <li><a href="#">医院介绍</a></li>
            <li><a href="#">联系我们</a></li>
        </ul>
    </div>
</div>

<div class="search-result top-distance">
    <div class="main">
        <div class="container">
            <div class="row">
                <c:forEach items="${list}" var="adoptPet">
                    <div class="col-md-3">
                        <a href="#">
                            <img src=${adoptPet.image} width="200" height="200"/>
                        </a>

                        <div>
                            <p class="name" name="title">${adoptPet.name}</p>
                            <p class="detail">联系人:${adoptPet.contacts}</p>
                            <p class="detail">地址:${adoptPet.address}</p>
                            <p class="detail">联系电话:${adoptPet.telePhone}</p>
                            <p class="button">
                                <a class="btn cyan" style="margin-right: 20px"
                                   href="/user/adoptApply/${adoptPet.petId}">
                                    申请领养
                                </a>
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <div style="float: right; height: 100px; line-height: 100px; display: inline-block; padding: 30px 15px;">
            共 ${requestScope.packagePage.totalPageNumber } 页
            &nbsp;&nbsp;
            当前第 ${requestScope.packagePage.currentPageNo } 页
            &nbsp;&nbsp;

            <c:if test="${requestScope.packagePage.hasPrev }">
                <a href="/package/1">首页</a>
                &nbsp;&nbsp;
                <a href="/package/${requestScope.packagePage.prevPage }">上一页</a>
            </c:if>

            &nbsp;&nbsp;

            <c:if test="${requestScope.packagePage.hasNext }">
                <a href="/package/${requestScope.packagePage.nextPage }">下一页</a>
                &nbsp;&nbsp;
                <a href="/package/${requestScope.packagePage.totalPageNumber }">末页</a>
            </c:if>

            &nbsp;&nbsp;

            转到 <input type="text" id="pageNo" style="width: 33px; height: 23px"/> 页
        </div>
    </div>
</div>



<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.3.min.js"></script>
<script>
    $(function(){

        // 当值改变时
        $("#pageNo").change(function() {
            alert("pageNo change");
            var val = $(this).val();
            val = $.trim(val);

            // 校验val 是否为数字
            var flag = false;
            var reg = /^\d+$/g;
            var pageNo = 0;
            if (reg.test(val)){
                // 校验 val 是否在一个合法的范围：1 - totalPageNumber
                pageNo = parseInt(val);
                if(pageNo >= 1 && pageNo <= parseInt("${packagePage.totalPageNumber }")){
                    flag = true;
                }
            }

            if(!flag){
                alert("输入的不是合法的页码.");
                $(this).val("");
                return;
            }

            // 页码正常，执行页面跳转
            var href = "/package/" + pageNo;
            window.location.href = href;
        });
    });
</script>
<script>
    var wrong = '<%=request.getAttribute("wrong")%>';
    if(wrong != 'null'){
        alert(wrong);
    }
</script>
</body>
</html>
