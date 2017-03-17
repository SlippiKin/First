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
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import model.Product;
import session.ProductSessionBean;
import utility.productdetail;

/**
 *
 * @author blank
 */
public class addIncomingproduct extends HttpServlet {

    @EJB
    private ProductSessionBean productSessionBean;

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
            out.println("<title>Servlet addIncomingproduct</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addIncomingproduct at " + request.getContextPath() + "</h1>");
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
        // processRequest(request, response);
        
        HttpSession session = request.getSession(true);
        String name = session.getAttribute("username").toString();
        boolean checkExisting = false;
        int incoming = Integer.parseInt(request.getParameter("inquantity"));
        productdetail p1 = new productdetail();

        p1.setBarcode(request.getParameter("code"));
        p1.setProname(request.getParameter("name"));
        p1.setCategory(request.getParameter("cat"));
        p1.setCurrentquantity(request.getParameter("cquantity"));
        p1.setGst(request.getParameter("gst"));
        p1.setId(name);
        p1.setMinimumquantity(request.getParameter("orderlevel"));
        p1.setOriginalprice(request.getParameter("unit"));
        // p1.setProductimage(productimage);
        p1.setSellingprice(request.getParameter("selling"));
        p1.setShelflocation(request.getParameter("shelflocation"));
        p1.setSname(request.getParameter("supplier"));
        ArrayList<productdetail> allProduct = new ArrayList<productdetail>();
        try {
            PrintWriter out = response.getWriter();

            List h = productSessionBean.viewAllProduct();
            Iterator i = h.iterator();
            while (i.hasNext()) {

                Product loopProduct = (Product) i.next();
                productdetail product = new productdetail();
                product.setBarcode(loopProduct.getBarcode());
                product.setCategory(loopProduct.getCategory());
                product.setCurrentquantity(loopProduct.getCurrentquantity());
                product.setGst(loopProduct.getGst());
                product.setId(loopProduct.getId().getId());
                product.setMinimumquantity(loopProduct.getMinimumquantity());
                product.setSname(loopProduct.getSname());
                product.setOriginalprice(loopProduct.getOriginalprice());
                product.setSellingprice(loopProduct.getSellingprice());
                product.setShelflocation(loopProduct.getShelflocation());
                product.setProname(loopProduct.getProname());
                allProduct.add(product);
            }
            for (int ii = 0; ii < allProduct.size(); ii++) {
                if (p1.getBarcode().equals(allProduct.get(ii).getBarcode()) && p1.getId().equals(allProduct.get(ii).getId())) {
                    checkExisting = true;
                }
            }
            if (checkExisting == true) {
                
                p1.setCurrentquantity(Integer.toString(Integer.parseInt(p1.getCurrentquantity()) + incoming));
                productSessionBean.updateProduct(p1);
                
                out.println("<SCRIPT type=\"text/javascript\">");
                out.println("alert(\"Successful update.\")");
                out.println("window.location.assign(\"inventory.jsp\")");
                out.println("</SCRIPT>");
            } else {
                productSessionBean.insertRecord(p1);
               
                out.println("<SCRIPT type=\"text/javascript\">");
                out.println("alert(\"Successful insert.\")");
                out.println("window.location.assign(\"inventory.jsp\")");
                out.println("</SCRIPT>");
            }
           
            

        } catch (Exception e) {
//            @SuppressWarnings("ThrowableResultIgnored")
//            Exception cause = e.getCausedByException();
//            if (cause instanceof ConstraintViolationException) {
//                @SuppressWarnings("ThrowableResultIgnored")
//                ConstraintViolationException cve = (ConstraintViolationException) e.getCausedByException();
//                for (Iterator<ConstraintViolation<?>> it = cve.getConstraintViolations().iterator(); it.hasNext();) {
//                    ConstraintViolation<? extends Object> v = it.next();
//                    System.err.println(v);
//                    System.err.println("==>>" + v.getMessage());
//                }
//            }
           
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

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
