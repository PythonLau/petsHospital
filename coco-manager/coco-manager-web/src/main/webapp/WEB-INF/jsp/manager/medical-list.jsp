<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search" style="padding:3px">
    <select id="search_condition">
        <option value="id">病历ID</option>
        <option value="positionName">部门名称</option>
        <option value="status">状态</option>
    </select>
    <input id="search_key" style="line-height:26px;border:1px solid #ccc">
    开始时间<input type="date" id="beginDate" name="beginDate">
    结束时间<input type="date" id="endDate" name="endDate">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch('1','10')">搜索</a>
</div>
<table class="easyui-datagrid" id="medicalList" title="病历列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/manager/medical/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'id',width:133">病历id</th>
        <th data-options="field:'petName',width:130">宠物名字</th>
        <th data-options="field:'sickname',width:180">病因</th>
        <th data-options="field:'status',width:73,formatter:TAOTAO.formatMedicalStatus">状态</th>
        <th data-options="field:'bedRoom',width:66">床位</th>
        <th data-options="field:'price',width:66">价格</th>
        <th data-options="field:'nickName',width:130">主人昵称</th>
        <th data-options="field:'telePhone',width:130">主人电话</th>
        <th data-options="field:'startMedicalTime',width:130,align:'center',formatter:TAOTAO.formatDateTime1">开始治疗时间</th>
        <th data-options="field:'endMedicalTime',width:130,align:'center',formatter:TAOTAO.formatDateTime1">最后治疗时间</th>
        <th data-options="field:'word',width:200">用户评价</th>

    </tr>
    </thead>
</table>
<div id="prescribeWindow" class="easyui-window" title="处理该病历信息" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/manager/medical-edit'" style="width:80%;height:80%;padding:10px;">
</div>

<script>

    function getSelectionsIds(){
        var medicalList = $("#medicalList");
        var sels = medicalList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].id);
        }
        ids = ids.join(",");
        return ids;
    }

    var toolbar = [{
        text:'查看',
        iconCls:'icon-edit',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','必须选择一个病历才能处理!');
                return ;
            }
            if(ids.indexOf(',') > 0){
                $.messager.alert('提示','只能选择一个病历!');
                return ;
            }
            window.open('/manager/medical/' + ids);
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
        var searchParamsWithTime = {"search_condition":search_condition,"search_key":search_key,"beginDate":beginDate,"endDate":endDate,"rows":pageSize,'pageNumber':pageNumber};
        $.ajax({
            url: "/manager/medical/search",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(searchParamsWithTime),
            async: true,
            success: function(data) {
                alert("重新加载数据");
                //获取分页控件
                $("#medicalList").datagrid('getPager').pagination({
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
                $('#medicalList').datagrid('loadData',data);

                alert("加载完毕");
            }
        });
    }

</script>


