/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author blank
 */
public class searchForInventoryform extends HttpServlet {
    private Object session;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet searchForInventoryform</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchForInventoryform at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String barcode = request.getParameter("barcode");
        HttpSession session = request.getSession(true);
        String name =  session.getAttribute("username").toString();
        
        PrintWriter out = response.getWriter();

        String proname = "",originalprice="", sellingprice="",minimumquantity="",gst="", shelflocation="", 
                    currentquantity="",productimage="",category="",sname=""; 
                    
                     
         
        
        try
        {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pointofsales","root", "root");
              
                java.sql.Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from product where barcode = '" + barcode + "' and id = '" + name + "'");
                if(rs.next())
                {
                   proname=rs.getString("proname"); originalprice=rs.getString("originalprice"); sellingprice=rs.getString("sellingprice"); 
                    minimumquantity=rs.getString("minimumquantity"); gst=rs.getString("gst"); shelflocation=rs.getString("shelflocation"); 
                    currentquantity=rs.getString("currentquantity"); 
                    productimage=rs.getString("productimage"); category=rs.getString("category"); sname=rs.getString("sname"); 
                    
                     
                }
                else 
                    proname = "";
              
                response.getWriter().write(proname+","+originalprice+","+sellingprice+","
                        +minimumquantity+","+gst+","+shelflocation+","+currentquantity+","
                        +productimage+","+category+","+sname);
                

        }
        catch(Exception e)
        {

            e.printStackTrace();
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
