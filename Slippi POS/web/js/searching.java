/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author blank
 */
public class searching extends HttpServlet {

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
            out.println("<title>Servlet searching</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searching at " + request.getContextPath() + "</h1>");
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
//        String barcode = request.getParameter("barcode");
//        String buffer = "";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pointofsales","root", "");
//            java.sql.Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select * from product where barcode = '" + barcode + "'");
//            if (rs.next()) {
//                buffer = buffer + "'" + rs.getString("proname") + "'";
//            }
//            response.getWriter().println(buffer);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        
        String barcode = request.getParameter("q");
        String name = request.getParameter("username");
        PrintWriter out = response.getWriter();
       

        String proname;
         
        
        try
        {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pointofsales","root", "");
              
                java.sql.Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select * from product where barcode = '" + barcode + "' and id = '" + name + "'");
                if(rs.next())
                {
                    proname=rs.getString("barcode");
                     
                }
                else
                {
                    proname="";
                    
                }
                response.getWriter().write(proname);
                

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
