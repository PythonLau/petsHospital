/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-03-28 08:27:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class foster_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>新增宠物</title>\r\n");
      out.write("    <link rel='stylesheet' href='/css/common.css'>\r\n");
      out.write("    <link rel='stylesheet' href='/css/signup.css'>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/input.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/btn.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/card.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/error-box.css\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/material-icons.css\"/>\r\n");
      out.write("    <link href=\"/js/kindeditor-4.1.10/themes/default/default.css\" type=\"text/css\" rel=\"stylesheet\">l\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/js/jquery-easyui-1.4.1/themes/default/easyui.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/js/jquery-easyui-1.4.1/themes/icon.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/taotao.css\" />\r\n");
      out.write("    <script src=\"/js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" charset=\"utf-8\" src=\"/js/kindeditor-4.1.10/kindeditor-all-min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/js/jquery-easyui-1.4.1/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/js/jquery-easyui-1.4.1/jquery.easyui.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"/js/common.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <h1 class=\"text-center\">寄养宠物</h1>\r\n");
      out.write("    <form id=\"addPetForm\" action=\"/user/foster\" method=\"post\">\r\n");
      out.write("        <div class=\"signup\">\r\n");
      out.write("            <div class=\"card\">\r\n");
      out.write("                <span style=\"color:red\">\r\n");
      out.write("\t\t\t\t\t\t");

                            Object name = request.getAttribute("addPetFail");
                            if(name != null){
                                out.println(name.toString());
                            }
                        
      out.write("\r\n");
      out.write("                </span>\r\n");
      out.write("                <div class=\"input-field\">\r\n");
      out.write("                    <input type=\"hidden\" id=\"id\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pet.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("                    <label>宠物名字</label>\r\n");
      out.write("                    <input id=\"name\" name=\"name\" type=\"text\" readonly=\"true\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pet.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\r\n");
      out.write("                    <label>寄养地址</label>\r\n");
      out.write("                    <input id=\"address\" name=\"address\" type=\"text\"/>\r\n");
      out.write("\r\n");
      out.write("                    <label>联系电话</label>\r\n");
      out.write("                    <input id=\"telePhone\" name=\"telePhone\" type=\"text\" />\r\n");
      out.write("                </div>\r\n");
      out.write("                <button type=\"submit\" id=\"signup-button\" style=\"width: 100%;\" class=\"btn\">寄&nbsp;养</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("<script>\r\n");
      out.write("    $(document).ready(function(){\r\n");
      out.write("        TAOTAO.init();\r\n");
      out.write("    })\r\n");
      out.write("</script>\r\n");
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
