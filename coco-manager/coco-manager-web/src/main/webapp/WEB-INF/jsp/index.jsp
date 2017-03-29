<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/23 0023
  Time: 下午 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>coco宠物医院</title>
    <link href="/css/homepage.css" rel="stylesheet">
</head>
<body>
<div id="header">
    <div class="header_left"><a href="#"><img src="image/star.png" class="image"><span>coco宠物医院</span></a></div>
    <div class="header_right">
        <span>
            您好！
            <%
                Object name = session.getAttribute("nickName");
                if(name != null){
                    out.println(name.toString());
                }else{
                    out.println("欢迎来到coco！");
                }
            %>
        </span>&nbsp;
        <span>
            <c:if test="${sessionScope.nickName == null}">
                [<a href="/login">登录</a>]
            </c:if>
        </span>
        <span>
            <c:if test="${sessionScope.nickName == null}">
                [<a href="#">免费注册</a>]
            </c:if>
        </span>　
        <c:if test="${sessionScope.nickName != null}">
            <a href="#">个人信息</a>
        </c:if>
    </div>
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
        <c:if test="${sessionScope.nickName != null}">
            <li>
                <div id="coco">
                    <a href="/user/orderList/1">
                        <img src="/image/hello.png"/>
                        <span style="padding-bottom: 20px">
                        我的订单
                    </span>

                    </a>
                </div>
            </li>
            <li>
                <div id="order">
                    <a href="/user/petsList">
                        <img src="/image/order.png"/>
                        <span>
                        我的宠物
                    </span>
                    </a>
                </div>
            </li>
        </c:if>
    </ul>

</div>

<div id="nav">
    <div id="nav-content">
        <ul>
            <li><a href="/">首页</a></li>
            <li><a href="#">我要挂号</a></li>
            <li><a href="/adopt/1">寄养领养</a></li>
            <li><a href="/package/1">订购套餐</a></li>
            <li><a href="#">医院介绍</a></li>
            <li><a href="#">联系我们</a></li>
        </ul>
    </div>
</div>

<!--轮播图-->
<div id="photo">

</div>

<!--文章内容-->
<div id="articleList">
    <div class="row">
        <div class="list col-md-6">
            <h3><a href="/articleMore">医院动态(点击查看更多)</a></h3>
            <ul>
                <c:forEach var="sk" items="${list}">
                <li>
                    <a href="/article/${sk.id}" target="_blank" title="${sk.title}">${sk.title}</a>
                    <span class="time">${sk.updated}</span>
                </li>
                </c:forEach>
            </ul>
        </div>

        <div class="list col-md-6">
            <h3><a href="#" target="_blank">记者在线</a></h3>
            <ul>
                <li>
                    <a href="#" target="_blank" title="女生节：寻找你的小幸运">女生节：寻找你的小幸运</a>
                    <span class="time">2017-03-12</span>
                </li>
                <li>
                    <a href="#" target="_blank" title="南湖食堂：我将告别拥堵">南湖食堂：我将告别拥堵</a>
                    <span class="time">2016-12-26</span>
                </li>
                <li>
                    <a href="#" target="_blank" title="摒弃陋习　书香溢满堂">摒弃陋习　书香溢满堂</a>
                    <span class="time">2016-11-27</span>
                </li>
                <li>
                    <a href="#" target="_blank" title="忽如一夜寒潮来　理工二桥变“滑梯”">忽如一夜寒潮来　理工二桥变“滑梯”</a>
                    <span class="time">2016-11-25</span>
                </li>
                <li>
                    <a href="#" target="_blank" title="厉害了我的体测">厉害了我的体测</a>
                    <span class="time">2016-11-24</span>
                </li>
                <li>
                    <a href="#" target="_blank" title="如果套路　你是否愿意买单？　">如果套路　你是否愿意买单？　</a>
                    <span class="time">2016-06-09</span>
                </li>
                <li>
                    <a href="#" target="_blank" title="“巧”治酸奶售卖机“抽风”　">“巧”治酸奶售卖机“抽风”　</a>
                    <span class="time">2016-04-28</span>
                </li>
                <li>
                    <a href="#" target="_blank" title="下雨了　爱心伞去哪了？">下雨了　爱心伞去哪了？</a>
                    <span class="time">2016-04-19</span>
                </li>
            </ul>

        </div>
    </div>
</div>

<div id="footer">
    <span>Copyright © 2017 hello.com All Rights Reserved</span>
</div>
</body>
</html>
