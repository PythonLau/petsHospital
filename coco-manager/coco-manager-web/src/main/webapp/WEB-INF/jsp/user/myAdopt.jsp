<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: wild_wolf
  Date: 11/8/15
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/css/common.css">
    <link rel="stylesheet" href="/css/header.css"/>
    <link rel="stylesheet" href="/css/material-icons.css">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/layui.css">
    <link href="/css/homepage.css" rel="stylesheet">
    <style>
        .cart {
            padding-top: 100px;
        }
        .cart .delete {
            font-size: 13px;
            font-weight: bold;
        }
        .cart-table-bookname {
            text-overflow: ellipsis;
        }
        .cart #totalMoney {
            font-size: 15px;
            text-align: center;
            font-weight: bold;
            padding-bottom: 20px;
        }
        .cart #totalMoney span {
            color: #ff0000;
            font-size: 20px;
        }
        .cart .operation {
            padding-top: 50px;
            float: right;
        }
        .cart .operation .btn {
            width: 150px;
        }
    </style>

    <script src="js/jquery-2.1.3.min.js"></script>
</head>
<body>

<div id="header">
    <div class="header_left"><a href="#"><img src="/image/star.png" class="image"><span>coco宠物医院</span></a></div>
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
                    <div class="" style="width: 60px; height: 26px; position: absolute; margin-left: 233px; margin-top: 3px;">
                        <button class="btn-search" type="submit" >搜索</button>
                    </div>
                    <div class="search-input">
                        <input class="search-input-content1" >
                    </div>
                </form>
            </div>
        </li>
        <c:if test="${sessionScope.nickName != null}">
            <li>
                <div id="coco">
                    <a href="#">
                        <img src="/image/hello.png"/>
                        <span style="padding-bottom: 20px">
                        我的订单
                    </span>

                    </a>
                </div>
            </li>
            <li>
                <div id="order">
                    <a href="/user/myPets">
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
            <div class="content">
                <table class="cart-table highlight centered">
                    <thead>
                    <tr>
                        <th>宠物名称</th>
                        <th>寄养人电话</th>
                        <th>寄养人地址</th>
                        <th>宠物照片</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="adopt">
                        <tr>
                            <td>${adopt.name}</td>
                            <td>${adopt.telePhone}</td>
                            <td>${adopt.address}</td>
                            <td><img src="${adopt.image}" height="50" width="50"></td>
                            <td>
                                <c:if test="${adopt.status == 1}">
                                    <a href="javascript:if(confirm('确实要取消领养吗?'))location='/user/cancelAdopt/${adopt.id}'">
                                        <button class="layui-btn layui-btn-mini layui-btn-normal">取消领养</button>
                                    </a>
                                </c:if>
                                <c:if test="${adopt.status == 0}">
                                    <button class="layui-btn layui-btn-primary layui-btn-mini">已结束</button>
                                </c:if>
                                <c:if test="${order.status == 2}">
                                    <button class="layui-btn layui-btn-primary layui-btn-mini">已领养</button>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div style="float: right; height: 100px; line-height: 100px; display: inline-block; padding: 30px 15px;">
            共 ${requestScope.packagePage.totalPageNumber } 页
            &nbsp;&nbsp;
            当前第 ${requestScope.packagePage.currentPageNo } 页
            &nbsp;&nbsp;

            <c:if test="${requestScope.packagePage.hasPrev }">
                <a href="/user/orderList/1">首页</a>
                &nbsp;&nbsp;
                <a href="/package/${requestScope.packagePage.prevPage }">上一页</a>
            </c:if>

            &nbsp;&nbsp;

            <c:if test="${requestScope.packagePage.hasNext }">
                <a href="/user/orderList/${requestScope.packagePage.nextPage }">下一页</a>
                &nbsp;&nbsp;
                <a href="/user/orderList/${requestScope.packagePage.totalPageNumber }">末页</a>
            </c:if>

            &nbsp;&nbsp;

            转到 <input type="text" id="pageNo" style="width: 33px; height: 23px"/> 页
        </div>
    </div>
</div>


<script>
    $(function () {
        $('.delete').click(function () {
            var $tr = $(this).parent().parent();
            var title = $.trim($tr.find('td:first').text());
            var flag = confirm("确定要删除" + title + "的信息吗？");
            if (flag) {
                return true;
            }
            return false;
        });
    });
    // ajax 修改单个商品数量
    // 1. 获取页面中所有的text，并为其添加onchange 响应函数
    $(":text").change(function () {
        // 2. 请求地址为：book-
        var url = "book-updateItemQuantity";
        // 3. 请求参数为：method：updateItemQuantity，id:name 属性值，quantity:val，signupDate:new Date()
        var idVal = $.trim(this.name);
        var quantityVal = $.trim(this.value);
        var args = {"id": idVal, "quantity": quantityVal};
        var that = $(this);
        console.log(args);
        $.post(url, args, function (data) {
            var bookNumber = data.bookNumber;
            var totalMoney = format(data.totalMoney);
            var quantity = data.quantity;
            var itemMoney = data.itemMoney;
            console.log('itemMoney:' + itemMoney);
            // 服务器值
            $('#totalMoney span').text("¥" + totalMoney);
            that.text(quantity);
            that.parent().parent().find('.money').text(format(itemMoney));
        }, "JSON");
    });
    function format(num) {
        num = num.toFixed(3);
        return num.substring(0, num.lastIndexOf('.') + 3);
    }
</script>


</body>
</html>