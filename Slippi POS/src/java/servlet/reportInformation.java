/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Sales;
import model.TransDetail;
import session.ProductSessionBean;
import session.SalesSessionBean;
import session.TransSessionBean;
import utility.Convertor;
import utility.Report;
import utility.datetime;
import utility.productdetail;

/**
 *
 * @author INSPIRON 15
 */
public class reportInformation extends HttpServlet {

    @EJB
    private TransSessionBean transSessionBean;

    @EJB
    private SalesSessionBean salesSessionBean;

    @EJB
    private ProductSessionBean productSessionBean;
    private datetime dateTime;

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
        HttpSession session = request.getSession(true);
        String name = session.getAttribute("username").toString();

        ArrayList<TransDetail> allTransDetail = new ArrayList<TransDetail>();
        try {
            PrintWriter out = response.getWriter();
            dateTime = new datetime();
            Convertor convertor = new Convertor();
            String todayDate = dateTime.getDate();
            String nowTime = dateTime.getTime();
            String currentTransid = "";
            productdetail ProductDetail;
            ArrayList<productdetail> ListProductDetail = new ArrayList<productdetail>();
            Report currentReport = new Report();
            Report weeklyReport = new Report();
            Report monthlyReport = new Report();
            Report yearlyReport = new Report();

            List h = transSessionBean.searchTransWithDate(name, todayDate);
            Iterator i = h.iterator();
            while (i.hasNext()) {

                //Login loopAccount = (Login) i.next();
                TransDetail loopTransDetail = (TransDetail) i.next();
                TransDetail transDetail = new TransDetail();
                //Login account = new Login();
                transDetail.setNo(loopTransDetail.getNo());
                transDetail.setId(loopTransDetail.getId());
                transDetail.setDate(loopTransDetail.getDate());
                transDetail.setTime(loopTransDetail.getTime());
                transDetail.setTotal(loopTransDetail.getTotal());
                transDetail.setTransid(loopTransDetail.getTransid());
                allTransDetail.add(transDetail);
            }

            for (int ii = 0; ii < allTransDetail.size(); ii++) {
                //out.println(allTransDetail.get(ii).getNo());
                currentReport.setProductSales(currentReport.getProductSales() + Integer.parseInt(allTransDetail.get(ii).getTotal()));
                List salesList = salesSessionBean.viewSalesTransaction(name, allTransDetail.get(ii).getTransid());
                //  out.println(" list " + salesList + "xxx");
                Iterator iterator = salesList.iterator();
                while (iterator.hasNext()) {

                    //Login loopAccount = (Login) i.next();
                    Sales loopSalesDetail = (Sales) iterator.next();

                    currentReport.setPrice(convertor.getProductPrice(productSessionBean.searchProductbyIDnBarcode(name, loopSalesDetail.getBarcode())) * loopSalesDetail.getQuantity());
                    ProductDetail = new productdetail();
                    ProductDetail.setBarcode(loopSalesDetail.getBarcode());
                    ProductDetail.setQuantity(loopSalesDetail.getQuantity());
                    currentReport.setProductPrice(convertor.getSellingProductPrice(productSessionBean.searchProductbyIDnBarcode(name, loopSalesDetail.getBarcode())));
                    ProductDetail.setSellingprice(Double.toString(currentReport.getProductPrice()));
                    if (ListProductDetail.size() == 0) {
                        out.println("in" + ListProductDetail.size());
                        ListProductDetail.add(ProductDetail);
                    } else {
                        out.println("enter else");
                        ListProductDetail = convertor.checkArrayGotSame(ProductDetail, ListProductDetail);
                    }

                    // out.println("price " + price);
                    currentReport.setCOGS(currentReport.getCOGS() + currentReport.getPrice());
                    // out.println(" COGS " + COGS);
                }
            }
            out.println("size " + ListProductDetail.size());
            for (int ii = 0; ii < ListProductDetail.size(); ii++) {
                out.println(ListProductDetail.get(ii).getBarcode());
            }
            currentReport.setEarning(currentReport.getProductSales() - currentReport.getCOGS());
            currentReport.setNoOfSales(allTransDetail.size());
            currentReport.setMargin((currentReport.getEarning() / currentReport.getProductSales()) * 100);
            System.out.println("current report : " + currentReport.getCOGS() + " " + currentReport.getEarning() + " " + currentReport.getMargin() + " " + currentReport.getNoOfSales() + " " + currentReport.getProductSales());

            //out.println("product sales " + productSales + " COGS " + COGS + " Earning " + Earning + " noOfSales " + noOfSales + " margin " + Margin);
//---------------------------------------weekly calender ---------------------------------------------------------
            Calendar c = GregorianCalendar.getInstance();
            c.setFirstDayOfWeek(Calendar.MONDAY);
            System.out.println("Current week = " + Calendar.DAY_OF_WEEK);

            // Set the calendar to monday of the current week
            c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            System.out.println("Current week = " + Calendar.DAY_OF_WEEK);

            // Print dates of the current week starting on Monday
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String startDate = "", endDate = "";

            startDate = df.format(c.getTime());
            c.add(Calendar.DATE, 6);
            endDate = df.format(c.getTime());

            System.out.println("Start Date = " + startDate);
            System.out.println("End Date = " + endDate);
//------------------------------weekly ----------------------------------------------------------

            List WeekList = transSessionBean.searchWeeklyWithDate(name, startDate, endDate);
            ArrayList<TransDetail> allWeekTransDetail = new ArrayList<TransDetail>();
            ArrayList<productdetail> ListWeeklyProductDetail = new ArrayList<productdetail>();
            Iterator iteratorWeekList = WeekList.iterator();
            while (iteratorWeekList.hasNext()) {

                //Login loopAccount = (Login) i.next();
                TransDetail loopWeekTransDetail = (TransDetail) iteratorWeekList.next();
                TransDetail transDetail = new TransDetail();
                //Login account = new Login();
                transDetail.setNo(loopWeekTransDetail.getNo());
                transDetail.setId(loopWeekTransDetail.getId());
                transDetail.setDate(loopWeekTransDetail.getDate());
                transDetail.setTime(loopWeekTransDetail.getTime());
                transDetail.setTotal(loopWeekTransDetail.getTotal());
                transDetail.setTransid(loopWeekTransDetail.getTransid());
                allWeekTransDetail.add(transDetail);
            }

            System.out.println("allWeekTransDetail size = " + allWeekTransDetail.size());

            for (int ii = 0; ii < allWeekTransDetail.size(); ii++) {
                //out.println(allTransDetail.get(ii).getNo());
                weeklyReport.setProductSales(weeklyReport.getProductSales() + Integer.parseInt(allWeekTransDetail.get(ii).getTotal()));
                List salesList = salesSessionBean.viewSalesTransaction(name, allWeekTransDetail.get(ii).getTransid());
                //  out.println(" list " + salesList + "xxx");
                Iterator iterator = salesList.iterator();
                while (iterator.hasNext()) {

                    //Login loopAccount = (Login) i.next();
                    Sales loopSalesDetail = (Sales) iterator.next();

                    weeklyReport.setPrice(convertor.getProductPrice(productSessionBean.searchProductbyIDnBarcode(name, loopSalesDetail.getBarcode())) * loopSalesDetail.getQuantity());
                    ProductDetail = new productdetail();
                    ProductDetail.setBarcode(loopSalesDetail.getBarcode());
                    ProductDetail.setQuantity(loopSalesDetail.getQuantity());
                    weeklyReport.setProductPrice(convertor.getSellingProductPrice(productSessionBean.searchProductbyIDnBarcode(name, loopSalesDetail.getBarcode())));
                    ProductDetail.setSellingprice(Double.toString(weeklyReport.getProductPrice()));
                    if (ListWeeklyProductDetail.size() == 0) {
                        out.println("in" + ListWeeklyProductDetail.size());
                        ListWeeklyProductDetail.add(ProductDetail);
                    } else {
                        out.println("enter else");
                        ListWeeklyProductDetail = convertor.checkArrayGotSame(ProductDetail, ListWeeklyProductDetail);
                    }

                    // out.println("price " + price);
                    weeklyReport.setCOGS(weeklyReport.getCOGS() + weeklyReport.getPrice());
                    // out.println(" COGS " + COGS);
                    weeklyReport.setStarting(startDate);
                    weeklyReport.setEnding(endDate);
                }
            }
            out.println("size " + ListWeeklyProductDetail.size());
            for (int ii = 0; ii < ListWeeklyProductDetail.size(); ii++) {
                System.out.println(ListWeeklyProductDetail.get(ii).getBarcode());
            }
            weeklyReport.setEarning(weeklyReport.getProductSales() - weeklyReport.getCOGS());
            weeklyReport.setNoOfSales(allWeekTransDetail.size());
            weeklyReport.setMargin((weeklyReport.getEarning() / weeklyReport.getProductSales()) * 100);
            System.out.println("weekly report : " + weeklyReport.getCOGS() + " " + weeklyReport.getEarning() + " " + weeklyReport.getMargin() + " " + weeklyReport.getNoOfSales() + " " + weeklyReport.getProductSales());

//------------------------------monthly calender----------------------------------------------------------------
            LocalDate today = LocalDate.now();
//            System.out.println("First day: " + today.withDayOfMonth(1));
//            System.out.println("Last day: " + today.withDayOfMonth(today.lengthOfMonth()));
            monthlyReport.setStarting(today.withDayOfMonth(1).toString());
            monthlyReport.setEnding(today.withDayOfMonth(today.lengthOfMonth()).toString());
            System.out.println("today monthly start " +  monthlyReport.getStarting());
            System.out.println("today monthly end " + monthlyReport.getEnding());
//------------------------------monthly ----------------------------------------------------------

            List MonthlyList = transSessionBean.searchWeeklyWithDate(name, monthlyReport.getStarting(), monthlyReport.getEnding());
            ArrayList<TransDetail> allMonthTransDetail = new ArrayList<TransDetail>();
            ArrayList<productdetail> ListMonthProductDetail = new ArrayList<productdetail>();
            Iterator iteratorMonthList = MonthlyList.iterator();
            while (iteratorMonthList.hasNext()) {

                //Login loopAccount = (Login) i.next();
                TransDetail loopMonthTransDetail = (TransDetail) iteratorMonthList.next();
                TransDetail transDetail = new TransDetail();
                //Login account = new Login();
                transDetail.setNo(loopMonthTransDetail.getNo());
                transDetail.setId(loopMonthTransDetail.getId());
                transDetail.setDate(loopMonthTransDetail.getDate());
                transDetail.setTime(loopMonthTransDetail.getTime());
                transDetail.setTotal(loopMonthTransDetail.getTotal());
                transDetail.setTransid(loopMonthTransDetail.getTransid());
                allMonthTransDetail.add(transDetail);
            }

            System.out.println("allMonthTransDetail size = " + allMonthTransDetail.size());

            for (int ii = 0; ii < allMonthTransDetail.size(); ii++) {
                //out.println(allTransDetail.get(ii).getNo());
                monthlyReport.setProductSales(monthlyReport.getProductSales() + Integer.parseInt(allMonthTransDetail.get(ii).getTotal()));
                List salesList = salesSessionBean.viewSalesTransaction(name, allMonthTransDetail.get(ii).getTransid());
                //  out.println(" list " + salesList + "xxx");
                Iterator iterator = salesList.iterator();
                while (iterator.hasNext()) {

                    //Login loopAccount = (Login) i.next();
                    Sales loopSalesDetail = (Sales) iterator.next();

                    monthlyReport.setPrice(convertor.getProductPrice(productSessionBean.searchProductbyIDnBarcode(name, loopSalesDetail.getBarcode())) * loopSalesDetail.getQuantity());
                    ProductDetail = new productdetail();
                    ProductDetail.setBarcode(loopSalesDetail.getBarcode());
                    ProductDetail.setQuantity(loopSalesDetail.getQuantity());
                    monthlyReport.setProductPrice(convertor.getSellingProductPrice(productSessionBean.searchProductbyIDnBarcode(name, loopSalesDetail.getBarcode())));
                    ProductDetail.setSellingprice(Double.toString(monthlyReport.getProductPrice()));
                    if (ListMonthProductDetail.size() == 0) {
                        out.println("in" + ListMonthProductDetail.size());
                        ListMonthProductDetail.add(ProductDetail);
                    } else {
                        out.println("enter else");
                        ListMonthProductDetail = convertor.checkArrayGotSame(ProductDetail, ListMonthProductDetail);
                    }

                    // out.println("price " + price);
                    monthlyReport.setCOGS(monthlyReport.getCOGS() + monthlyReport.getPrice());
                    // out.println(" COGS " + COGS);
                    
                }
            }
            out.println("size " + ListMonthProductDetail.size());
            for (int ii = 0; ii < ListMonthProductDetail.size(); ii++) {
                System.out.println(ListMonthProductDetail.get(ii).getBarcode());
            }
            monthlyReport.setEarning(monthlyReport.getProductSales() - monthlyReport.getCOGS());
            monthlyReport.setNoOfSales(allMonthTransDetail.size());
            monthlyReport.setMargin((monthlyReport.getEarning() / monthlyReport.getProductSales()) * 100);
            System.out.println("monthly report : " + monthlyReport.getCOGS() + " " + monthlyReport.getEarning() + " " + monthlyReport.getMargin() + " " + monthlyReport.getNoOfSales() + " " + monthlyReport.getProductSales());

//------------------------------yearly calender----------------------------------------------------------------
           
            
            yearlyReport.setStarting(Integer.toString(c.get(Calendar.YEAR)) + "-01-01");
            yearlyReport.setEnding(Integer.toString(c.get(Calendar.YEAR)) + "12-31");
            System.out.println("today yearly start " +  yearlyReport.getStarting());
            System.out.println("today yearly end " + yearlyReport.getEnding());
//------------------------------yearly ----------------------------------------------------------

            List YearlyList = transSessionBean.searchWeeklyWithDate(name, yearlyReport.getStarting(), yearlyReport.getEnding());
            ArrayList<TransDetail> allYearlyTransDetail = new ArrayList<TransDetail>();
            ArrayList<productdetail> ListYearlyProductDetail = new ArrayList<productdetail>();
            Iterator iteratorYearlyList = YearlyList.iterator();
            while (iteratorYearlyList.hasNext()) {

                //Login loopAccount = (Login) i.next();
                TransDetail loopYearlyTransDetail = (TransDetail) iteratorYearlyList.next();
                TransDetail transDetail = new TransDetail();
                //Login account = new Login();
                transDetail.setNo(loopYearlyTransDetail.getNo());
                transDetail.setId(loopYearlyTransDetail.getId());
                transDetail.setDate(loopYearlyTransDetail.getDate());
                transDetail.setTime(loopYearlyTransDetail.getTime());
                transDetail.setTotal(loopYearlyTransDetail.getTotal());
                transDetail.setTransid(loopYearlyTransDetail.getTransid());
                allYearlyTransDetail.add(transDetail);
            }

            System.out.println("allYearlyTransDetail size = " + allYearlyTransDetail.size());

            for (int ii = 0; ii < allYearlyTransDetail.size(); ii++) {
                //out.println(allTransDetail.get(ii).getNo());
                yearlyReport.setProductSales(yearlyReport.getProductSales() + Integer.parseInt(allYearlyTransDetail.get(ii).getTotal()));
                List salesList = salesSessionBean.viewSalesTransaction(name, allYearlyTransDetail.get(ii).getTransid());
                //  out.println(" list " + salesList + "xxx");
                Iterator iterator = salesList.iterator();
                while (iterator.hasNext()) {

                    //Login loopAccount = (Login) i.next();
                    Sales loopSalesDetail = (Sales) iterator.next();

                    yearlyReport.setPrice(convertor.getProductPrice(productSessionBean.searchProductbyIDnBarcode(name, loopSalesDetail.getBarcode())) * loopSalesDetail.getQuantity());
                    ProductDetail = new productdetail();
                    ProductDetail.setBarcode(loopSalesDetail.getBarcode());
                    ProductDetail.setQuantity(loopSalesDetail.getQuantity());
                    yearlyReport.setProductPrice(convertor.getSellingProductPrice(productSessionBean.searchProductbyIDnBarcode(name, loopSalesDetail.getBarcode())));
                    ProductDetail.setSellingprice(Double.toString(yearlyReport.getProductPrice()));
                    if (ListYearlyProductDetail.size() == 0) {
                        out.println("in" + ListYearlyProductDetail.size());
                        ListYearlyProductDetail.add(ProductDetail);
                    } else {
                        out.println("enter else");
                        ListYearlyProductDetail = convertor.checkArrayGotSame(ProductDetail, ListYearlyProductDetail);
                    }

                    // out.println("price " + price);
                    yearlyReport.setCOGS(yearlyReport.getCOGS() + yearlyReport.getPrice());
                    // out.println(" COGS " + COGS);
                    
                }
            }
            out.println("size " + ListYearlyProductDetail.size());
            for (int ii = 0; ii < ListYearlyProductDetail.size(); ii++) {
                System.out.println(ListYearlyProductDetail.get(ii).getBarcode());
            }
            yearlyReport.setEarning(yearlyReport.getProductSales() - yearlyReport.getCOGS());
            yearlyReport.setNoOfSales(allYearlyTransDetail.size());
            yearlyReport.setMargin((yearlyReport.getEarning() / yearlyReport.getProductSales()) * 100);
            System.out.println("yearly report : " + yearlyReport.getCOGS() + " " + yearlyReport.getEarning() + " " + yearlyReport.getMargin() + " " + yearlyReport.getNoOfSales() + " " + yearlyReport.getProductSales());


//------------------------------send to jsp ------------------------------------------------------
            request.setAttribute("currentReport", currentReport);
            request.setAttribute("ListProductDetail", ListProductDetail);
            request.setAttribute("weeklyReport", weeklyReport);
            request.setAttribute("ListWeeklyProductDetail", ListWeeklyProductDetail);
            request.setAttribute("monthlyReport", monthlyReport);
            request.setAttribute("ListMonthProductDetail", ListMonthProductDetail);
            request.setAttribute("yearlyReport", yearlyReport);
            request.setAttribute("ListYearlyProductDetail", ListYearlyProductDetail);
            RequestDispatcher rd = request.getRequestDispatcher("report.jsp");
            rd.forward(request, response);
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
