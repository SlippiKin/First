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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Login;
import model.Product;
import model.Sales;
import model.TransDetail;
import session.LoginSessionBean;
import session.ProductSessionBean;
import session.SalesSessionBean;
import session.TransSessionBean;
import utility.combine;

/**
 *
 * @author blank
 */
public class displayBill extends HttpServlet {

    @EJB
    private LoginSessionBean loginSessionBean;
    @EJB
    private ProductSessionBean productSessionBean;
    @EJB
    private TransSessionBean transSessionBean;
    @EJB
    private SalesSessionBean salesSessionBean;
    
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
            out.println("<title>Servlet displayBill</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet displayBill at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //processRequest(request, response);
        String id = request.getParameter("passValue");
        String tid = Integer.toString(Integer.parseInt(id) - 1);
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String name = session.getAttribute("username").toString();
        ArrayList<combine> list = new ArrayList<combine>();

        try {

            List h = salesSessionBean.viewSalesTransaction(name, tid);
            Iterator i = h.iterator();

            while (i.hasNext()) {

                Sales at = (Sales) i.next();
                combine allDetailOfProduct = new combine();
                allDetailOfProduct.setBarcode(at.getBarcode());
                allDetailOfProduct.setQuantity(Integer.toString(at.getQuantity()));
                Product p = productSessionBean.searchProductbyIDnBarcode(name, at.getBarcode());
                allDetailOfProduct.setPrice(p.getSellingprice());
                allDetailOfProduct.setName(p.getProname());

                list.add(allDetailOfProduct);

            }
            TransDetail td = transSessionBean.searchTransDetail(name, tid);
          

            
            Login businessInformation = loginSessionBean.searchAccount(name);
            out.println(businessInformation);
            request.setAttribute("TransDetail", td);
            request.setAttribute("detail", list); //for forloop the product
            request.setAttribute("businessInformation", businessInformation);
            RequestDispatcher req = request.getRequestDispatcher("displaybill.jsp");
            req.forward(request, response);

        } finally {
            out.close();
        }

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
