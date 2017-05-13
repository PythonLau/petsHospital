<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/24 0024
  Time: 下午 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="/css/taotao.css" />
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/js/common.js"></script>
    <style type="text/css">
        .content {
            padding: 10px 10px 10px 10px;
        }
    </style>
</head>
<body>
<table class="easyui-datagrid" id="itemList" title="治疗记录列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'${requestScope.url}',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'id',width:133">治疗记录ID</th>
        <th data-options="field:'sickname',width:166">记录名称</th>
        <th data-options="field:'room',width:60">手术室</th>
        <th data-options="field:'recipe',width:500">处方</th>
        <th data-options="field:'needdays',width:88">还需治疗天数</th>
        <th data-options="field:'price',width:66">治疗费用</th>
        <th data-options="field:'status',width:66,formatter:TAOTAO.formatMedicalDetailStatus">状态</th>
        <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建记录时间</th>
        <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新记录时间</th>
        <th data-options="field:'medicalid',width:133">病历ID</th>
    </tr>
    </thead>
</table>
<div id="prescribeWindow" class="easyui-window" title="处理" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/manager/medicalDetail-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
        var registerList = $("#itemList");
        var sels = registerList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].id);
        }
        ids = ids.join(",");
        return ids;
    }

    var toolbar = [{
        text:'处理',
        iconCls:'icon-edit',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','必须选择一个病历才能进行治疗!');
                return ;
            }
            if(ids.indexOf(',') > 0){
                $.messager.alert('提示','只能选择一个病历!');
                return ;
            }
            $("#prescribeWindow").window({
                onLoad :function(){
                    //回显数据
                    var data = $("#itemList").datagrid("getSelections")[0];
                    $("#prescribeForm").form("load",data);

                    TAOTAO.init({
                        "pics" : data.image,
                        "cid" : data.cid,
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
        var beginDate = document.getElementById("beginDate").value;
        var endDate = document.getElementById("endDate").value;
        //获取分页大小
        var rows = $(".pagination-page-list").val()
        //页面分页大小与参数是否一样
        if(rows != pageSize){
            pageSize = rows ;
        }
        var search_params = {"search_condition":search_condition,"search_key":search_key,"beginDate":beginDate,"endDate":endDate,"rows":pageSize,'pageNumber':pageNumber};
        $.ajax({
            url: "/doctor/medical/search",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(search_params),
            async: true,
            success: function(data) {
                alert("重新加载数据");
                //获取分页控件
                $("#registerList").datagrid('getPager').pagination({
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
                $('#registerList').datagrid('loadData',data);

                alert("加载完毕");
            }
        });
    }

</script>
</body>
</html>
