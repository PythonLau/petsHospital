<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/27 0027
  Time: 下午 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评价治疗服务</title>
    <link rel='stylesheet' href='/css/common.css'>
    <link rel='stylesheet' href='/css/signup.css'>
    <link rel="stylesheet" href="/css/input.css"/>
    <link rel="stylesheet" href="/css/btn.css"/>
    <link rel="stylesheet" href="/css/card.css"/>
    <link rel="stylesheet" href="/css/error-box.css"/>
    <link rel="stylesheet" href="/css/material-icons.css"/>
    <link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">l
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="/css/taotao.css" />
    <script src="/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
</head>
<body>
<div class="container">
    <h5 align="center" style="font-size: 33px; color: #01AAED"><strong>评价服务</strong></h5>
    <form id="addPetForm" method="post" action="/user/evaluateMedical">
        <div class="signup">
            <div class="card">
                <div class="input-field">
                    <input type="hidden" id="id" name="id" value="${medical.id}"/>
                    <label>病因</label>
                    <input id="name" name="name" type="text" readonly="true" value="${medical.sickname}"/>

                    <label>治疗效果评价</label>
                    <textarea id="words" name="words" style="width: 100%;height: 188px" type="text" placeholder="请评价此次治疗效果"></textarea>

                </div>
                <button type="submit" id="signup-button" style="width: 100%;" class="btn">评&nbsp;价</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>

