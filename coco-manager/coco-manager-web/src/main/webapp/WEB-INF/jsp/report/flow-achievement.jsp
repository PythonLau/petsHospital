<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="search" style="padding:3px">
    开始时间<input type="date" id="beginDate" name="beginDate">
    结束时间<input type="date" id="endDate" name="endDate">
    <a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch('1','10')">搜索</a>
    <a href="#" class="easyui-linkbutton" style="width:12%" id="btnExport">导出</a>
</div>
<table class="easyui-datagrid" id="medicalList" title="病历列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/report/flowAndAchievement',method:'get',pageSize:10,toolbar:toolbar,onLoadSuccess:compute">
    <thead>
    <tr>
        <th data-options="field:'serverdate',width:100">日期</th>
        <th data-options="field:'pv',width:38">PV</th>
        <th data-options="field:'uv',width:38">UV</th>
        <th data-options="field:'statusonemedical',width:110">待处理（挂号）</th>
        <th data-options="field:'statustwomedical',width:110">已处理（挂号）</th>
        <th data-options="field:'statusthreemedical',width:110">已支付（挂号）</th>
        <th data-options="field:'statuszeromedical',width:110">已取消（挂号）</th>
        <th data-options="field:'statusonepackage',width:110">待处理（套餐）</th>
        <th data-options="field:'statustwopackage',width:110">已服务（套餐）</th>
        <th data-options="field:'statuszeropackage',width:110">已取消（套餐）</th>
        <th data-options="field:'revenueofmedical',width:110">业绩（医疗）</th>
        <th data-options="field:'revenueofpackage',width:110">业绩（套餐）</th>
    </tr>
    </thead>
</table>
<div id="prescribeWindow" class="easyui-window" title="处理该病历信息" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/manager/medical-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>
    function JSONToCSVConvertor(JSONData, ReportTitle, ShowLabel) {
        var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData)
            : JSONData;
        var CSV = '';
        CSV += ReportTitle + '\r\n\n';
        if (ShowLabel) {
            var row = "";
            for (var index in arrData[0]) {
                alert(index);
                if(index == 'statusonemedical'){
                    index = '待处理挂号';
                }
                row += index + ',';
            }
            row = row.slice(0, -1);
            CSV += row + '\r\n';
        }
        for (var i = 0; i < arrData.length; i++) {
            var row = "";
            for ( var index in arrData[i]) {
                row += '"' + arrData[i][index] + '",';
            }
            row.slice(0, row.length - 1);
            CSV += row + '\r\n';
        }
        if (CSV == '') {
            alert("表格数据为空");
            return;
        }
        var fileName = ReportTitle.replace(/ /g, "_");
        var uri = "data:text/csv;charset=utf-8,\ufeff" + encodeURIComponent(CSV);
        var link = document.createElement("a");
        link.href = uri;
        link.style = "visibility:hidden";
        link.download = fileName + ".csv";
        document.body.appendChild(link);
        link.click();
        document.body.removeChild(link);
    }
    $("#btnExport").click(function() {
        var data = JSON.stringify($('#medicalList').datagrid('getData').rows);
        alert(data);
        if (data == ''){
            alert('表格值为空');
            return;
        }
        JSONToCSVConvertor(data, "流量与业绩报表", true);
    });
</script>
<script>
    function compute() {//计算函数
        var rows = $('#medicalList').datagrid('getRows')//获取当前的数据行
        var PVTotal = 0//计算listprice的总和
            ,UVTotal=0//统计unitcost的总和
            ,statusonemedicalTotal=0
            ,statustwomedicalTotal=0
            ,statusthreemedicalTotal=0
            ,statuszeromedicalTotal=0
            ,statusonepackageTotal=0
            ,statustwopackageTotal=0
            ,statuszeropackageTotal=0
            ,revenueofmedicalTotal=0
            ,revenueofpackageTotal=0;
        for (var i = 0; i < rows.length; i++) {
            PVTotal += rows[i]['pv'];
            UVTotal += rows[i]['uv'];
            statusonemedicalTotal += rows[i]['statusonemedical'];
            statustwomedicalTotal += rows[i]['statustwomedical'];
            statusthreemedicalTotal += rows[i]['statusthreemedical'];
            statuszeromedicalTotal += rows[i]['statuszeromedical'];
            statusonepackageTotal += rows[i]['statusonepackage'];
            statustwopackageTotal += rows[i]['statustwopackage'];
            statuszeropackageTotal += rows[i]['statuszeropackage'];
            revenueofmedicalTotal += rows[i]['revenueofmedical'];
            revenueofpackageTotal += rows[i]['revenueofpackage'];
        }
        //新增一行显示统计信息
        $('#medicalList').datagrid('appendRow',
            {
                pv: PVTotal,
                uv: UVTotal,
                statusonemedical : statusonemedicalTotal,
                statustwomedical : statustwomedicalTotal,
                statusthreemedical : statusthreemedicalTotal,
                statuszeromedical : statuszeromedicalTotal,
                statusonepackage : statusonepackageTotal,
                statustwopackage : statustwopackageTotal,
                statuszeropackage : statuszeropackageTotal,
                revenueofmedical : revenueofmedicalTotal,
                revenueofpackage : revenueofpackageTotal});
    }
</script>

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
        text:'处理该病历',
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

            $("#prescribeWindow").window({
                onLoad :function(){
                    //回显数据
                    var data = $("#medicalList").datagrid("getSelections")[0];
                    $("#MedicalEditForm").form("load",data);

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


