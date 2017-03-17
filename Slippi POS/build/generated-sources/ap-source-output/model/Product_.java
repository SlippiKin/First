package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Login;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-18T23:09:23")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, Integer> no;
    public static volatile SingularAttribute<Product, String> originalprice;
    public static volatile SingularAttribute<Product, String> gst;
    public static volatile SingularAttribute<Product, String> proname;
    public static volatile SingularAttribute<Product, String> shelflocation;
    public static volatile SingularAttribute<Product, byte[]> productimage;
    public static volatile SingularAttribute<Product, String> minimumquantity;
    public static volatile SingularAttribute<Product, String> sname;
    public static volatile SingularAttribute<Product, String> sellingprice;
    public static volatile SingularAttribute<Product, String> currentquantity;
    public static volatile SingularAttribute<Product, Login> id;
    public static volatile SingularAttribute<Product, String> category;
    public static volatile SingularAttribute<Product, String> barcode;

}