<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search" style="padding:3px">
    <select id="search_condition">
        <option value="userId">用户ID</option>
    </select>
    <input id="search_key" style="line-height:18px;border:1px solid #ccc">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch('1','10')">搜索</a>
</div>
<table class="easyui-datagrid" id="packageList" title="报表列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/manager/authority/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'id',width:133">权限ID</th>
        <th data-options="field:'userId',width:123">用户ID</th>
        <th data-options="field:'moduleName',width:188">报表名称</th>
        <th data-options="field:'created',width:138,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
        <th data-options="field:'updated',width:138,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
    </tr>
    </thead>
</table>
<div id="packageEditWindow" class="easyui-window" title="修改报表信息" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/manager/module-edit'" style="width:80%;height:80%;padding:10px;">
</div>

<script>

    function getSelectionsIds(){
        var packageList = $("#packageList");
        var sels = packageList.datagrid("getSelections");
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

            $("#packageEditWindow").window({
                onLoad :function(){
                    //回显数据
                    var data = $("#packageList").datagrid("getSelections")[0];
                    $("#packageEditForm").form("load",data);

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
            url: "/manager/authority/search",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(search_params),
            async: true,
            success: function(data) {
                alert("重新加载数据");
                //获取分页控件
                $("#packageList").datagrid('getPager').pagination({
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
                $('#packageList').datagrid('loadData',data);

                alert("加载完毕");
            }
        });
    }

</script>


