/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-05-14 14:04:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.manager;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class room_002dlist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <option value=\"id\">用户Id</option>\r\n");
      out.write("        <option value=\"loginname\">登录名</option>\r\n");
      out.write("        <option value=\"nickname\">昵称</option>\r\n");
      out.write("        <option value=\"status\">状态</option>\r\n");
      out.write("    </select>\r\n");
      out.write("    <input id=\"search_key\" style=\"line-height:26px;border:1px solid #ccc\">\r\n");
      out.write("    <a href=\"#\" class=\"easyui-linkbutton\" plain=\"true\" onclick=\"doSearch('1','10')\">搜索</a>\r\n");
      out.write("</div>\r\n");
      out.write("<table class=\"easyui-datagrid\" id=\"accountList\" title=\"床位列表\"\r\n");
      out.write("       data-options=\"singleSelect:false,collapsible:true,pagination:true,url:'/manager/room/list',method:'get',pageSize:10,toolbar:toolbar\">\r\n");
      out.write("    <thead>\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th data-options=\"field:'ck',checkbox:true\"></th>\r\n");
      out.write("        <th data-options=\"field:'id',width:138\">床位id</th>\r\n");
      out.write("        <th data-options=\"field:'name',width:138\">床位名称</th>\r\n");
      out.write("        <th data-options=\"field:'status',width:88,formatter:TAOTAO.formatBedStatus\">状态</th>\r\n");
      out.write("        <th data-options=\"field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime\">创建日期</th>\r\n");
      out.write("        <th data-options=\"field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime\">更新日期</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </thead>\r\n");
      out.write("</table>\r\n");
      out.write("<div id=\"accountWindow\" class=\"easyui-window\" title=\"设置级别\" data-options=\"modal:true,closed:true,iconCls:'icon-save',href:'/manager/account-edit'\" style=\"width:80%;height:80%;padding:10px;\">\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("    function getSelectionsIds(){\r\n");
      out.write("        var accountList = $(\"#accountList\");\r\n");
      out.write("        var sels = accountList.datagrid(\"getSelections\");\r\n");
      out.write("        var ids = [];\r\n");
      out.write("        for(var i in sels){\r\n");
      out.write("            ids.push(sels[i].id);\r\n");
      out.write("        }\r\n");
      out.write("        ids = ids.join(\",\");\r\n");
      out.write("        return ids;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    var toolbar = [{\r\n");
      out.write("        text:'设定级别',\r\n");
      out.write("        iconCls:'icon-edit',\r\n");
      out.write("        handler:function(){\r\n");
      out.write("            var ids = getSelectionsIds();\r\n");
      out.write("            if(ids.length == 0){\r\n");
      out.write("                $.messager.alert('提示','必须选择一个病历才能处理!');\r\n");
      out.write("                return ;\r\n");
      out.write("            }\r\n");
      out.write("            if(ids.indexOf(',') > 0){\r\n");
      out.write("                $.messager.alert('提示','只能选择一个病历!');\r\n");
      out.write("                return ;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            $(\"#accountWindow\").window({\r\n");
      out.write("                onLoad :function(){\r\n");
      out.write("                    //回显数据\r\n");
      out.write("                    var data = $(\"#accountList\").datagrid(\"getSelections\")[0];\r\n");
      out.write("                    $(\"#accountEditForm\").form(\"load\",data);\r\n");
      out.write("\r\n");
      out.write("                    TAOTAO.init({\r\n");
      out.write("                        \"pics\" : data.image,\r\n");
      out.write("                        \"cid\" : data.cid,\r\n");
      out.write("                    });\r\n");
      out.write("                }\r\n");
      out.write("            }).window(\"open\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    },{\r\n");
      out.write("        text:'测试',\r\n");
      out.write("        iconCls:'icon-edit',\r\n");
      out.write("        handler:function(){\r\n");
      out.write("            var ids = getSelectionsIds();\r\n");
      out.write("            if(ids.length == 0){\r\n");
      out.write("                $.messager.alert('提示','必须选择一个病历才能处理!');\r\n");
      out.write("                return ;\r\n");
      out.write("            }\r\n");
      out.write("            if(ids.indexOf(',') > 0){\r\n");
      out.write("                $.messager.alert('提示','只能选择一个病历!');\r\n");
      out.write("                return ;\r\n");
      out.write("            }\r\n");
      out.write("            alert(ids);\r\n");
      out.write("            window.location.href = '/test/' + ids;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("    }];\r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("    function doSearch(pageNumber, pageSize){\r\n");
      out.write("        var search_condition =document.getElementById(\"search_condition\").value;\r\n");
      out.write("        var search_key =document.getElementById(\"search_key\").value;\r\n");
      out.write("        //获取分页大小\r\n");
      out.write("        var rows = $(\".pagination-page-list\").val()\r\n");
      out.write("        //页面分页大小与参数是否一样\r\n");
      out.write("        if(rows != pageSize){\r\n");
      out.write("            pageSize = rows ;\r\n");
      out.write("        }\r\n");
      out.write("        var searchParams = {\"search_condition\":search_condition,\"search_key\":search_key,\"rows\":pageSize,'pageNumber':pageNumber};\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            url: \"/manager/account/search\",\r\n");
      out.write("            type: \"POST\",\r\n");
      out.write("            contentType: \"application/json\",\r\n");
      out.write("            dataType: \"json\",\r\n");
      out.write("            data: JSON.stringify(searchParams),\r\n");
      out.write("            async: true,\r\n");
      out.write("            success: function(data) {\r\n");
      out.write("                alert(\"重新加载数据\");\r\n");
      out.write("                //获取分页控件\r\n");
      out.write("                $(\"#accountList\").datagrid('getPager').pagination({\r\n");
      out.write("                    //重新load分页控件\r\n");
      out.write("                    //自带属性\r\n");
      out.write("                    //原来右边这个是1\r\n");
      out.write("                    pageNumber:pageNumber,\r\n");
      out.write("                    pageSize:pageSize,\r\n");
      out.write("                    //分页触发事件\r\n");
      out.write("                    //参数是上面左边紫色自带控件属性传进来的\r\n");
      out.write("                    //按上一页或者下一页就会触发这个事件\r\n");
      out.write("                    //点击下一页或者上一页pageNumber就会变成2\r\n");
      out.write("                    onSelectPage: function(pageNumber, pageSize){\r\n");
      out.write("                        //点击一下还是执行search方法\r\n");
      out.write("                        alert(\"还是执行search方法\")\r\n");
      out.write("                        doSearch(pageNumber, pageSize);\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("                $('#accountList').datagrid('loadData',data);\r\n");
      out.write("\r\n");
      out.write("                alert(\"加载完毕\");\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
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
