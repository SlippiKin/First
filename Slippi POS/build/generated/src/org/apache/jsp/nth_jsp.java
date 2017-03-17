package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nth_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write(" \n");
      out.write("         <title>Shelf</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\">         \n");
      out.write("        <link href=\"css/inventorystyle.css\" rel=\"stylesheet\" type=\"text/css\"/>        \n");
      out.write("        <script src=\"js/jquery.min.js\" type=\"text/javascript\"></script>       \n");
      out.write("        <script src=\"js/angular.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("             var test1 = [{\n");
      out.write("                    \"Country\": \"Spain\",\n");
      out.write("                    \"info info1\": 0.329235716,\n");
      out.write("                    \"info info2\": 0.447683684,\n");
      out.write("                    \"info info3\": 0.447683747\n");
      out.write("                }, {\n");
      out.write("                    \"Country\": \"Chile\",\n");
      out.write("                    \"info info1\": 1.302673893,\n");
      out.write("                    \"info info2\": 1.357820775,\n");
      out.write("                    \"info info3\": 1.35626442\n");
      out.write("                }, {\n");
      out.write("                    \"Country\": \"USA\",\n");
      out.write("                    \"info info1\": 7.78805016,\n");
      out.write("                    \"info info2\": 26.59681951,\n");
      out.write("                    \"info info3\": 9.200900779\n");
      out.write("                }];\n");
      out.write("\n");
      out.write("            var jsonStr = '{\"shelf\":[{\"name\":\"shelfA\",\"location\":\"div1\", \"shape\":\"vertical\"},{\"name\":\"shelfb\",\"location\":\"div2\", \"shape\":\"horizon\"}]}';\n");
      out.write("            \n");
      out.write("            var jsonObj = JSON.parse(jsonStr);\n");
      out.write("            //delete jsonObj.shelf[0];\n");
      out.write("            var objectt = removeCsvEntry(jsonObj.shelf, 'name', 'shelfA');\n");
      out.write("            jsonObj = jsonObj.shelf[1].splice(1,1);\n");
      out.write("            console.log(JSON.stringify(jsonObj));\n");
      out.write("            function removeCsvEntry(object, key, value)\n");
      out.write("            {\n");
      out.write("                $.each(object, function (index)\n");
      out.write("                {   \n");
      out.write("                    alert(\"index \" + index );\n");
      out.write("                    $.each(this, function (k, v)\n");
      out.write("                    {   \n");
      out.write("                        \n");
      out.write("                        if (k == key && v == value)\n");
      out.write("                        {\n");
      out.write("                            console.log(\"k \" + k + \" key \" + key + \" y \" + value);\n");
      out.write("                            object.shelf.splice(index, 1);\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("\n");
      out.write("     \n");
      out.write("\n");
      out.write("                return object;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("//            $('#test1').val(JSON.stringify(test1));\n");
      out.write("//\n");
      out.write("//\n");
      out.write("//            var test2 = removeCsvEntry(test1, 'Country', 'Chile');\n");
      out.write("//            \n");
      out.write("//            $('#test2').val(JSON.stringify(test2));\n");
      out.write("//            alert(test2);\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
