/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Product;
import model.Sales;
import model.TransDetail;
import session.ProductSessionBean;
import session.SalesSessionBean;
import session.TransSessionBean;
import utility.Convertor;
import utility.productdetail;

/**
 *
 * @author blank
 */
public class billing extends HttpServlet {

    @EJB
    private ProductSessionBean productSessionBean;
    @EJB
    private SalesSessionBean salesSessionBean;
    @EJB
    private TransSessionBean transSessionBean;

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
            out.println("<title>Servlet billing</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet billing at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        String id = session.getAttribute("username").toString();
        String[] barcode = request.getParameterValues("barcodetext");
        String[] name = request.getParameterValues("name");
        String[] price = request.getParameterValues("price");
        String[] quantity = request.getParameterValues("quantity");
        String total = request.getParameter("paymentvalue");         
        Product product = new Product();
        productdetail productDetail = new productdetail();
        int calculateQuantity;
        Convertor convertor = new Convertor();
        List trans = transSessionBean.viewAllTransDetailforuser(id);
        int size = trans.size();
        String transid = Integer.toString(size);
        TransDetail t = new TransDetail();
        
        t.setTransid(transid);
        t.setTotal(total);
        transSessionBean.insertRecord(t,id);
        //out.print(size);

        for (int i = 0; i < barcode.length; i++) {
            Sales sales = new Sales();
            sales.setBarcode(barcode[i]);            
            sales.setQuantity(Integer.parseInt(quantity[i]));
            sales.setTransid(transid);
            salesSessionBean.insertRecord(sales,id);
            product = productSessionBean.searchProductbyIDnBarcode(id, barcode[i]);
            calculateQuantity = Integer.parseInt(product.getCurrentquantity()) - Integer.parseInt(quantity[i]);
            product.setCurrentquantity(Integer.toString(calculateQuantity));
            //productSessionBean.updateProduct(productDetail.);
            productDetail = convertor.convertor(product);
            productDetail.setId(id);
            productSessionBean.updateProduct(productDetail);
        }

          RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
            rd.forward(request, response);
//        out.println("<html>");
//        out.println("<body onLoad='window.close();'>");
//        out.println("</html>");
//        out.close();
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
