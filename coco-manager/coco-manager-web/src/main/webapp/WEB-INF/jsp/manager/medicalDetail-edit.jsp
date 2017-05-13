<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="prescribeForm" class="itemForm" method="post">
        <input name="medicalid">
        <table cellpadding="5">
            <tr>
                <td>治疗记录Id:</td>
                <td><input class="easyui-textbox" type="text" name="id" readonly="true" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>处方名称:</td>
                <td><input class="easyui-textbox" type="text" name="sickname" readonly="true" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>费用:</td>
                <td><input class="easyui-textbox" type="text" name="price" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>状态:</td>
                <td>
                    <select id="statusEditSelect" name="statusEditSelect">
                        <option value="0">已取消</option>
                        <option value="3">已缴费</option>
                        <option value="4">已结束</option>
                    </select>
                    <input name="status" type="hidden"/>
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
        $(document).ready(function(){

        })
        function submitForm(){
            if(!$('#prescribeForm').form('validate')){
                $.messager.alert('提示','表单还未填写完成!');
                return ;
            }
            alert("开始执行");
            $("#prescribeForm [name=status]").val($("#prescribeForm [name=statusEditSelect]").val());
            alert("执行了两条");

            $.post("/manager/medicalDetail/update",$("#prescribeForm").serialize(), function(data){
                if(data.status == 200){
                    $.messager.alert('提示','处理病历成完毕!','info',function(){
                        $("#prescribeWindow").window('close');
                        $("#itemList").datagrid("reload");
                    });
                }
            });
        }
        function clearForm(){
            $('#prescribeForm').form('reset');
            contentAddEditor.html('');
        }
</script>
