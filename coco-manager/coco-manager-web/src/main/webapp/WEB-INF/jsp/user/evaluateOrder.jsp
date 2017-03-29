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
    <title>新增宠物</title>
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
    <script type="text/javascript" src="/js/evaluateOrder.js"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">评价服务</h1>
    <form id="addPetForm" method="post">
        <div class="signup">
            <div class="card">
                <span style="color:red">
						<%
                            Object name = request.getAttribute("editPetFail");
                            if(name != null){
                                out.println(name.toString());
                            }
                        %>
                </span>
                <div class="input-field">
                    <input type="hidden" id="id" name="id" value="${order.id}"/>
                    <label>套餐名称</label>
                    <input id="name" name="name" type="text" readonly="true" placeholder="请限制在20个字符内" value="${requestScope.packageName}"/>

                    <label>套餐评分</label>
                    <input id="score" name="score" type="text" placeholder="0-10分之间，不能带有小数点"/>

                    <label>套餐评价</label>
                    <input id="words" name="words" type="text" placeholder="请简单评价,30字内"/>

                </div>
                <button type="submit" id="signup-button" style="width: 100%;" class="btn">评&nbsp;价</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>

