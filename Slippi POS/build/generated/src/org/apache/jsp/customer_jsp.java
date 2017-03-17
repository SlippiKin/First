package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;

public final class customer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_query_var_dataSource;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_query_var_dataSource = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_sql_query_var_dataSource.release();
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.release();
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Customer</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css\">\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.12.3.js\"></script>\n");
      out.write("        <script src=\"https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js\"></script>\n");
      out.write("        <link href=\"css/inventorystyle.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
      out.write("            .cont1 {\n");
      out.write("                height: 550px;\n");
      out.write("                width : 80%;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                background-color: white;\n");
      out.write("                border-color: black;\n");
      out.write("                margin: auto;\n");
      out.write("                padding: 10px;\n");
      out.write("\n");
      out.write("            }\n");
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
      out.write("            //data table\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#customertable').DataTable();\n");
      out.write("            });\n");
      out.write("\n");
      out.write("            function get(str)\n");
      out.write("            {\n");
      out.write("                var xmlhttp = new XMLHttpRequest();\n");
      out.write("                xmlhttp.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                    {\n");
      out.write("                        var responseArray = xmlhttp.responseText.split(\",\");\n");
      out.write("                        var ph = responseArray[0];\n");
      out.write("                        var email = responseArray[1];\n");
      out.write("                        var total = responseArray[2];\n");
      out.write("\n");
      out.write("                        document.getElementById(\"ph\").value = ph;\n");
      out.write("                        document.getElementById(\"email\").value = email;\n");
      out.write("                        document.getElementById(\"total\").value = total;\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                xmlhttp.open(\"GET\", \"searchForCustomer?custname=\" + str, true);\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("            function onInput() {\n");
      out.write("                var val = document.getElementById(\"list1\").value;\n");
      out.write("                var opts = document.getElementById('text').childNodes;\n");
      out.write("\n");
      out.write("                for (var i = 0; i < opts.length; i++) {\n");
      out.write("                    if (opts[i].value === val) {\n");
      out.write("                        get(val);\n");
      out.write("                        break;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function gettransid(str)\n");
      out.write("            {\n");
      out.write("                var xmlhttp = new XMLHttpRequest();\n");
      out.write("                xmlhttp.onreadystatechange = function ()\n");
      out.write("                {\n");
      out.write("                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200)\n");
      out.write("                    {\n");
      out.write("\n");
      out.write("                        var responseArray = xmlhttp.responseText.split(\",\");\n");
      out.write("                        var total = responseArray[0];\n");
      out.write("                        document.getElementById(\"bill\").value = total;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                xmlhttp.open(\"GET\", \"searchForTransid?transid=\" + str, true);\n");
      out.write("                xmlhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function onInput1() {\n");
      out.write("                var val = document.getElementById(\"transdetailid\").value;\n");
      out.write("                var opts = document.getElementById('transid').childNodes;\n");
      out.write("\n");
      out.write("                for (var i = 0; i < opts.length; i++) {\n");
      out.write("                    if (opts[i].value === val) {\n");
      out.write("                        gettransid(val);\n");
      out.write("                        break;\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      if (_jspx_meth_sql_setDataSource_0(_jspx_page_context))
        return;
      out.write("       \n");
      out.write("        ");
      //  sql:query
      org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_0 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var_dataSource.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
      _jspx_th_sql_query_0.setPageContext(_jspx_page_context);
      _jspx_th_sql_query_0.setParent(null);
      _jspx_th_sql_query_0.setDataSource((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${snapshot}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_sql_query_0.setVar("allCustomer");
      int[] _jspx_push_body_count_sql_query_0 = new int[] { 0 };
      try {
        int _jspx_eval_sql_query_0 = _jspx_th_sql_query_0.doStartTag();
        if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_push_body_count_sql_query_0[0]++;
            _jspx_th_sql_query_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_sql_query_0.doInitBody();
          }
          do {
            out.write("\n");
            out.write("            SELECT * from customer where id = '");
            out.print( session.getAttribute("username"));
            out.write("';\n");
            out.write("        ");
            int evalDoAfterBody = _jspx_th_sql_query_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
            _jspx_push_body_count_sql_query_0[0]--;
        }
        if (_jspx_th_sql_query_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_sql_query_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_sql_query_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_sql_query_0.doFinally();
        _jspx_tagPool_sql_query_var_dataSource.reuse(_jspx_th_sql_query_0);
      }
      out.write(" \n");
      out.write("        ");
      //  sql:query
      org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_1 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var_dataSource.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
      _jspx_th_sql_query_1.setPageContext(_jspx_page_context);
      _jspx_th_sql_query_1.setParent(null);
      _jspx_th_sql_query_1.setDataSource((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${snapshot}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_sql_query_1.setVar("allTrans");
      int[] _jspx_push_body_count_sql_query_1 = new int[] { 0 };
      try {
        int _jspx_eval_sql_query_1 = _jspx_th_sql_query_1.doStartTag();
        if (_jspx_eval_sql_query_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          if (_jspx_eval_sql_query_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
            out = _jspx_page_context.pushBody();
            _jspx_push_body_count_sql_query_1[0]++;
            _jspx_th_sql_query_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
            _jspx_th_sql_query_1.doInitBody();
          }
          do {
            out.write("\n");
            out.write("            SELECT * from transdetail where id = '");
            out.print( session.getAttribute("username"));
            out.write("';\n");
            out.write("        ");
            int evalDoAfterBody = _jspx_th_sql_query_1.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
          if (_jspx_eval_sql_query_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
            out = _jspx_page_context.popBody();
            _jspx_push_body_count_sql_query_1[0]--;
        }
        if (_jspx_th_sql_query_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_sql_query_1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_sql_query_1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_sql_query_1.doFinally();
        _jspx_tagPool_sql_query_var_dataSource.reuse(_jspx_th_sql_query_1);
      }
      out.write("     \n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-inverse \">\n");
      out.write("\n");
      out.write("            <div class=\"navbar-header\">\n");
      out.write("                <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar\" aria-expanded=\"false\" aria-controls=\"navbar\">\n");
      out.write("                    <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                    <span class=\"icon-bar\"></span>\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"navbar\" class=\"navbar-collapse collapse\">\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("                    <li ><a href=\"Home.jsp\" accesskey=\"a\">Sales (A)</a></li>\n");
      out.write("                    <li><a href=\"inventory.jsp\" accesskey=\"i\">Inventory (I)</a></li>\n");
      out.write("                    <li ><a href=\"supplier.jsp\" accesskey=\"s\">Supplier (S)</a></li>\n");
      out.write("                    <li><a href=\"shelf.jsp\" accesskey=\"y\">Shelf (Y)</a></li>\n");
      out.write("                    <li class=\"active\"><a href=\"customer.jsp\" accesskey=\"c\">Customer (C)</a></li>\n");
      out.write("                    <li><a href=\"reportInformation\" accesskey=\"r\">Report (R)</a></li>\n");
      out.write("                    <li><a href=\"history.jsp\" accesskey=\"h\">History (H)</a></li></ul>\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li class=\"active\"><a href=\"index.html\" accesskey=\"l\">Logout (L)<span class=\"sr-only\">(current)</span></a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div><!--/.nav-collapse -->\n");
      out.write("\n");
      out.write("        </nav> \n");
      out.write("        <ul class=\"nav nav-pills\">\n");
      out.write("            <li class=\"active\"><a data-toggle=\"pill\" href=\"#allcustomer\">VIEW ALL CUSTOMER</a></li>\n");
      out.write("            <li><a data-toggle=\"pill\" href=\"#edit\">EDIT CUSTOMER</a></li>    \n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        <div class=\"tab-content\">\n");
      out.write("\n");
      out.write("            <div id=\"allcustomer\" class=\"tab-pane fade in active\">\n");
      out.write("                <h2 class=\"text-center\">DEBTOR</h2>\n");
      out.write("                <form method=\"post\" action=\"displayCustomerDetail\">\n");
      out.write("                    <table id=\"customertable\" class=\"display\" cellspacing=\"0\" width=\"100%\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>CUSTOMER NAME</th>\n");
      out.write("                                <th>PHONE NUMBER</th>\n");
      out.write("                                <th>EMAIL</th>\n");
      out.write("                                <th>TOTAL CREDIT</th> \n");
      out.write("                                <th>VIEW</th> \n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tfoot>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>CUSTOMER NAME</th>\n");
      out.write("                                <th>PHONE NUMBER</th>\n");
      out.write("                                <th>EMAIL</th>\n");
      out.write("                                <th>TOTAL CREDIT</th>\n");
      out.write("                                <th>VIEW</th> \n");
      out.write("                            </tr>\n");
      out.write("                        </tfoot>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write(" \n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <!-- ------------------------------------------------------------------------------------------------------------- -->\n");
      out.write("\n");
      out.write("            <div id=\"edit\" class=\"tab-pane fade white\">\n");
      out.write("\n");
      out.write("                <div class=\"wrap\">\n");
      out.write("                    <div class=\"Regisration\">\n");
      out.write("                        <h2 class=\"text-center\">Edit or Insert Customer</h2>\n");
      out.write("                        <div class=\"cont1\">\n");
      out.write("                            <div class=\"container\">\n");
      out.write("                                <form method=\"Post\" id=\"addCustomer\" name=\"addCustomer\" action=\"searchForCustomer\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <div class=\"col-md-6\">  \n");
      out.write("                                        <p><b>CUSTOMER INFORMATION</b></p>\n");
      out.write("                                        <p>Name :</p> \n");
      out.write("\n");
      out.write("                                        <input list=\"text\" id='list1' oninput='onInput()' name=\"customername\"  required onkeyup=\"get(this.value)\" /> \n");
      out.write("\n");
      out.write("                                        <datalist id=\"text\">\n");
      out.write("                                            ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        </datalist>\n");
      out.write("\n");
      out.write("                                        <p>Phone Number :</p> <input type=\"text\" id=\"ph\" name=\"ph\" required> \n");
      out.write("\n");
      out.write("                                        <p>Email : </p><input type=\"email\" id=\"email\" name=\"email\">          \n");
      out.write("\n");
      out.write("                                        <p>Total :</p> <input type=\"text\" disabled id=\"total\" name=\"total\">                                              \n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-6\">\n");
      out.write("                                        <P><b>TRANSACTION DETAIL</b></P>\n");
      out.write("                                        <P>Transaction Number :</P>\n");
      out.write("                                        <input list=\"transid\" id='transdetailid' oninput='onInput1()' name=\"transdetail\" required onkeyup=\"gettransid(this.value)\" /> \n");
      out.write("                                        <datalist id=\"transid\">\n");
      out.write("                                            ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        </datalist>\n");
      out.write("                                        <p>Total :</p> <input disabled type=\"text\" id=\"bill\" name=\"bill\" >  \n");
      out.write("                                        <p>Remain :</p> <input type=\"number\" step=\"any\" required id=\"remain\" name=\"remain\">  \n");
      out.write("                                        <br>    \n");
      out.write("                                        <input type=\"submit\" style=\"background-color:greenyellow\">\n");
      out.write("                                    </div> \n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <input type=\"hidden\" id=\"id\" name=\"id\" value=\"");
      out.print( session.getAttribute("username"));
      out.write("\"><br/>\n");
      out.write("                                   \n");
      out.write("\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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

  private boolean _jspx_meth_sql_setDataSource_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:setDataSource
    org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag _jspx_th_sql_setDataSource_0 = (org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag) _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.get(org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag.class);
    _jspx_th_sql_setDataSource_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_setDataSource_0.setParent(null);
    _jspx_th_sql_setDataSource_0.setVar("snapshot");
    _jspx_th_sql_setDataSource_0.setDriver("com.mysql.jdbc.Driver");
    _jspx_th_sql_setDataSource_0.setUrl("jdbc:mysql://localhost:3306/pointofsales");
    _jspx_th_sql_setDataSource_0.setUser("root");
    _jspx_th_sql_setDataSource_0.setPassword("root");
    int _jspx_eval_sql_setDataSource_0 = _jspx_th_sql_setDataSource_0.doStartTag();
    if (_jspx_th_sql_setDataSource_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.reuse(_jspx_th_sql_setDataSource_0);
      return true;
    }
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.reuse(_jspx_th_sql_setDataSource_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("row");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${allCustomer.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <tr>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${row.custname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${row.ph}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${row.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${row.total}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</td>\n");
          out.write("                                    <td> <button type=\"submit\" name=\"passValue\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${row.custno}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\" >VIEW</button></td>\n");
          out.write("                                </tr>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setVar("row");
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${allCustomer.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${row.custname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">                                               \n");
          out.write("                                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setVar("row");
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${allTrans.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${row.transid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("\">                                               \n");
          out.write("                                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
