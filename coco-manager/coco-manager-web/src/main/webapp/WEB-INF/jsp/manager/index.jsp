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
			<li>
				<span>房间管理</span>
				<ul>
					<li data-options="attributes:{'url':'bed-tree'}">床位架构</li>
					<li data-options="attributes:{'url':'room-tree'}">手术室架构</li>
					<li data-options="attributes:{'url':'bed-list'}">床位情况</li>
					<li data-options="attributes:{'url':'room-list'}">手术室情况</li>
				</ul>
			</li>
         	<li>
         		<span>库存管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'item-add'}">新增物品</li>
	         		<li data-options="attributes:{'url':'item-list'}">物品管理</li>
					<li data-options="attributes:{'url':'item-cat'}">分类管理</li>
	         	</ul>
         	</li>
			<li>
				<span>人事管理</span>
				<ul>
					<li data-options="attributes:{'url':'employee-add'}">新增员工</li>
					<li data-options="attributes:{'url':'employee-list'}">员工管理</li>
					<li data-options="attributes:{'url':'employee-cat'}">部门管理</li>
				</ul>
			</li>
			<li>
				<span>账户管理</span>
				<ul>
					<li data-options="attributes:{'url':'account-list'}">普通账户</li>
					<li data-options="attributes:{'url':'doctorAccount-list'}">医生账户</li>
					<li data-options="attributes:{'url':'reportAccount-list'}">报表账户</li>
				</ul>
			</li>
			<li>
				<span>套餐管理</span>
				<ul>
					<li data-options="attributes:{'url':'package-add'}">新增套餐</li>
					<li data-options="attributes:{'url':'package-list'}">套餐管理</li>
				</ul>
			</li>
			<li>
				<span>订单管理</span>
				<ul>
					<li data-options="attributes:{'url':'medical-list'}">挂号管理</li>
					<li data-options="attributes:{'url':'order-list'}">订单管理</li>
				</ul>
			</li>
         	<li>
         		<span>网站内容管理</span>
         		<ul>
					<li data-options="attributes:{'url':'content-add'}">发表文章</li>
	         		<li data-options="attributes:{'url':'content'}">内容管理</li>
	         	</ul>
         	</li>
			<li>
				<span>报表中心</span>
				<ul>
					<li data-options="attributes:{'url':'module-add'}">新增报表</li>
					<li data-options="attributes:{'url':'module-list'}">报表管理</li>
					<li data-options="attributes:{'url':'authority-add'}">新增权限</li>
					<li data-options="attributes:{'url':'authority-list'}">权限管理</li>
				</ul>
			</li>
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
	$('#menu').tree({
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
		}
	});
});
</script>
</body>
</html>