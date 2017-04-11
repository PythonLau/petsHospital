<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="orderEditForm" class="itemForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>订单id:</td>
                <td><input class="easyui-textbox" type="text" name="id" data-options="required:true" readonly="true" style="width: 228px;"></input></td>
            </tr>
            <tr>
                <td>用户id:</td>
                <td><input class="easyui-textbox" type="text" name="userid" data-options="required:true" readonly="true" style="width: 228px;"></input></td>
            </tr>
            <tr>
                <td>套餐id:</td>
                <td><input class="easyui-textbox" type="text" name="packageId" data-options="required:true" readonly="true" style="width: 228px;"></input></td>
            </tr>
            <tr>
                <td>套餐费用:</td>
                <td><input class="easyui-textbox" type="text" name="price" data-options="required:true" style="width: 228px;"></input></td>
            </tr>
            <tr>
                <td>状态:</td>
                <td>
                    <select id="statusEditSelect" name="statusEditSelect">
                        <option value="0">已取消</option>
                        <option value="1">待服务</option>
                        <option value="2">服务结束</option>
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
        if(!$('#orderEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        $("#orderEditForm [name=status]").val($("#orderEditForm [name=statusEditSelect]").val());

        $.post("/manager/order/update",$("#orderEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','处理订单完毕!','info',function(){
                    $("#orderEditWindow").window('close');
                    $("#orderList").datagrid("reload");
                });
            }
        });
    }
    function clearForm(){
        $('#orderEditForm').form('reset');
    }
</script>
