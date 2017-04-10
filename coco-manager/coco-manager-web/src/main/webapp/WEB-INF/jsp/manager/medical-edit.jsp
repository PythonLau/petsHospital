<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="MedicalEditForm" class="itemForm" method="post">
        <input type="hidden" name="id"/>
        <table cellpadding="5">
            <tr>
                <td>宠物名字:</td>
                <td><input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 228px;"></input></td>
            </tr>
            <tr>
                <td>医生姓名:</td>
                <td><input class="easyui-textbox" type="text" name="doctorName" data-options="required:true" style="width: 228px;"></input></td>
            </tr>
            <tr>
                <td>治疗时间:</td>
                <td><input class="easyui-textbox" type="text" name="medicalTime" data-options="required:true" style="width: 228px;"></input></td>
            </tr>
            <tr>
                <td>治疗费用:</td>
                <td><input class="easyui-textbox" type="text" name="price" data-options="required:true" style="width: 228px;"></input></td>
            </tr>
            <tr>
                <td>状态:</td>
                <td>
                    <select id="statusEditSelect" name="statusEditSelect">
                        <option value="0">无效</option>
                        <option value="1">挂号中</option>
                        <option value="2">医生已处理</option>
                        <option value="3">已结束</option>
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
        if(!$('#MedicalEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        $("#MedicalEditForm [name=status]").val($("#MedicalEditForm [name=statusEditSelect]").val());

        $.post("/manager/medical/update",$("#MedicalEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','处理病历完毕!','info',function(){
                    $("#prescribeWindow").window('close');
                    $("#medicalList").datagrid("reload");
                });
            }
        });
    }
    function clearForm(){
        $('#MedicalEditForm').form('reset');
    }
</script>
