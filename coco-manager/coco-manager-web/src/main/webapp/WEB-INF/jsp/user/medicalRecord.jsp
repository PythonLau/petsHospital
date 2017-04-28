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
        table {
            border:1px solid darkblue;
        }
        table th {
            border:1px solid mediumblue;
        }
        table td {
            border:1px solid mediumblue;
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
<div style="width: 100%;background-color: blue">
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
</div>


<div class="search-result top-distance">
    <h5 align="center" style="font-size: 23px; color: #01AAED"><strong>${requestScope.petName}病历</strong></h5>
    <div class="main" style="width: 100%;">
        <div class="container" style="width: 100%;">
            <div class="content">
                <table class="cart-table highlight centered" style="margin-left:0px; width:100%">
                    <thead>
                    <tr>
                        <th width="6%">记录id</th>
                        <th width="15%">记录名称</th>
                        <th width="5%">治疗类型</th>
                        <th width="5%">手术室</th>
                        <th width="5%">还需治疗天数</th>
                        <th width="28%">处方</th>
                        <th width="5%">价格</th>
                        <th width="8%">开始时间</th>
                        <th width="10%">最后治疗时间</th>
                        <th width="6%">状态</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="medicalRecord">
                        <tr style="height: 333px">
                            <td width="6%">${medicalRecord.id}</td>
                            <td width="15%">${medicalRecord.sickName}</td>
                            <td width="5%">
                                <c:choose>
                                    <c:when test="${medicalRecord.room == null}">
                                        普通治疗
                                    </c:when>
                                    <c:otherwise>
                                        手术治疗
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td width="5%">${medicalRecord.room}</td>
                            <td width="5%">${medicalRecord.needdays}</td>
                            <td width="28%">${medicalRecord.recipe}</td>
                            <td width="5%">${medicalRecord.price}</td>
                            <td width="8%">${medicalRecord.created}</td>
                            <td width="10%">${medicalRecord.updated}</td>
                            <td width="6%">
                                <c:if test="${medicalRecord.status == 4}">
                                    <button class="layui-btn layui-btn-mini layui-btn-normal">已结束</button>
                                </c:if>
                                <c:if test="${medicalRecord.status == 3}">
                                    <button class="layui-btn layui-btn-primary layui-btn-mini">已缴费</button>
                                </c:if>
                                <c:if test="${medicalRecord.status == 1 || medicalRecord.status == 2}">
                                    <button class="layui-btn layui-btn-mini layui-btn-normal">治疗中</button>
                                </c:if>
                                <c:if test="${medicalRecord.status == 0}">
                                    <button class="layui-btn layui-btn-primary layui-btn-mini">不接受</button>
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