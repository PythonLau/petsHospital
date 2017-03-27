<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang='en'>
    <meta charset='UTF-8'>
    <title></title>
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
                    <label>用户名</label>
                    <input id="registerUserName" name="registerUserName" type="text" placeholder="手机或者电子邮箱" />
                    <span id="warnRegisterName"></span>

                    <label>密码</label>
                    <input id="registerPassWord" name="registerPassWord" type="password"/>
                    <span id="warnRegisterPassword"></span>

                    <label>密码确认</label>
                    <input id="comfirmPassWord" name="comfirmPassWord" type="password"/>
                    <span id="warnComfirmPassWord"></span>

                    <label>昵称</label>
                    <input id="nickName" name="nickName" type="text"/>
                    <span id="warnNickName"></span>

                    <label>手机</label>
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

