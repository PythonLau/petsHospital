<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="accountEditForm" class="itemForm" method="post">
        <input type="hidden" name="id"/>
        <table cellpadding="5">
            <tr>
                <td>登录名:</td>
                <td><input class="easyui-textbox" type="text" name="loginname" data-options="required:true" style="width: 228px;" readonly="true"></input></td>
            </tr>
            <tr>
                <td>昵称:</td>
                <td><input class="easyui-textbox" type="text" name="nickname" data-options="required:true" style="width: 228px;" readonly="true"></input></td>
            </tr>
            <tr>
                <td>手机号码:</td>
                <td><input class="easyui-textbox" type="text" name="telphone" data-options="required:true" style="width: 228px;" readonly="true"></input></td>
            </tr>
            <tr>
                <td>状态:</td>
                <td>
                    <select id="statusEditSelect" name="statusEditSelect">
                        <option value="0">注销</option>
                        <option value="1">普通用户</option>
                        <option value="2">会员</option>
                    </select>
                    <input name="status"/>
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
    </div>
</div>
<script type="text/javascript">
    function submitForm(){
        if(!$('#accountEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        $("#accountEditForm [name=status]").val($("#accountEditForm [name=statusEditSelect]").val());

        $.post("/manager/account/update",$("#accountEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','更改用户级别成功!','info',function(){
                    $("#prescribeWindow").window('close');
                    $("#medicalList").datagrid("reload");
                });
            }
        });
    }
    function clearForm(){
        $('#accountEditForm').form('reset');
    }
</script>
