package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class shelf_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Shelf</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>\n");
      out.write("        <script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"http://localhost:47617/Scripts/jquery-1.9.1.min.js\"></script>\n");
      out.write("        <link href=\"css/inventorystyle.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"css/example.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/dragula.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
      out.write("                    <li><a href=\"Home.jsp\" accesskey=\"a\">Sales (A)</a></li>\n");
      out.write("                    <li><a href=\"inventory.jsp\" accesskey=\"i\">Inventory (I)</a></li>\n");
      out.write("                    <li><a href=\"supplier.jsp\" accesskey=\"s\">Supplier (S)</a></li>\n");
      out.write("                    <li  class=\"active\"><a href=\"shelf.jsp\" accesskey=\"y\">Shelf (Y)</a></li>\n");
      out.write("                    <li><a href=\"customer.jsp\" accesskey=\"c\">Customer (C)</a></li>\n");
      out.write("                    <li><a href=\"reportInformation\" accesskey=\"r\">Report (R)</a></li>\n");
      out.write("                    <li><a href=\"history.jsp\" accesskey=\"h\">History (H)</a></li></ul>\n");
      out.write("                <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                    <li class=\"active\"><a href=\"index.html\" accesskey=\"l\">Logout (L)<span class=\"sr-only\">(current)</span></a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div><!--/.nav-collapse -->\n");
      out.write("\n");
      out.write("        </nav>    \n");
      out.write("        <div class='parent'>\n");
      out.write("            <label for='hy'>Copying stuff is common too, so we made it easy for you.</label>\n");
      out.write("            <div class='wrapper'>\n");
      out.write("                <div id='left-copy' class='container'>\n");
      out.write("                    <div>When elements are copyable, they can't be sorted in their origin container</div>\n");
      out.write("                    <div>Copying prevents original elements from being dragged. A copy gets created and <em>that</em> gets dragged instead</div>\n");
      out.write("                    <div>Whenever that happens, a <code>cloned</code> event is raised</div>\n");
      out.write("                </div>\n");
      out.write("                <div id='right-copy' class='container'>\n");
      out.write("                    <div>Note that the clones get destroyed if they're not dropped into another container</div>\n");
      out.write("                    <div>You'll be dragging a copy, so when they're dropped into another container you'll see the duplication.</div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <pre>\n");
      out.write("      <code>\n");
      out.write("dragula([document.getElementById(left), document.getElementById(right)], {\n");
      out.write("  copy: true\n");
      out.write("});\n");
      out.write("      </code>\n");
      out.write("            </pre>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
}
