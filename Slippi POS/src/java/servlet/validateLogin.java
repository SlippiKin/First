/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.YearMonth;
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
import utility.datetime;

/**
 *
 * @author blank
 */
public class validateLogin extends HttpServlet {

    @EJB
    private LoginSessionBean loginSessionBean;
    private datetime dateTime = new datetime();

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
            out.println("<title>Servlet validateLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet validateLogin at " + request.getContextPath() + "</h1>");
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

        YearMonth yearMonth = YearMonth.of(2017, 1);  // January of 2015.
        LocalDate firstOfMonth = yearMonth.atDay(1);
        LocalDate last = yearMonth.atEndOfMonth();
        
        System.out.print("first" + firstOfMonth);
        System.out.print("end" + last);

        String[] inputAccount = {request.getParameter("username"), request.getParameter("password")};
        PrintWriter outz = response.getWriter();

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
                account.setSuccessful(loopAccount.getSuccessful());
                account.setUnsuccessful(loopAccount.getUnsuccessful());
                account.setBusname(loopAccount.getBusname());
                account.setDob(loopAccount.getDob());
                account.setEmail(loopAccount.getEmail());
                account.setHp(loopAccount.getHp());
                account.setName(loopAccount.getName());

                allAccount.add(account);
            }

            Boolean correct = false;
            String lSucess = "";
            String lUnsucess = "";
            for (int ii = 0; ii < allAccount.size(); ii++) {
                if (inputAccount[0].equals(allAccount.get(ii).getId()) && inputAccount[1].equals(allAccount.get(ii).getPassword())) {

                    correct = true;
                    request.getSession().setAttribute("username", inputAccount[0]);
                    request.getSession().setAttribute("role", "user");

                    lSucess = allAccount.get(ii).getSuccessful();
                    lUnsucess = allAccount.get(ii).getUnsuccessful();
                    //allAccount.get(ii).setSuccessful(dateTime.getDate() + " " + dateTime.getTime());
                    Login passLogin = allAccount.get(ii);
                    passLogin.setSuccessful(dateTime.getDate() + " " + dateTime.getTime());
                    loginSessionBean.updateLogin(passLogin);
                    RequestDispatcher req = request.getRequestDispatcher("landingPage.jsp");
                    request.setAttribute("sucess", lSucess);
                    request.setAttribute("lusucess", lUnsucess);
                    request.setAttribute("business", allAccount.get(ii).getBusname());
                    req.forward(request, response);

                } else {

                }
            }
            if (correct == false) {
                for (int ii = 0; ii < allAccount.size(); ii++) {
                    if (inputAccount[0].equals(allAccount.get(ii).getId())) {
                        allAccount.get(ii).setUnsuccessful(dateTime.getDate() + " " + dateTime.getTime());
                        loginSessionBean.updateLogin(allAccount.get(ii));
                    }
                }
            }
            out.println("<SCRIPT type=\"text/javascript\">");
            out.println("alert(\"Login username and password is incorrect\")");
            out.println("window.location.assign(\"index.html\")");
            out.println("</SCRIPT>");
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
