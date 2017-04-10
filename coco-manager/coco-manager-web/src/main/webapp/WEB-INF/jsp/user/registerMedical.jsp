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
    <script type="text/javascript" src="/js/registerMedical.js"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">宠物挂号</h1>
    <%--action="/user/registerMedical"--%>
    <form id="registerMedical"  method="post">
        <div class="signup">
            <div class="card">
                <span style="color:red">
						<%
                            Object name = request.getAttribute("addPetFail");
                            if(name != null){
                                out.println(name.toString());
                            }
                        %>
                </span>
                <div class="input-field">
                    <input type="hidden" id="id" name="id" value="${pet.id}"/>
                    <h3>
                        <label>挂号科室</label>
                    </h3>
                    <a href="javascript:void(0)" class="easyui-linkbutton registerMedicalSelectPositionCat">选择挂号科室</a>
                    <input type="hidden" id="cid" name="cid" style="width: 280px;"></input>
                    <span id="warnCid"></span>
                    <label>宠物名字</label>
                    <input id="name" name="name" type="text" readonly="true" value="${pet.name}"/>

                    <label>预约时间</label>
                    <input id="registerTime" id="registerTime" name="registerTime" type="date"/>
                    <span id="warnRegisterTime"></span>

                </div>
                <button type="submit" id="signup-button" style="width: 100%;" class="btn">挂&nbsp;号</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
<script>
    $(document).ready(function(){
        TAOTAO.init();
    })
</script>

