<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="packageEditForm" class="itemForm" method="post">
        <input type="hidden" name="id"/>
        <table cellpadding="5">
            <tr>
                <td>报表名称:</td>
                <td><input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 228px;"></input></td>
            </tr>
            <tr>
                <td>报表链接:</td>
                <td><input class="easyui-textbox" type="text" name="url" data-options="required:true" style="width: 68px;"/></td>
            </tr>
            <tr>
                <td>排列序号:</td>
                <td><input class="easyui-numberbox" type="text" name="sortOrder" data-options="required:true" style="width: 68px;"/></td>
            </tr>
            <tr>
                <td>是否可使用:</td>
                <td>
                    <select id="statusEditSelect" name="statusEditSelect">
                        <option value="0">不可用</option>
                        <option value="1">可用</option>
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
    //提交表单
    function submitForm(){
        //有效性验证
        if(!$('#packageEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }

        alert($("#packageEditForm [name=status]").val());
        $("#packageEditForm [name=status]").val($("#packageEditForm [name=statusEditSelect]").val());
        alert($("#packageEditForm [name=status]").val());

        $.post("/manager/module/detail/update",$("#packageEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增员工成功!');
            }
        });
    }

    function clearForm(){
        $('#packageEditForm').form('reset');
    }

    $(document).ready(function(){
        TAOTAO.init();
    })
</script>
