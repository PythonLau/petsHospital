<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="itemAddForm" class="itemForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>套餐名称:</td>
                <td><input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 228px;"></input></td>
            </tr>
            <tr>
                <td>套餐价格:</td>
                <td><input class="easyui-textbox" type="text" name="price" data-options="required:true" style="width: 68px;"/></td>
            </tr>
            <tr>
                <td>平常折扣:</td>
                <td><input class="easyui-numberbox" type="text" name="normaldiscount" data-options="precision:2,required:true" style="width: 68px;"/></td>
            </tr>
            <tr>
                <td>会员折扣:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="memberdiscount" data-options="required:true" style="width: 68px;" />
                </td>
            </tr>
            <tr>
                <td>套餐图片:</td>
                <td>
                    <a href="javascript:void(0)" class="easyui-linkbutton addEmployeePicFileUpload">上传照片</a>
                    <input type="hidden" name="image"/>
                </td>
            </tr>
            <tr>
                <td>套餐简介:</td>
                <td>
                    <textarea style="width:388px;height:88px;" name="introduction"></textarea>
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
        if(!$('#itemAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }

        $.post("/package/save",$("#itemAddForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','新增员工成功!');
            }
        });
    }

    function clearForm(){
        $('#itemAddForm').form('reset');
    }

    $(document).ready(function(){
        TAOTAO.init();
    })
</script>
