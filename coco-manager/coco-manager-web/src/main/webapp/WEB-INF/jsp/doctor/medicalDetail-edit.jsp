<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="prescribeForm" class="itemForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>病历Id:</td>
                <td><input class="easyui-textbox" type="text" name="id" readonly="true" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>床位选择:</td>
                <td>
                    <a href="javascript:void(0)" class="easyui-linkbutton prescribeEditSelectRoom">选择职位</a>
                    <input type="hidden" name="room" style="width: 280px;"></input>
                </td>
            </tr>
            <tr>
                <td>处方名称:</td>
                <td><input class="easyui-textbox" type="text" name="sickname" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>还需治疗天数:</td>
                <td><input class="easyui-textbox" type="text" name="needdays" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>治疗方式:</td>
                <td>
                    <select id="statusEditSelect" name="statusEditSelect">
                        <option value="1">普通治疗</option>
                        <option value="2">手术治疗</option>
                    </select>
                    <input name="status" type="hidden"/>
                </td>
            </tr>
            <tr>
                <td>处方:</td>
                <td>
                    <textarea style="width:888px;height:666px;visibility:hidden;" name="recipe"></textarea>
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentAddPage.submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="contentAddPage.clearForm()">重置</a>
    </div>
</div>
<script type="text/javascript">
    var contentAddEditor ;
    $(function(){
        contentAddEditor = TT.createEditor("#prescribeForm [name=recipe]");
        //test

        TT.initOnePicUpload();
    });
    var contentAddPage  = {
        submitForm : function (){
            if(!$('#prescribeForm').form('validate')){
                $.messager.alert('提示','表单还未填写完成!');
                return ;
            }
            contentAddEditor.sync();
            alert("开始执行");
            $("#employeeEditForm [name=status]").val($("#employeeEditForm [name=statusEditSelect]").val());
            alert("执行了两条");

            $.post("/doctor/medicalDetail/save",$("#prescribeForm").serialize(), function(data){
                if(data.status == 200){
                    $.messager.alert('提示','开处方成功!');
                }
            });
        },
        clearForm : function(){
            $('#prescribeForm').form('reset');
            contentAddEditor.html('');
        }
    };
</script>
