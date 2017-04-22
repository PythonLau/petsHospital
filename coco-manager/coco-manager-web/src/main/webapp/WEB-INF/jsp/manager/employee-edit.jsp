<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="employeeEditForm" class="itemForm" method="post">
        <input type="hidden" name="id"/>
        <table cellpadding="5">
            <tr>
                <td>职位选择:</td>
                <td>
                    <a href="javascript:void(0)" class="easyui-linkbutton editEmployeeSelectPositionCat">选择职位</a>
                    <input type="hidden" name="cid" style="width: 280px;"></input>
                </td>
            </tr>
            <tr>
                <td>员工姓名:</td>
                <td><input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 228px;"></input></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td>
                    <select id="sexEditSelect" name="sexEditSelect">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                    <input name="sex"/>
                </td>
            </tr>
            <tr>
                <td>身份证:</td>
                <td><input class="easyui-textbox" type="text" name="idcard" data-options="required:true" style="width: 228px;"/></td>
            </tr>
            <tr>
                <td>工资:</td>
                <td><input class="easyui-numberbox" type="text" name="salary" data-options="precision:2,required:true" /></td>
            </tr>
            <tr>
                <td>电话:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="telephone" data-options="required:true" style="width: 228px;" />
                </td>
            </tr>
            <tr>
                <td>员工状态:</td>
                <td>
                    <select id="statusEditSelect" name="statusEditSelect">
                        <option value="1">在职</option>
                        <option value="0">离职</option>
                    </select>
                    <input name="status"/>
                </td>
            </tr>
            <tr>
                <td>员工照片:</td>
                <td>
                    <a href="javascript:void(0)" class="easyui-linkbutton addEmployeePicFileUpload">上传照片</a>
                    <input type="hidden" name="image"/>
                </td>
            </tr>
            <tr>
                <td>离职原因:</td>
                <td>
                    <textarea style="width:388px;height:138px;" name="dimissionreason"></textarea>
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
        $("#employeeEditForm [name=sex]").val($("#employeeEditForm [name=sexEditSelect]").val());
        $("#employeeEditForm [name=status]").val($("#employeeEditForm [name=statusEditSelect]").val());
        alert("执行了两条");

        $.post("/employee/update",$("#employeeEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','修改员工成功!','info',function(){
                    $("#employeeEditWindow").window('close');
                    $("#employeeList").datagrid("reload");
                });
            }
        });
    }
    function clearForm(){
        $('#employeeEditForm').form('reset');
    }
</script>
