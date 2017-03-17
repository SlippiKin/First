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
import model.Customer;
import model.Customerdetail;
import session.CustomerSessionBean;
import utility.combine;
import utility.customerdetailinformation;

/**
 *
 * @author INSPIRON 15
 */
public class displayCustomerDetail extends HttpServlet {

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
            HttpSession session = request.getSession(true);
            String name = session.getAttribute("username").toString();
            String custno = request.getParameter("passValue");

            System.out.print("in here " + name + " " + custno);

            try {
                Customer customer = customerSessionBean.searchCustomer(name, custno);
                System.out.println(customer);
                ArrayList<customerdetailinformation> list = new ArrayList<customerdetailinformation>();
                List h = customerSessionBean.viewAllCustomerDetail(name, custno);
                Iterator i = h.iterator();

                while (i.hasNext()) {

                    Customerdetail customerList = (Customerdetail) i.next();
                    customerdetailinformation allCustomerDetail = new customerdetailinformation();
                    allCustomerDetail.setDate(customerList.getDate());
                    allCustomerDetail.setDetailno(customerList.getDetailno());
                    allCustomerDetail.setCustno(customerList.getCustno());
                    allCustomerDetail.setTime(customerList.getTime());
                    allCustomerDetail.setRemain(customerList.getRemain());
                    allCustomerDetail.setTransid(customerList.getTransid());

                    list.add(allCustomerDetail);

                }
                
                request.setAttribute("custno", custno);
                request.setAttribute("customer", customer);
                request.setAttribute("list", list); //for forloop the product
                RequestDispatcher req = request.getRequestDispatcher("displaycustomerdetaillist.jsp");
                req.forward(request, response);

            } finally {
               
            }

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
        System.out.print("in get");

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
       
        System.out.print("in post");
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
