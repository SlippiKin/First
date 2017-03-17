/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Floorplan;
import model.Login;
import org.json.JSONArray;
import org.json.JSONObject;
import session.FloorPlanSessionBean;

/**
 *
 * @author INSPIRON 15
 */
public class getFloorPlanFromAjax extends HttpServlet {

    @EJB
    private FloorPlanSessionBean floorPlanSessionBean;

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
            out.println("<title>Servlet getFloorPlanFromAjax</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet getFloorPlanFromAjax at " + request.getContextPath() + "</h1>");
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
        JSONArray jsonArray = new JSONArray();
        HttpSession session = request.getSession(true);
        String name = session.getAttribute("username").toString();
        
        String jsonStr = "{\"shelf\":[";
             try {
        List floorPlanList =  floorPlanSessionBean.viewAllFloorPlan(name);
        Iterator iteratorFloorPlan = floorPlanList.iterator();
            while (iteratorFloorPlan.hasNext()) {
                
                

                Floorplan loopFloorPlan = (Floorplan) iteratorFloorPlan.next();
                jsonStr = jsonStr + "{\"name\":\"" + loopFloorPlan.getShelfname() + "\",\"location\":\"" + loopFloorPlan.getLocation() + "\",\"shape\":\"" + loopFloorPlan.getShape() 
                        + "\",\"level\":\"" + loopFloorPlan.getLevel() + "\"}";
                if(iteratorFloorPlan.hasNext()){
                    jsonStr = jsonStr + ",";
                }
            }
            jsonStr = jsonStr + "]}";
            
//        Gson gson = new Gson();
//        String json = "{\"shelf\":" + gson.toJson(floorPlanList) + "}";  
        System.out.print("gson in list " + jsonStr);
        response.getWriter().write(jsonStr);
             }catch(Exception e){
                 System.out.print("error " + e);
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
