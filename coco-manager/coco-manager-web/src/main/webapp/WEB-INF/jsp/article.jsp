<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/23 0023
  Time: 下午 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>文章内容</title>
    <link href="/css/homepage.css" rel="stylesheet">
    <link href="/css/article.css" rel="stylesheet">
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
                    <div class="search-button">
                        <button class="btn-search" type="submit" >搜索</button>
                    </div>
                    <div class="search-input">
                        <input class="search-input-content" >
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
            <li><a href="#">订购套餐</a></li>
            <li><a href="#">咨询动态</a></li>
            <li><a href="#">联系我们</a></li>
        </ul>
    </div>
</div>

<div class="article">
    <div class="article-content">
        <article style="margin-top: 30px">
            <div class="title">
                <h3>${article.title}</h3>
            </div>
            <div class="title-info">
                <span class="fix"><span class="no-mobile">时间：</span>${article.updated}</span>
                <span class="fix"><span class="no-mobile">来源：</span>${article.source}</span>
            </div>
            <br/>
            <div id="bgprint">
                　${article.content}
            </div>
        </article>

    </div>
</div>

<div id="footer">
    <span>Copyright © 2017 hello.com All Rights Reserved</span>
</div>
</body>
</html>
