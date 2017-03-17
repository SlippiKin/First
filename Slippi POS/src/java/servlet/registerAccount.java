
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
import model.Login;
import session.LoginSessionBean;

/**
 *
 * @author blank
 */
public class registerAccount extends HttpServlet {

    @EJB
    private LoginSessionBean loginSessionBean;

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
            out.println("<title>Servlet registerAccount</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet registerAccount at " + request.getContextPath() + "</h1>");
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
        //  processRequest(request, response);
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

        Login inputAccount = new Login();
        inputAccount.setBusname(request.getParameter("businessname"));
        inputAccount.setDob(request.getParameter("birthday"));
        inputAccount.setEmail(request.getParameter("email"));
        inputAccount.setHp(request.getParameter("phonenumber"));
        inputAccount.setId(request.getParameter("username"));
        inputAccount.setName(request.getParameter("fullname"));
        inputAccount.setPassword(request.getParameter("password"));
        inputAccount.setSuccessful("---");
        inputAccount.setUnsuccessful("---");
         

        ArrayList<Login> allAccount = new ArrayList<Login>();
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();

            List h = loginSessionBean.viewAllaccount();
            Iterator i = h.iterator();
            while (i.hasNext()) {

                Login loopAccount = (Login) i.next();
                Login account = new Login();

                account.setId(loopAccount.getId());
                account.setPassword(loopAccount.getPassword());
                account.setName(loopAccount.getName());
                account.setDob(loopAccount.getDob());
                account.setHp(loopAccount.getHp());
                account.setBusname(loopAccount.getBusname());
                account.setEmail(loopAccount.getEmail());
                
                allAccount.add(account);
            }

            Boolean correct = true;

            for (int ii = 0; ii < allAccount.size(); ii++) {
                if (inputAccount.getId().equals(allAccount.get(ii).getId())) {

                    out.println("<SCRIPT type=\"text/javascript\">");
                    out.println("alert(\"Login username has been used.\")");
                    out.println("window.location.assign(\"register.jsp\")");
                    out.println("</SCRIPT>");
                    correct = false;
                    /*request.getSession().setAttribute("username", inputAccount[0]);
                     request.getSession().setAttribute("role", "user");

                     RequestDispatcher req = request.getRequestDispatcher("Home.jsp");
                     req.forward(request, response);*/

                }
            }
            if (correct == true) {
                loginSessionBean.insertRecord(inputAccount);
                out.println("<SCRIPT type=\"text/javascript\">");
                out.println("alert(\"Successful register.\")");
                out.println("window.location.assign(\"index.html\")");
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
