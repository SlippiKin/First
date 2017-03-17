/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import model.Product;
import model.Sales;
import model.TransDetail;
import session.ProductSessionBean;
import session.SalesSessionBean;
import session.TransSessionBean;

/**
 *
 * @author INSPIRON 15
 */
public class Convertor {

    public double getProductPrice(Product p) {
        double price = 0;
        price = Double.parseDouble(p.getOriginalprice());
        return price;
    }

    public double getSellingProductPrice(Product p) {
        double sellingprice = 0;
        sellingprice = Double.parseDouble(p.getSellingprice());
        return sellingprice;
    }

    public productdetail convertor(Product product) {
        productdetail Productdetail = new productdetail();
        Productdetail.setBarcode(product.getBarcode());
        Productdetail.setCategory(product.getCategory());
        Productdetail.setCurrentquantity(product.getCurrentquantity());
        Productdetail.setGst(product.getGst());
        Productdetail.setMinimumquantity(product.getMinimumquantity());
        Productdetail.setOriginalprice(product.getOriginalprice());
        Productdetail.setProname(product.getProname());
        Productdetail.setSellingprice(product.getSellingprice());
        Productdetail.setShelflocation(product.getShelflocation());
        Productdetail.setSname(product.getSname());
        return Productdetail;
    }

    public ArrayList<productdetail> checkArrayGotSame(productdetail pd, ArrayList<productdetail> list) {
        boolean same = false;
        for (int i = 0; i < list.size(); i++) {
            if (pd.getBarcode().equals(list.get(i).getBarcode())) {

                list.get(i).setQuantity(pd.getQuantity() + list.get(i).getQuantity());
                same = true;
                i = list.size();
            }

        }
        if (same == false) {
            list.add(pd);
        }
        return list;
    }

    public Report getReportInfo(ArrayList<TransDetail> allTransDetail, Report currentReport, String name) {
       
        TransSessionBean transSessionBean = new TransSessionBean();

         
        SalesSessionBean salesSessionBean = new SalesSessionBean();
 
        ProductSessionBean productSessionBean = new ProductSessionBean();
        
        productdetail ProductDetail;
        Convertor convertor = new Convertor();
        ArrayList<productdetail> ListProductDetail = new ArrayList<productdetail>();
        Product p = new Product();
        Product productprice = new Product();
        double price = 0;
        for (int ii = 0; ii < allTransDetail.size(); ii++) {
            //out.println(allTransDetail.get(ii).getNo());
            currentReport.setProductSales(currentReport.getProductSales() + Integer.parseInt(allTransDetail.get(ii).getTotal()));
            List salesList = salesSessionBean.viewSalesTransaction(name, allTransDetail.get(ii).getTransid());
            //  out.println(" list " + salesList + "xxx");
            Iterator iterator = salesList.iterator();
            while (iterator.hasNext()) {

                //Login loopAccount = (Login) i.next();
                Sales loopSalesDetail = (Sales) iterator.next();
                System.out.print(name + " " + loopSalesDetail.getBarcode());
                productprice = productSessionBean.searchProductbyIDnBarcode(name, loopSalesDetail.getBarcode());
                price = convertor.getProductPrice(productprice) * loopSalesDetail.getQuantity();

                currentReport.setPrice(price);
                ProductDetail = new productdetail();
                ProductDetail.setBarcode(loopSalesDetail.getBarcode());
                ProductDetail.setQuantity(loopSalesDetail.getQuantity());
                currentReport.setProductPrice(convertor.getSellingProductPrice(productSessionBean.searchProductbyIDnBarcode(name, loopSalesDetail.getBarcode())));
                ProductDetail.setSellingprice(Double.toString(currentReport.getProductPrice()));
                if (ListProductDetail.size() == 0) {
                    System.out.println("in" + ListProductDetail.size());
                    ListProductDetail.add(ProductDetail);
                } else {
                    System.out.println("enter else");
                    ListProductDetail = convertor.checkArrayGotSame(ProductDetail, ListProductDetail);
                }

                // out.println("price " + price);
                currentReport.setCOGS(currentReport.getCOGS() + currentReport.getPrice());
                // out.println(" COGS " + COGS);
            }
        }
        System.out.println("size " + ListProductDetail.size());
        for (int ii = 0; ii < ListProductDetail.size(); ii++) {
            System.out.println(ListProductDetail.get(ii).getBarcode());
        }
        currentReport.setEarning(currentReport.getProductSales() - currentReport.getCOGS());
        currentReport.setNoOfSales(allTransDetail.size());
        currentReport.setMargin((currentReport.getEarning() / currentReport.getProductSales()) * 100);
        return currentReport;
    }

    private SalesSessionBean lookupSalesSessionBeanBean() {
        try {
            Context c = new InitialContext();
            return (SalesSessionBean) c.lookup("java:global/Slippi_POS/SalesSessionBean!session.SalesSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ProductSessionBean lookupProductSessionBeanBean() {
        try {
            Context c = new InitialContext();
            return (ProductSessionBean) c.lookup("java:global/Slippi_POS/ProductSessionBean!session.ProductSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
