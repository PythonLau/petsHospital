<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>coco医院后台管理系统</title>
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
<body class="easyui-layout">
<div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
    <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">

    </ul>
</div>
<div data-options="region:'center',title:''">
    <div id="tabs" class="easyui-tabs">
        <div title="首页" style="padding:20px;">

        </div>
    </div>
</div>

<script type="text/javascript">
    $(function(){
        $("#menu").tree({
            url : '/test/list',
            animate: true,
            method : "GET",
            onContextMenu: function(e,node){
                e.preventDefault();
                $(this).tree('select',node.target);
                $('#contentCategoryMenu').menu('show',{
                    left: e.pageX,
                    top: e.pageY
                });
            },
            onClick: function(node){
                if($('#menu').tree("isLeaf",node.target)){
                    var tabs = $("#tabs");
                    var tab = tabs.tabs("getTab",node.text);
                    if(tab){
                        tabs.tabs("select",node.text);
                    }else{
                        tabs.tabs('add',{
                            title:node.text,
                            href: node.attributes.url,
                            closable:true,
                            bodyCls:"content"
                        });
                    }
                }
            },
            onAfterEdit : function(node){
                var _tree = $(this);
                if(node.id == 0){
                    // 新增节点
                    $.post("/content/category/create",{parentId:node.parentId,name:node.text},function(data){
                        if(data.status == 200){
                            _tree.tree("update",{
                                target : node.target,
                                id : data.data.id
                            });
                        }else{
                            $.messager.alert('提示','创建'+node.text+' 分类失败!');
                        }
                    });
                }else{
                    $.post("/content/category/update",{id:node.id,name:node.text});
                }
            }
        });
    });
</script>
</body>
</html>