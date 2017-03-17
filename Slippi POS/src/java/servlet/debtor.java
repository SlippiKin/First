/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Customerdetail;
import session.CustomerSessionBean;

/**
 *
 * @author INSPIRON 15
 */
public class debtor extends HttpServlet {

    @EJB
    private CustomerSessionBean customerSessionBean;

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
            out.println("<title>Servlet debtor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet debtor at " + request.getContextPath() + "</h1>");
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

        HttpSession session = request.getSession(true);
        String name = session.getAttribute("username").toString();
        String custno = request.getParameter("custno");
        double pay = Double.parseDouble(request.getParameter("pay"));
        String transid = request.getParameter("transid");
        PrintWriter out = response.getWriter();
        out.print("in name and custno = " + name + " " + custno);
        System.out.print("in name and custno = " + name + " " + custno);
        Customerdetail customer = customerSessionBean.searchCustomerDetail(name, custno, transid);
        Customer cus = customerSessionBean.searchCustomer(name, custno);
        double remain = Double.parseDouble(customer.getRemain()) - pay;
        if (remain < 0) {
            customer.setRemain("0.0");
            
        } else {
            customer.setRemain(Double.toString(Math.round(remain * 100.0) / 100.0));
            
            customerSessionBean.updateCustomerDetail(customer, name, custno);
            
        }
        cus.setTotal(Double.toString(Math.round((Double.parseDouble(cus.getTotal()) - pay) * 100.0) / 100.0));
        customerSessionBean.updateCustomer(cus, name, custno);
        System.out.print("in post and remain = " + customer.getRemain() + " " + cus.getTotal());
        
        if(customer.getRemain().equals("0.0")){
            System.out.print("delete customerdetail");
            customerSessionBean.deleteCustomerDetail(name, custno, transid);
        }

        request.setAttribute("passValue", custno);
        RequestDispatcher req = request.getRequestDispatcher("customer.jsp");
        req.forward(request, response);
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
