<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/26 0026
  Time: 下午 5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>登录</title>
	<link rel="stylesheet" href="/css/layui.css" media="all" />
	<link rel="stylesheet" href="/css/login.css" />
</head>

<body class="beg-login-bg">
<div class="beg-login-box">
	<header>
		<h1>coco宠物医院管理员后台登录</h1>
	</header>
	<div class="beg-login-main">
		<form action="/managerLogin/loginConfirm" id="managerLoginForm" class="layui-form" method="post"><input name="__RequestVerificationToken" type="hidden" value="fkfh8D89BFqTdrE2iiSdG_L781RSRtdWOH411poVUWhxzA5MzI8es07g6KPYQh9Log-xf84pIR2RIAEkOokZL3Ee3UKmX0Jc8bW8jOdhqo81" />
			<div class="layui-form-item">
				<label class="beg-login-icon">
					<i class="layui-icon">&#xe612;</i>
				</label>
				<input type="text" name="username" lay-verify="useruame" autocomplete="off" placeholder="这里输入登录名" class="layui-input">
			</div>
			<div class="layui-form-item">
				<label class="beg-login-icon">
					<i class="layui-icon">&#xe642;</i>
				</label>
				<input type="password" name="password" lay-verify="password" autocomplete="off" placeholder="这里输入密码" class="layui-input">
			</div>
			<div class="layui-form-item">
				<div class="beg-pull-right">
					<span font-size="3px" color="red">
						<%
						Object name = request.getAttribute("wrong");
						if(name != null){
							out.println(name.toString());
						}
					    %>
					</span>
					<button class="layui-btn layui-btn-primary" lay-submit lay-filter="login">
						<i class="layui-icon">&#xe650;</i> 登录
					</button>
				</div>
				<div class="beg-clear"></div>
			</div>
		</form>
	</div>
	<footer>
		<p>coco宠物医院</p>
	</footer>
</div>
<script type="text/javascript" src="/js/layui.js"></script>
<script>

</script>
</body>
</html>
