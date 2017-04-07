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
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <style type="text/css">
        * {
            padding: 0px;
            margin: 0px;
        }
        a {
            text-decoration: none;
        }
        ul {
            list-style: outside none none;
        }
        .slider, .slider-panel img, .slider-extra {
            width: 1111px;
            height: 333px;
        }
        .slider {
            text-align: center;
            margin: 30px auto;
            position: relative;
        }
        .slider-panel, .slider-nav, .slider-pre, .slider-next {
            position: absolute;
            z-index: 8;
        }
        .slider-panel {
            position: absolute;
        }
        .slider-panel img {
            border: none;
        }
        .slider-extra {
            position: relative;
        }
        .slider-nav {
            margin-left: -51px;
            position: absolute;
            left: 50%;
            bottom: 4px;
        }
        .slider-nav li {
            background: #3e3e3e;
            border-radius: 50%;
            color: #fff;
            cursor: pointer;
            margin: 0 2px;
            overflow: hidden;
            text-align: center;
            display: inline-block;
            height: 18px;
            line-height: 18px;
            width: 18px;
        }
        .slider-nav .slider-item-selected {
            background: blue;
        }
        .slider-page a{
            background: rgba(0, 0, 0, 0.2);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#33000000,endColorstr=#33000000);
            color: #fff;
            text-align: center;
            display: block;
            font-family: "simsun";
            font-size: 22px;
            width: 28px;
            height: 62px;
            line-height: 62px;
            margin-top: -31px;
            position: absolute;
            top: 50%;
        }
        .slider-page a:HOVER {
            background: rgba(0, 0, 0, 0.4);
            filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#66000000,endColorstr=#66000000);
        }
        .slider-next {
            left: 100%;
            margin-left: -28px;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function() {
            var length,
                currentIndex = 0,
                interval,
                hasStarted = false, //是否已经开始轮播
                t = 3000; //轮播时间间隔
            length = $('.slider-panel').length;

            //将除了第一张图片隐藏
            $('.slider-panel:not(:first)').hide();
            //将第一个slider-item设为激活状态
            $('.slider-item:first').addClass('slider-item-selected');
            //隐藏向前、向后翻按钮
            $('.slider-page').hide();

            //鼠标上悬时显示向前、向后翻按钮,停止滑动，鼠标离开时隐藏向前、向后翻按钮，开始滑动
            $('.slider-panel, .slider-pre, .slider-next').hover(function() {
                stop();
                $('.slider-page').show();
            }, function() {
                $('.slider-page').hide();
                start();
            });

            $('.slider-item').hover(function(e) {
                stop();
                var preIndex = $(".slider-item").filter(".slider-item-selected").index();
                currentIndex = $(this).index();
                play(preIndex, currentIndex);
            }, function() {
                start();
            });

            $('.slider-pre').unbind('click');
            $('.slider-pre').bind('click', function() {
                pre();
            });
            $('.slider-next').unbind('click');
            $('.slider-next').bind('click', function() {
                next();
            });

            /**
             * 向前翻页
             */
            function pre() {
                var preIndex = currentIndex;
                currentIndex = (--currentIndex + length) % length;
                play(preIndex, currentIndex);
            }
            /**
             * 向后翻页
             */
            function next() {
                var preIndex = currentIndex;
                currentIndex = ++currentIndex % length;
                play(preIndex, currentIndex);
            }
            /**
             * 从preIndex页翻到currentIndex页
             * preIndex 整数，翻页的起始页
             * currentIndex 整数，翻到的那页
             */
            function play(preIndex, currentIndex) {
                $('.slider-panel').eq(preIndex).fadeOut(500)
                    .parent().children().eq(currentIndex).fadeIn(1000);
                $('.slider-item').removeClass('slider-item-selected');
                $('.slider-item').eq(currentIndex).addClass('slider-item-selected');
            }

            /**
             * 开始轮播
             */
            function start() {
                if(!hasStarted) {
                    hasStarted = true;
                    interval = setInterval(next, t);
                }
            }
            /**
             * 停止轮播
             */
            function stop() {
                clearInterval(interval);
                hasStarted = false;
            }

            //开始轮播
            start();
        });
    </script>
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
        <c:if test="${sessionScope.nickName != null}">
            <a href="/user/petsList">我的宠物</a>
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
                    <div class="" style="width: 60px; height: 26px; position: absolute; margin-left: 233px; margin-top: 3px;">
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
                    <a href="/user/adoptList/1">
                        <img src="/image/order.png"/>
                        <span>
                        领养动态
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
<div class="slider">
    <ul class="slider-main">
        <c:forEach var="sliders" items="${sliders}">
            <li class="slider-panel">
                <a href="${sliders.href}" target="_blank"><img alt="${sliders.alt}" title="${sliders.title}" src="${sliders.src}"></a>
            </li>
        </c:forEach>
    </ul>
    <div class="slider-extra">
        <ul class="slider-nav">
            <c:forEach var="sliders" items="${sliders}">
                <li class="slider-item">${sliders.sortOrder}</li>
            </c:forEach>
        </ul>
        <div class="slider-page">
            <a class="slider-pre" href="javascript:;;">&lt;</a>
            <a class="slider-next" href="javascript:;;">&gt;</a>
        </div>
    </div>
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
