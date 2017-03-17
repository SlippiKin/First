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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Customerdetail;
import model.Login;
import session.CustomerSessionBean;
import utility.datetime;

/**
 *
 * @author INSPIRON 15
 */
public class searchForCustomer extends HttpServlet {

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
            out.println("<title>Servlet searchForCustomer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchForCustomer at " + request.getContextPath() + "</h1>");
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
        String custname = request.getParameter("custname");
        HttpSession session = request.getSession(true);
        String name = session.getAttribute("username").toString();

        PrintWriter out = response.getWriter();

        String custno = "";

        String ph = "";
        String email = "";
        String total = "";

        try {
            Customer customer = customerSessionBean.searchCustomerByName(name, custname);
            if (customer != null) {
                custno = customer.getCustno();
                ph = customer.getPh();
                email = customer.getEmail();
                total = customer.getTotal();

            }
            response.getWriter().write(ph + "," + email + "," + total);
            System.out.print("in ajax customer" + ph + "," + email + "," + total);
        } catch (Exception e) {
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
        String custname = request.getParameter("customername");
        String ph = request.getParameter("ph");
        String email = request.getParameter("email");
        String remain = request.getParameter("remain");
        String transid = request.getParameter("transdetail");
        Customerdetail customerdetail = new Customerdetail();
        datetime dt = new datetime();
        HttpSession session = request.getSession(true);
        String name = session.getAttribute("username").toString();
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        int custnumber = 0;
        int no = 0;
        Customer customer = new Customer();
        boolean exist = false;
        boolean sametransid = false;
        try {
            PrintWriter out = response.getWriter();
            Customer tempCustomer = new Customer();

            List h = customerSessionBean.viewAllCustomer(name);
            Iterator i = h.iterator();
            while (i.hasNext()) {

                Customer loopCustomer = (Customer) i.next();
                tempCustomer.setNo(loopCustomer.getNo());
                tempCustomer.setCustname(loopCustomer.getCustname());
                tempCustomer.setCustno(loopCustomer.getCustno());
                loopCustomer.setEmail(loopCustomer.getEmail());
                loopCustomer.setId(loopCustomer.getId());
                loopCustomer.setPh(loopCustomer.getPh());
                loopCustomer.setTotal(loopCustomer.getTotal());
                if (custnumber < Integer.parseInt(loopCustomer.getCustno())) {
                    custnumber = Integer.parseInt(loopCustomer.getCustno()) + 1;
                }

                customerList.add(tempCustomer);
            }

            List hh = customerSessionBean.viewAllCustomerDetailRecord(name);
            Iterator ii = hh.iterator();
            while (ii.hasNext()) {

                Customerdetail loopCustomerdetail = (Customerdetail) ii.next();

                if (loopCustomerdetail.getTransid().equals(transid)) {
                    out.println("<SCRIPT type=\"text/javascript\">");
                    out.println("alert(\"Not successful due to repeat same transaction number\")");
                    out.println("window.location.assign(\"customer.jsp\")");
                    out.println("</SCRIPT>");
                    sametransid = true;
                }
            }
            if (sametransid == false) {
                customerdetail.setDate(dt.getDate());
                customerdetail.setTime(dt.getTime());
                customerdetail.setDetailno(Integer.toString(custnumber));
                customerdetail.setId(name);
                customerdetail.setRemain(remain);
                customerdetail.setTransid(transid);

                for (int loop = 0; loop < customerList.size(); loop++) {
                    if (custname.equals(customerList.get(loop).getCustname())) {
                        exist = true;
                    }
                    if (customerList.size() - 1 == loop) {
                        no = customerList.get(loop).getNo() + 1;
                    }
                }

                if (exist == true) {
                    customer = customerSessionBean.searchCustomerByName(name, custname);

                    customer.setTotal(Double.toString(Double.parseDouble(customer.getTotal()) + Double.parseDouble(remain)));
                    customerdetail.setCustno(customer.getCustno());
                    customerSessionBean.updateCustomer(customer, name, custname);
                    customerSessionBean.insertCustomerDetailRecord(customerdetail);
                } else if (exist == false) {
                    customer.setCustno(Integer.toString(custnumber + 1));
                    customer.setCustname(custname);
                    customer.setEmail(email);
                    customer.setId(name);
                    customer.setPh(ph);
                    customer.setTotal(remain);
                    customer.setNo(no);

                    customerSessionBean.insertCustomerRecord(customer);
                    customerdetail.setCustno(Integer.toString(custnumber + 1));
                    customerdetail.setDetailno(Integer.toString(custnumber + 1));
                    customerSessionBean.insertCustomerDetailRecord(customerdetail);

                }
//            response.sendRedirect("customer.jsp"); 
                out.println("<SCRIPT type=\"text/javascript\">");
                out.println("alert(\"Record has been Save\")");
                out.println("window.location.assign(\"customer.jsp\")");
                out.println("</SCRIPT>");
            }
        } finally {

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
