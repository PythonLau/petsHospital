<%--
  Created by IntelliJ IDEA.
  User: wild_wolf
  Date: 6/14/16
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>coco用户登录</title>
	<link rel="stylesheet" href="/css/common.css"/>
	<link rel="stylesheet" href="/css/card.css"/>
	<link rel="stylesheet" href="/css/error-box.css"/>
	<link rel="stylesheet" href="/css/btn.css"/>
	<link rel="stylesheet" href="/css/userLogin.css"/>
	<link rel="stylesheet" href="/css/input.css"/>
	<link rel="stylesheet" href="iconfont/material-icons.css"/>
	<script src="/js/jquery-2.1.3.min.js" type="text/javascript"></script>

	<script src="/js/login.js"></script>

	<script src="/js/error-box.js" type="text/javascript"></script>
</head>
<body>

<div class="container">
	<h1 class="text-center">coco用户登录</h1>
	<form id="userLoginForm" action="/userLogin/loginConfirm" method="post">
		<div class="login">
			<div class="card">
				<span style="color:green">
						<%
							Object registerSuccessMessage = request.getAttribute("registerSuccess");
							if(registerSuccessMessage != null){
								out.println(registerSuccessMessage.toString());
							}
						%>
				</span>
				<div class="input-field">
					<label for="username">用户名</label>
					<input id="username" name="username" type="text"/>
					<label for="password">密码</label>
					<input id="password" name="password" type="password"/>
				</div>
				<button type="submit" id="btn-login" class="btn" style="width: 100%;">登&nbsp;录</button>
				<div class="foot">
					<span style="color:red">
						<%
							Object wrongMessage = request.getAttribute("wrong");
							if(wrongMessage != null){
								out.println(wrongMessage.toString());
							}
						%>
					</span>
					<a href="/register" style="float:right;">没有帐户？</a>
				</div>
			</div>
		</div>
	</form>
</div>
</body>
</html>
