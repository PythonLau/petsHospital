<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search" style="padding:3px">
    <select id="search_condition">
        <option value="id">物品ID</option>
        <option value="title">物品名称</option>
        <option value="cid">类别</option>
        <option value="supplier">供应商</option>
        <option value="barcode">条形码</option>
        <option value="status">状态</option>
    </select>
    <input id="search_key" style="line-height:26px;border:1px solid #ccc">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch('1','10')">搜索</a>
</div>
<table class="easyui-datagrid" id="itemList" title="商品列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/item/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'id',width:60">物品ID</th>
        <th data-options="field:'title',width:200">物品名称</th>
        <th data-options="field:'cid',width:100">类别</th>
        <th data-options="field:'supplier',width:100">供应商</th>
        <th data-options="field:'price',width:70,align:'right',formatter:TAOTAO.formatPrice">价格</th>
        <th data-options="field:'num',width:70,align:'right'">库存数量</th>
        <th data-options="field:'barcode',width:100">条形码</th>
        <th data-options="field:'image',width:100">图片</th>
        <th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatItemStatus">状态</th>
        <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
        <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
    </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="itemAddWindow" class="easyui-window" title="新增商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/item-add'" style="width:80%;height:80%;padding:10px;">
</div>

<script>

    function getSelectionsIds(){
        var itemList = $("#itemList");
        var sels = itemList.datagrid("getSelections");
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
                $.messager.alert('提示','必须选择一个商品才能编辑!');
                return ;
            }
            if(ids.indexOf(',') > 0){
                $.messager.alert('提示','只能选择一个商品!');
                return ;
            }

            $("#itemEditWindow").window({
                onLoad :function(){
                    //回显数据
                    var data = $("#itemList").datagrid("getSelections")[0];
                    data.priceView = TAOTAO.formatPrice(data.price);
                    $("#itemeEditForm").form("load",data);

                    TAOTAO.init({
                        "pics" : data.image,
                        "cid" : data.cid,
                        fun:function(node){
                            TAOTAO.changeItemParam(node, "itemeEditForm");
                        }
                    });
                }
            }).window("open");


        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中商品!');
                return ;
            }
            $.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){
                if (r){
                    var params = {"ids":ids};
                    $.ajax({
                        url: "/item/delete",
                        type: "POST",
                        contentType: "application/json",
                        dataType: "json",
                        data: JSON.stringify(params),
                        async: true,
                        success: function(data) {
                            $.messager.alert('提示','删除商品成功!',undefined,function(){
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }];
</script>
<script>
    function doSearch(pageNumber, pageSize){
        var search_condition =document.getElementById("search_condition").value;
        var search_key =document.getElementById("search_key").value;

        var rows = $(".pagination-page-list").val()
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
                $("#itemList").datagrid('getPager').pagination({
                    pageNumber:pageNumber,
                    pageSize:pageSize,
                    onSelectPage: function(pageNumber, pageSize){
                        doSearch(pageNumber, pageSize);
                    }
                })
                $('#itemList').datagrid('loadData',data);

               alert("加载完毕");
            }
        });
    }

</script>


