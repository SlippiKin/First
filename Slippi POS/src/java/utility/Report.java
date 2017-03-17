/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author INSPIRON 15
 */
public class Report {

    double productSales;
    double COGS;
    int noOfSales;
    double Earning;
    double Margin;
    double price;
    double productPrice;
    String starting;
    String ending;

    public String getStarting() {
        return starting;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }

    public String getEnding() {
        return ending;
    }

    public void setEnding(String ending) {
        this.ending = ending;
    }

   
    public Report() {
        this.productSales = 0;
        this.COGS = 0;
        this.noOfSales = 0;
        this.Earning = 0;
        this.Margin = 0;
        this.price = 0;
        this.productPrice = 0;
        this.starting = "";
        this.ending = "";
        
    }

    public double getProductSales() {
        return productSales;
    }

    public void setProductSales(double productSales) {
        this.productSales = productSales;
    }

    public double getCOGS() {
        return COGS;
    }

    public void setCOGS(double COGS) {
        this.COGS = COGS;
    }

    public int getNoOfSales() {
        return noOfSales;
    }

    public void setNoOfSales(int noOfSales) {
        this.noOfSales = noOfSales;
    }

    public double getEarning() {
        return Earning;
    }

    public void setEarning(double Earning) {
        this.Earning = Earning;
    }

    public double getMargin() {
        return Margin;
    }

    public void setMargin(double Margin) {
        this.Margin = Margin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

}
