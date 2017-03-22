<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search" style="padding:3px">
    <select id="search_condition">
        <option value="id">员工ID</option>
        <option value="name">员工姓名</option>
        <option value="sex">性别</option>
        <option value="cid">所属部门</option>
        <option value="status">状态</option>
    </select>
    <input id="search_key" style="line-height:26px;border:1px solid #ccc">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch('1','10')">搜索</a>
</div>
<table class="easyui-datagrid" id="employeeList" title="员工列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/employee/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'id',width:200">员工ID</th>
        <th data-options="field:'name',width:88">姓名</th>
        <th data-options="field:'sex',width:30">性别</th>
        <th data-options="field:'idcard',width:88">身份证</th>
        <th data-options="field:'telephone',width:88">电话</th>
        <th data-options="field:'salary',width:50">薪水</th>
        <th data-options="field:'cid',width:38">所属部门</th>
        <th data-options="field:'status',width:38,align:'center',formatter:TAOTAO.formatEmployeeStatus">状态</th>
        <th data-options="field:'dimissionReason',width:200">离职原因</th>
        <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
        <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
    </tr>
    </thead>
</table>
<div id="employeeEditWindow" class="easyui-window" title="修改员工信息" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/employee-edit'" style="width:80%;height:80%;padding:10px;">
</div>

<script>

    function getSelectionsIds(){
        var employeeList = $("#employeeList");
        var sels = employeeList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].id);
        }
        ids = ids.join(",");
        return ids;
    }

    var toolbar = [{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','必须选择一个员工才能编辑!');
                return ;
            }
            if(ids.indexOf(',') > 0){
                $.messager.alert('提示','只能选择一个员工!');
                return ;
            }

            $("#employeeEditWindow").window({
                onLoad :function(){
                    //回显数据
                    var data = $("#employeeList").datagrid("getSelections")[0];
                    $("#employeeEditForm").form("load",data);

                    TAOTAO.init({
                        "pics" : data.image,
                        "cid" : data.cid,
//                        fun:function(node){
//                            TAOTAO.changeItemParam(node, "employeeEditForm");
//                        }
                    });
                }
            }).window("open");


        }
    }];
</script>
<script>
    function doSearch(pageNumber, pageSize){
        var search_condition =document.getElementById("search_condition").value;
        var search_key =document.getElementById("search_key").value;
        //获取分页大小
        var rows = $(".pagination-page-list").val()
        //页面分页大小与参数是否一样
        if(rows != pageSize){
            pageSize = rows ;
        }
        var search_params = {"search_condition":search_condition,"search_key":search_key,"rows":pageSize,'pageNumber':pageNumber};
        $.ajax({
            url: "/item/search",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(search_params),
            async: true,
            success: function(data) {
                alert("重新加载数据");
                //获取分页控件
                $("#employeeList").datagrid('getPager').pagination({
                    //重新load分页控件
                    //自带属性
                    //原来右边这个是1
                    pageNumber:pageNumber,
                    pageSize:pageSize,
                    //分页触发事件
                    //参数是上面左边紫色自带控件属性传进来的
                    //按上一页或者下一页就会触发这个事件
                    //点击下一页或者上一页pageNumber就会变成2
                    onSelectPage: function(pageNumber, pageSize){
                        //点击一下还是执行search方法
                        alert("还是执行search方法")
                        doSearch(pageNumber, pageSize);
                    }
                })
                $('#employeeList').datagrid('loadData',data);

                alert("加载完毕");
            }
        });
    }

</script>


