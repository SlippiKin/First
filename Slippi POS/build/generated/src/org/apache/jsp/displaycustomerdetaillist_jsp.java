package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;

public final class displaycustomerdetaillist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Display Debtor </title>\n");
      out.write("          <style>\n");
      out.write("            .center{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            table a:link {\n");
      out.write("                color: #666;\n");
      out.write("                font-weight: bold;\n");
      out.write("                text-decoration:none;\n");
      out.write("            }\n");
      out.write("            table a:visited {\n");
      out.write("                color: #999999;\n");
      out.write("                font-weight:bold;\n");
      out.write("                text-decoration:none;\n");
      out.write("            }\n");
      out.write("            table a:active,\n");
      out.write("            table a:hover {\n");
      out.write("                color: #bd5a35;\n");
      out.write("                text-decoration:underline;\n");
      out.write("            }\n");
      out.write("            table {\n");
      out.write("                font-family:Arial, Helvetica, sans-serif;\n");
      out.write("                color:#666;\n");
      out.write("                font-size:12px;\n");
      out.write("                text-shadow: 1px 1px 0px #fff;\n");
      out.write("                background:#eaebec;\n");
      out.write("                margin:20px;\n");
      out.write("                border:#ccc 1px solid;\n");
      out.write("\n");
      out.write("                -moz-border-radius:3px;\n");
      out.write("                -webkit-border-radius:3px;\n");
      out.write("                border-radius:3px;\n");
      out.write("\n");
      out.write("                -moz-box-shadow: 0 1px 2px #d1d1d1;\n");
      out.write("                -webkit-box-shadow: 0 1px 2px #d1d1d1;\n");
      out.write("                box-shadow: 0 1px 2px #d1d1d1;\n");
      out.write("            }\n");
      out.write("            table th {\n");
      out.write("                padding:21px 25px 22px 25px;\n");
      out.write("                border-top:1px solid #fafafa;\n");
      out.write("                border-bottom:1px solid #e0e0e0;\n");
      out.write("\n");
      out.write("                background: #ededed;\n");
      out.write("                background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#ebebeb));\n");
      out.write("                background: -moz-linear-gradient(top,  #ededed,  #ebebeb);\n");
      out.write("            }\n");
      out.write("            table th{\n");
      out.write("                text-align: center;\n");
      out.write("                padding-left:20px;\n");
      out.write("            }\n");
      out.write("            table tr{\n");
      out.write("                -moz-border-radius-topleft:3px;\n");
      out.write("                -webkit-border-top-left-radius:3px;\n");
      out.write("                border-top-left-radius:3px;\n");
      out.write("            }\n");
      out.write("            table tr:first-child th:last-child {\n");
      out.write("                -moz-border-radius-topright:3px;\n");
      out.write("                -webkit-border-top-right-radius:3px;\n");
      out.write("                border-top-right-radius:3px;\n");
      out.write("            }\n");
      out.write("            table tr {\n");
      out.write("                text-align: center;\n");
      out.write("                padding-left:20px;\n");
      out.write("            }\n");
      out.write("            table td{\n");
      out.write("                text-align: center;\n");
      out.write("                padding-left:20px;\n");
      out.write("                border-left: 0;\n");
      out.write("            }\n");
      out.write("            table td {\n");
      out.write("                padding:18px;\n");
      out.write("                border-top: 1px solid #ffffff;\n");
      out.write("                border-bottom:1px solid #e0e0e0;\n");
      out.write("                border-left: 1px solid #e0e0e0;\n");
      out.write("\n");
      out.write("                background: #fafafa;\n");
      out.write("                background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));\n");
      out.write("                background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);\n");
      out.write("            }\n");
      out.write("            table tr.even td {\n");
      out.write("                background: #f6f6f6;\n");
      out.write("                background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));\n");
      out.write("                background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);\n");
      out.write("            }\n");
      out.write("            table tr:last-child td {\n");
      out.write("                border-bottom:0;\n");
      out.write("            }\n");
      out.write("            table tr:last-child td:first-child {\n");
      out.write("                -moz-border-radius-bottomleft:3px;\n");
      out.write("                -webkit-border-bottom-left-radius:3px;\n");
      out.write("                border-bottom-left-radius:3px;\n");
      out.write("            }\n");
      out.write("            table tr:last-child td:last-child {\n");
      out.write("                -moz-border-radius-bottomright:3px;\n");
      out.write("                -webkit-border-bottom-right-radius:3px;\n");
      out.write("                border-bottom-right-radius:3px;\n");
      out.write("            }\n");
      out.write("            table tr:hover td {\n");
      out.write("                background: #f2f2f2;\n");
      out.write("                background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));\n");
      out.write("                background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);\t\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            //tab function\n");
      out.write("            function openCity(evt, cityName) {\n");
      out.write("                var i, tabcontent, tablinks;\n");
      out.write("                tabcontent = document.getElementsByClassName(\"tabcontent\");\n");
      out.write("                for (i = 0; i < tabcontent.length; i++) {\n");
      out.write("                    tabcontent[i].style.display = \"none\";\n");
      out.write("                }\n");
      out.write("                tablinks = document.getElementsByClassName(\"tablinks\");\n");
      out.write("                for (i = 0; i < tablinks.length; i++) {\n");
      out.write("                    tablinks[i].className = tablinks[i].className.replace(\" active\", \"\");\n");
      out.write("                }\n");
      out.write("                document.getElementById(cityName).style.display = \"block\";\n");
      out.write("                evt.currentTarget.className += \" active\";\n");
      out.write("            }\n");
      out.write("            //data table\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#salesDetail').DataTable();\n");
      out.write("            });\n");
      out.write("            //data table\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#weeksalesDetail').DataTable();\n");
      out.write("            });\n");
      out.write("            //data table\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#monthsalesDetail').DataTable();\n");
      out.write("            });\n");
      out.write("            //data table\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#yearsalesDetail').DataTable();\n");
      out.write("            });\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         <nav class=\"navbar navbar-inverse \">\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                \n");
      out.write("            </ul>\n");
      out.write("        </nav>   \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
