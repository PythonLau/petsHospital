<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/24 0024
  Time: 下午 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Title</title>
    <link href="/css/homepage.css" rel="stylesheet">
</head>
<body>
<div id="header">
    <div class="header_left"><a href="#"><img src="image/star.png" class="image"><span>收藏淘淘</span></a></div>
    <div class="header_right"><span>您好！欢迎来到coco！</span>&nbsp;<span>[<a href="#">登录</a>]</span><span>[<a href="#">免费注册</a>]</span>　|　<a href="#">我的订单</a></div>
</div>

<div id="secondHeader">
    <ul>
        <li>
            <div id="secondHeader_img">
                <img src="image/logo.png"/>
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
            <div id="coco"><a href="#"><img src="image/hello.png"/><span style="padding-bottom: 20px">我的coco</span></a></div>
        </li>
        <li>
            <div id="order"><a href="#"><img src="image/order.png"/><span>我的订单</span></a></div>
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

<div id="articleList">
    <div class="row">
        <div class="list col-md-6" style="width:100%;margin:0 auto">
            <h3><a href="#" target="_blank">医院动态</a></h3>
            <ul id="all">
                <c:forEach var="sk" items="${list}">
                    <li>
                        <a href="/article/${sk.id}" target="_blank" title="${sk.title}">${sk.title}</a>
                        <span class="time">${sk.updated}</span>
                    </li>
                </c:forEach>
            </ul>
        </div>
        <div class="page">第<span id="a2"></span>/<span id="a1"></span>页<span id="a3"></span>　<a href="#" onClick="change(--pageno)">上一页</a><a href="#" onClick="change(++pageno)">下一页</a></div>
    </div>
</div>

<div id="footer">
    <span>Copyright © 2017 hello.com All Rights Reserved</span>
</div>
<script>
    var a = document.getElementById("all").getElementsByTagName("li");
    var zz =new Array(a.length);
    for(var i=0;i <a.length;i++){
        zz[i]=a[i].innerHTML;
    } //div的字符串数组付给zz
    var pageno=1 ;              //当前页
    var pagesize=8;            //每页多少条信息
    if(zz.length%pagesize==0){
        var  pageall =zz.length/pagesize ;
    }else{
        var  pageall =parseInt(zz.length/pagesize)+1;
    }   //一共多少页

    function change(e){
        pageno=e;
        if(e<1){ //如果输入页<1页
            e=1;pageno=1;//就等于第1页 ， 当前页为1
        }
        if(e>pageall){  //如果输入页大于最大页
            e=pageall;pageno=pageall; //输入页和当前页都=最大页
        }
        document.getElementById("all").innerHTML=""//全部清空
        for(var i=0;i<pagesize;i++){
            var div =document.createElement("li")//建立div对象
            div.innerHTML=zz[(e-1)*pagesize+i]//建立显示元素
            document.getElementById("all").appendChild(div)//加入all中
            if(zz[(e-1)*pagesize+i+1]==null) break;//超出范围跳出
        }
        var ye="";
        for(var j=1;j<=pageall;j++){
            if(e==j){
                ye=ye+"<span><a href='#' onClick='change("+j+")' style='color:#FF0000'>"+j+"</a></span> "
            }else{
                ye=ye+"<a href='#' onClick='change("+j+")'>"+j+"</a> "
            }
        }
        document.getElementById("a1").innerHTML=pageall;
        document.getElementById("a2").innerHTML=pageno;
        document.getElementById("a3").innerHTML=ye;
    }
    change(1);
</script>
<script type="text/javascript" src="/js/home.js" charset="utf-8"></script>
</body>
</html>
