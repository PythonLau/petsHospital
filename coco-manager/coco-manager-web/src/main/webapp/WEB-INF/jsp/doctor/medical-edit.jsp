<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="employeeEditForm" class="itemForm" method="post">
        <input type="hidden" name="id"/>
        <table cellpadding="5">
            <tr>
                <td>病因:</td>
                <td><input class="easyui-textbox" type="text" name="sickname"  data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>床位选择:</td>
                <td>
                    <a href="javascript:void(0)" class="easyui-linkbutton prescribeAcceptSelectBed">选择床位</a>
                    <input type="hidden" name="bedroom" style="width: 280px;"></input>
                </td>
            </tr>
            <tr>
                <td>治疗类型:</td>
                <td>
                    <select id="statusEditSelect" name="statusEditSelect">
                        <option value="2">非住院治疗</option>
                        <option value="3">住院治疗</option>
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
    function submitForm(){
        if(!$('#employeeEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        alert("开始执行");
        $("#employeeEditForm [name=status]").val($("#employeeEditForm [name=statusEditSelect]").val());
        alert("执行了两条");

        $.post("/doctor/medical/update",$("#employeeEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','处理病历完毕!','info',function(){
                    $("#prescribeHandleWindow").window('close');
                    $("#registerList").datagrid("reload");
                });
            }
            if(data.status == 500){
                $.messager.alert('提示',data.msg);
            }
        });
    }
    function clearForm(){
        $('#employeeEditForm').form('reset');
    }
    $(document).ready(function(){
        TAOTAO.init();
    })
</script>
