<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/31 0031
  Time: 下午 2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="/css/taotao.css" />
<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        $(function(){
            $("#contentCategory").tree({
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
                    alert(node.id);
                    alert(node.attributes['url']);  // alert node text property when clicked
                    window.location.href = node.attributes['url'];
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
</head>
<body>
<div>
    <ul id="contentCategory" class="easyui-tree">
    </ul>
</div>
</body>
</html>
