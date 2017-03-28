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
    <script type="text/javascript" src="/js/addPets.js"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">新增宠物</h1>
    <form id="addPetForm" method="post">
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
                    <label>宠物名字</label>
                    <input id="petName" name="petName" type="text" placeholder="请限制在20个字符内"/>
                    <span id="warnPetName"></span>

                    <label>宠物类型</label>
                    <input id="typeName" name="typeName" type="text" placeholder="请输入正确的宠物类型"/>

                    <label>宠物年龄</label>
                    <input id="petAge" name="petAge" type="text" placeholder="1-30岁之间"/>
                    <span id="warnPetAge"></span>

                    <label>宠物性别</label>
                    <input id="petSex" name="petSex" type="text" placeholder="请输入公或者母"/>
                    <span id="warnPetSex"></span>

                    <label>只能上传一张宠物的照片</label>
                    <a href="javascript:void(0)" class="easyui-linkbutton addEmployeePicFileUpload">上传照片</a>
                    <input type="hidden" name="image"/>
                </div>
                <button type="submit" id="signup-button" style="width: 100%;" class="btn">新&nbsp;增</button>
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

