<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
    <ul id="itemCat" class="easyui-tree">
    </ul>
</div>
<div id="itemCatMenu" class="easyui-menu" style="width:120px;" data-options="onClick:menuHandler">
    <div data-options="iconCls:'icon-add',name:'add'">添加</div>
    <div data-options="iconCls:'icon-remove',name:'rename'">重命名</div>
    <div class="menu-sep"></div>
    <div data-options="iconCls:'icon-remove',name:'delete'">删除</div>
</div>
<script type="text/javascript">
    $(function(){
        $("#itemCat").tree({
            url : '/manager/bed/tree',
            animate: true,
            method : "GET",
            onContextMenu: function(e,node){
                e.preventDefault();
                $(this).tree('select',node.target);
                $('#itemCatMenu').menu('show',{
                    left: e.pageX,
                    top: e.pageY
                });
            },
            onAfterEdit : function(node){
                var _tree = $(this);
                if(node.id == 0){
                    // 新增节点
                    $.post("/manager/bed/create",{parentId:node.parentId,name:node.text},function(data){
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
                    $.post("/manager/bed/update",{id:node.id,name:node.text});
                }
            }
        });
    });
    function menuHandler(item){
        var tree = $("#itemCat");
        var node = tree.tree("getSelected");
        if(item.name === "add"){
            tree.tree('append', {
                parent: (node?node.target:null),
                data: [{
                    text: '新建分类',
                    id : 0,
                    parentId : node.id
                }]
            });
            var _node = tree.tree('find',0);
            tree.tree("select",_node.target).tree('beginEdit',_node.target);
        }else if(item.name === "rename"){
            tree.tree('beginEdit',node.target);
        }else if(item.name === "delete"){
            $.messager.confirm('确认','确定删除名为 '+node.text+' 的分类吗？',function(r){
                if(r){
                    $.post("/manager/bed/delete",{id:node.id},function(data){
                        if(data.status == 200){
                            tree.tree("remove",node.target);
                            $.messager.alert('提示',data.msg);
                        }else if(data.status == 500){
                            $.messager.alert('提示',data.msg);
                        }
                    });
                }
            });
        }
    }
</script>