/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-03-21 07:27:37 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class item_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<div id=\"search\" style=\"padding:3px\">\r\n");
      out.write("    <select id=\"search_condition\">\r\n");
      out.write("        <option value=\"id\">物品ID</option>\r\n");
      out.write("        <option value=\"title\">物品名称</option>\r\n");
      out.write("        <option value=\"cid\">类别</option>\r\n");
      out.write("        <option value=\"supplier\">供应商</option>\r\n");
      out.write("        <option value=\"barcode\">条形码</option>\r\n");
      out.write("        <option value=\"status\">状态</option>\r\n");
      out.write("    </select>\r\n");
      out.write("    <input id=\"search_key\" style=\"line-height:26px;border:1px solid #ccc\">\r\n");
      out.write("    <a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" onclick=\"doSearch()\">搜索</a>\r\n");
      out.write("</div>\r\n");
      out.write("<table class=\"easyui-datagrid\" id=\"itemList\" title=\"商品列表\"\r\n");
      out.write("       data-options=\"singleSelect:false,collapsible:true,pagination:true,url:'/item/list',method:'get',pageSize:30,toolbar:toolbar\">\r\n");
      out.write("    <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th data-options=\"field:'ck',checkbox:true\"></th>\r\n");
      out.write("        <th data-options=\"field:'id',width:60\">物品ID</th>\r\n");
      out.write("        <th data-options=\"field:'title',width:200\">物品名称</th>\r\n");
      out.write("        <th data-options=\"field:'cid',width:100\">类别</th>\r\n");
      out.write("        <th data-options=\"field:'supplier',width:100\">供应商</th>\r\n");
      out.write("        <th data-options=\"field:'price',width:70,align:'right',formatter:TAOTAO.formatPrice\">价格</th>\r\n");
      out.write("        <th data-options=\"field:'num',width:70,align:'right'\">库存数量</th>\r\n");
      out.write("        <th data-options=\"field:'barcode',width:100\">条形码</th>\r\n");
      out.write("        <th data-options=\"field:'image',width:100\">图片</th>\r\n");
      out.write("        <th data-options=\"field:'status',width:60,align:'center',formatter:TAOTAO.formatItemStatus\">状态</th>\r\n");
      out.write("        <th data-options=\"field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime\">创建日期</th>\r\n");
      out.write("        <th data-options=\"field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime\">更新日期</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("</table>\r\n");
      out.write("<div id=\"itemEditWindow\" class=\"easyui-window\" title=\"编辑商品\" data-options=\"modal:true,closed:true,iconCls:'icon-save',href:'/item-edit'\" style=\"width:80%;height:80%;padding:10px;\">\r\n");
      out.write("</div>\r\n");
      out.write("<div id=\"itemAddWindow\" class=\"easyui-window\" title=\"新增商品\" data-options=\"modal:true,closed:true,iconCls:'icon-save',href:'/item-add'\" style=\"width:80%;height:80%;padding:10px;\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    function getSelectionsIds(){\r\n");
      out.write("        var itemList = $(\"#itemList\");\r\n");
      out.write("        var sels = itemList.datagrid(\"getSelections\");\r\n");
      out.write("        var ids = [];\r\n");
      out.write("        for(var i in sels){\r\n");
      out.write("            ids.push(sels[i].id);\r\n");
      out.write("        }\r\n");
      out.write("        ids = ids.join(\",\");\r\n");
      out.write("        return ids;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    var toolbar = [{\r\n");
      out.write("        text:'编辑',\r\n");
      out.write("        iconCls:'icon-edit',\r\n");
      out.write("        handler:function(){\r\n");
      out.write("            var ids = getSelectionsIds();\r\n");
      out.write("            if(ids.length == 0){\r\n");
      out.write("                $.messager.alert('提示','必须选择一个商品才能编辑!');\r\n");
      out.write("                return ;\r\n");
      out.write("            }\r\n");
      out.write("            if(ids.indexOf(',') > 0){\r\n");
      out.write("                $.messager.alert('提示','只能选择一个商品!');\r\n");
      out.write("                return ;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            $(\"#itemEditWindow\").window({\r\n");
      out.write("                onLoad :function(){\r\n");
      out.write("                    //回显数据\r\n");
      out.write("                    var data = $(\"#itemList\").datagrid(\"getSelections\")[0];\r\n");
      out.write("                    data.priceView = TAOTAO.formatPrice(data.price);\r\n");
      out.write("                    $(\"#itemeEditForm\").form(\"load\",data);\r\n");
      out.write("\r\n");
      out.write("                    TAOTAO.init({\r\n");
      out.write("                        \"pics\" : data.image,\r\n");
      out.write("                        \"cid\" : data.cid,\r\n");
      out.write("                        fun:function(node){\r\n");
      out.write("                            TAOTAO.changeItemParam(node, \"itemeEditForm\");\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("            }).window(\"open\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    },{\r\n");
      out.write("        text:'删除',\r\n");
      out.write("        iconCls:'icon-cancel',\r\n");
      out.write("        handler:function(){\r\n");
      out.write("            var ids = getSelectionsIds();\r\n");
      out.write("            if(ids.length == 0){\r\n");
      out.write("                $.messager.alert('提示','未选中商品!');\r\n");
      out.write("                return ;\r\n");
      out.write("            }\r\n");
      out.write("            $.messager.confirm('确认','确定删除ID为 '+ids+' 的商品吗？',function(r){\r\n");
      out.write("                if (r){\r\n");
      out.write("                    var params = {\"ids\":ids};\r\n");
      out.write("                    $.ajax({\r\n");
      out.write("                        url: \"/item/delete\",\r\n");
      out.write("                        type: \"POST\",\r\n");
      out.write("                        contentType: \"application/json\",\r\n");
      out.write("                        dataType: \"json\",\r\n");
      out.write("                        data: JSON.stringify(params),\r\n");
      out.write("                        async: true,\r\n");
      out.write("                        success: function(data) {\r\n");
      out.write("                            $.messager.alert('提示','删除商品成功!',undefined,function(){\r\n");
      out.write("                                $(\"#itemList\").datagrid(\"reload\");\r\n");
      out.write("                            });\r\n");
      out.write("                        }\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    }];\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("    function doSearch(){\r\n");
      out.write("        var search_condition =document.getElementById(\"search_condition\").value;\r\n");
      out.write("        var search_key =document.getElementById(\"search_key\").value;\r\n");
      out.write("        var search_params = {\"search_condition\":search_condition,\"search_key\":search_key};\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            url: \"/item/search\",\r\n");
      out.write("            type: \"POST\",\r\n");
      out.write("            contentType: \"application/json\",\r\n");
      out.write("            dataType: \"json\",\r\n");
      out.write("            data: JSON.stringify(search_params),\r\n");
      out.write("            async: true,\r\n");
      out.write("            success: function(data) {\r\n");
      out.write("               $('#itemList').datagrid('loadData',data);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
