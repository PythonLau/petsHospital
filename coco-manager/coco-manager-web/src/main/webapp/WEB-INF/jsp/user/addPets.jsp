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
    <script src="/js/jquery-1.11.1.min.js"></script>
    <script src="/js/register.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">coco新用户注册</h1>
    <form id="userRegisterForm" method="post">
        <div class="signup">
            <div class="card">
                <span style="color:red">
						<%
                            Object name = request.getAttribute("registerFail");
                            if(name != null){
                                out.println(name.toString());
                            }
                        %>
                </span>
                <div class="input-field">
                    <label>宠物名字</label>
                    <input id="registerUserName" name="registerUserName" type="text" placeholder="手机或者电子邮箱" />

                    <label>宠物类型</label>
                    <input id="registerPassWord" name="registerPassWord" type="password"/>

                    <label>宠物年龄</label>
                    <input id="comfirmPassWord" name="comfirmPassWord" type="password"/>

                    <label>宠物性别</label>
                    <input id="nickName" name="nickName" type="text"/>

                    <label>宠物照片</label>
                    <input id="telePhone" name="telePhone" type="text"/>
                    <span id="warnPhone"></span>
                </div>
                <button type="submit" id="signup-button" style="width: 100%;" class="btn">注&nbsp;册</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
