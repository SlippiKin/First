/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Login;
import model.Supplier;
import session.SupplierSessionBean;

/**
 *
 * @author blank
 */
public class addSupplier extends HttpServlet {
    @EJB
    private SupplierSessionBean supplierSessionBean;

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
            out.println("<title>Servlet addSupplier</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addSupplier at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession(true);
        String name = session.getAttribute("username").toString();
        Supplier inputSupplier = new Supplier();
        inputSupplier.setAddress(request.getParameter("address"));
        inputSupplier.setEmail(request.getParameter("email"));
        inputSupplier.setHp(request.getParameter("phonenumber"));
        Login login = new Login();
        login.setId(name);
        inputSupplier.setSellman(request.getParameter("agent"));
        inputSupplier.setSname(request.getParameter("sname"));
        ArrayList<Supplier> allSupplier = new ArrayList<Supplier>();
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();

            List h = supplierSessionBean.viewAllSupplier();
            Iterator i = h.iterator();
            while (i.hasNext()) {

                Supplier loopSupplier = (Supplier) i.next();
                Supplier supplier = new Supplier();
                supplier.setAddress(loopSupplier.getAddress());
                supplier.setId(loopSupplier.getId());
                supplier.setHp(loopSupplier.getHp());
                supplier.setEmail(loopSupplier.getEmail());
                supplier.setSellman(loopSupplier.getSellman());
                supplier.setSname(loopSupplier.getSname());
                allSupplier.add(supplier);
            }

            Boolean correct = true;
           // out.print(inputSupplier.getAddress() + inputSupplier.getEmail() + inputSupplier.getHp()+ inputSupplier.getId()+inputSupplier.getSname()+name);
            for (int ii = 0; ii < allSupplier.size(); ii++) {
                if (login.getId().equals(allSupplier.get(ii).getId().getId()) && inputSupplier.getSname().equals(allSupplier.get(ii).getSname())) {
                    
                    supplierSessionBean.updateSupplier(inputSupplier,name);
                    out.println("<SCRIPT type=\"text/javascript\">");
                    out.println("alert(\"Successful Edit.\")");
                    out.println("window.location.assign(\"supplier.jsp\")");
                    out.println("</SCRIPT>");
                    correct = false;      
                }
            }
            if (correct == true) {
                supplierSessionBean.insertRecord(inputSupplier,name);
                out.println("<SCRIPT type=\"text/javascript\">");
                out.println("alert(\"Successful register.\")");
                out.println("window.location.assign(\"supplier.jsp\")");
                out.println("</SCRIPT>");

            }
        } finally {

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
