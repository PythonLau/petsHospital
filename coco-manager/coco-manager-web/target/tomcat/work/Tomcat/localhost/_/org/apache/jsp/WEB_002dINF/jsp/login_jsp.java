/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-04-10 11:59:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("\t<title>coco用户登录</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/css/common.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/css/card.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/css/error-box.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/css/btn.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/css/userLogin.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"/css/input.css\"/>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"iconfont/material-icons.css\"/>\r\n");
      out.write("\t<script src=\"/js/jquery-2.1.3.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"/js/login.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"/js/error-box.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<h1 class=\"text-center\">coco用户登录</h1>\r\n");
      out.write("\t<form id=\"userLoginForm\" action=\"/userLogin/loginConfirm\" method=\"post\">\r\n");
      out.write("\t\t<div class=\"login\">\r\n");
      out.write("\t\t\t<div class=\"card\">\r\n");
      out.write("\t\t\t\t<span style=\"color:green\">\r\n");
      out.write("\t\t\t\t\t\t");

							Object registerSuccessMessage = request.getAttribute("registerSuccess");
							if(registerSuccessMessage != null){
								out.println(registerSuccessMessage.toString());
							}
						
      out.write("\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t<div class=\"input-field\">\r\n");
      out.write("\t\t\t\t\t<label for=\"username\">用户名</label>\r\n");
      out.write("\t\t\t\t\t<input id=\"username\" name=\"username\" type=\"text\"/>\r\n");
      out.write("\t\t\t\t\t<label for=\"password\">密码</label>\r\n");
      out.write("\t\t\t\t\t<input id=\"password\" name=\"password\" type=\"password\"/>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<button type=\"submit\" id=\"btn-login\" class=\"btn\" style=\"width: 100%;\">登&nbsp;录</button>\r\n");
      out.write("\t\t\t\t<div class=\"foot\">\r\n");
      out.write("\t\t\t\t\t<span style=\"color:red\">\r\n");
      out.write("\t\t\t\t\t\t");

							Object wrongMessage = request.getAttribute("wrong");
							if(wrongMessage != null){
								out.println(wrongMessage.toString());
							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t<a href=\"/register\" style=\"float:right;\">没有帐户？</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
