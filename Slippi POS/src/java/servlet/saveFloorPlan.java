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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Floorplan;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import session.FloorPlanSessionBean;

/**
 *
 * @author INSPIRON 15
 */
public class saveFloorPlan extends HttpServlet {

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
            out.println("<title>Servlet saveFloorPlan</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet saveFloorPlan at " + request.getContextPath() + "</h1>");
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

        String objStr = request.getParameter("objectString");
        HttpSession session = request.getSession(true);
        String name = session.getAttribute("username").toString();
        System.out.print("jsoon string " + objStr);
        JSONObject obj;
        //delete database record
        try {
            List floorplan = floorPlanSessionBean.viewAllFloorPlan(name);
            Iterator iteratorFloorPlan = floorplan.iterator();
            ArrayList<Floorplan> floorPlanArray = new ArrayList<Floorplan>();
            while (iteratorFloorPlan.hasNext()) {

                Floorplan loopFloorPlan = (Floorplan) iteratorFloorPlan.next();
                Floorplan floorPlan = new Floorplan();
                floorPlan.setId(loopFloorPlan.getId());
                floorPlan.setShape(loopFloorPlan.getShape());
                floorPlan.setLevel(loopFloorPlan.getLevel());
                floorPlan.setShelfname(loopFloorPlan.getShelfname());
                floorPlan.setLocation(loopFloorPlan.getLocation());
                floorPlanArray.add(floorPlan);
            }
            System.out.print("delete servlet object contain " + floorPlanArray);
            for (int i = 0; i < floorPlanArray.size(); i++) {
                floorPlanSessionBean.deleteFloorPlan(name, floorPlanArray.get(i).getShelfname());
            }
        } catch (Exception e) {

        }
        try {
            obj = new JSONObject(objStr);
            System.out.print("obj stringify " + obj.toString());
            JSONArray geodata = obj.getJSONArray("shelf");
            Floorplan floorPlanDetail;
            for (int i = 0; i < geodata.length(); ++i) {
                floorPlanDetail = new Floorplan();
                final JSONObject shelf = geodata.getJSONObject(i);
                if (shelf.getString("name").equals("null")) {
                } else {
                    floorPlanDetail.setShelfname(shelf.getString("name"));
                    floorPlanDetail.setLocation(shelf.getString("location"));
                    floorPlanDetail.setShape(shelf.getString("shape"));
                    floorPlanDetail.setLevel(shelf.getString("level"));
                    floorPlanSessionBean.insertFloorPlan(floorPlanDetail, name);
                }
            }
        } catch (JSONException ex) {
            Logger.getLogger(saveFloorPlan.class.getName()).log(Level.SEVERE, null, ex);
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
        //processRequest(request, response);

        String objStr = request.getParameter("objectString");
        HttpSession session = request.getSession(true);
        String name = session.getAttribute("username").toString();
        System.out.print(objStr);
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
